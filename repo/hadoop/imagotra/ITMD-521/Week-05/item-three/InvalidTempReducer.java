import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class InvalidTempReducer
  extends Reducer<Text, Text, Text, Text> {
  @Override
  public void reduce(Text key, Iterable<Text> values,
      Context context)
      throws IOException, InterruptedException {
       List<String> year = new ArrayList<String>();
       List<Integer> temp = new ArrayList<Integer>();
      Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
      int i=0;
      for(Text value: values)
       {
         String party = value.toString();
         String[] parts = party.split("_");
         year.add(parts[0]);
         temp.add(Integer.parseInt(parts[1]));
         i++;
       }
      for(i=0; i< year.size(); i++)
       {
         if(map.get(year.get(i))== null)
           map.put(year.get(i), new ArrayList<Integer>());
         map.get(year.get(i)).add(temp.get(i));
       }
      Map<String, Double> mapPer = new HashMap<String, Double>();
       Map<String, String> maptest = new HashMap<String, String>();
      for (Entry<String, List<Integer>> entry : map.entrySet()) {
          String keys = entry.getKey();
          List<Integer> value = entry.getValue();
          double count = 0;
          double totalcount = 0;
          double percent =0;
          for(int d : value)
          {
            totalcount++;
            if(d == 9999)
            count++;
          }
      percent = (count*100)/totalcount;
          mapPer.put(keys,percent);
          maptest.put(keys,count+"_"+totalcount);
      }
      Double maxValue = Double.MIN_VALUE;
      for (Entry<String, Double> entry : mapPer.entrySet()) {
        String keys = entry.getKey();
        Double value = entry.getValue();
        maxValue = Math.max(maxValue, value);
        }
      String stationID  = "T";
      Map<String, Double> mapFinal = new HashMap<String, Double>();
      for (Entry<String, Double> entry : mapPer.entrySet()) {
        String keys = entry.getKey();
        Double value = entry.getValue();
        int retval = Double.compare(value, maxValue);
        if(retval == 0)
        {
          mapFinal.put(entry.getKey(),maxValue);
          stationID = stationID + "_" +entry.getKey();
        }
     }
for (Entry<String, Double> entry : mapFinal.entrySet()) {
        context.write(new Text(String.valueOf(entry.getKey())), new Text(String.valueOf(entry.getValue())));
     }
  }
}
