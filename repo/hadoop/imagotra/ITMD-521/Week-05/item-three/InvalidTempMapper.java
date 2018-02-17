import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class InvalidTempMapper
  extends Mapper<LongWritable, Text, Text, Text> {
  private static final int MISSING = 999999;
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    String year = line.substring(15, 19);
    String stationID = line.substring(4, 10);
    int airTemperature;
    if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
      airTemperature = Integer.parseInt(line.substring(88, 92));
    } else {
      airTemperature = Integer.parseInt(line.substring(87, 92));
    }
    String quality = line.substring(92, 93);
    //&& airTemperature == 9999
    if (Integer.parseInt(stationID) != 999999) {
      context.write(new Text("test"), new Text(String.valueOf(stationID+"_"+airTemperature)));
    }
  }
}
