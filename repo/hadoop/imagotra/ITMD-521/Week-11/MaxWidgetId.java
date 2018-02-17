import java.io.IOException;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import java.math.BigDecimal;
import java.util.*;


public class MaxWidgetId extends Configured implements Tool {

  public static class MaxWidgetMapper
      extends Mapper<LongWritable, Text, Text, FloatWritable> {


    public void map(LongWritable lw, Text txt, Context cxt)throws IOException, InterruptedException {
      Widget wget = new Widget();
      try {
        wget.parse(txt);
      } catch (ParseError perr) {
        return;
      }

      String widgtname = wget.get_widget_name();
      BigDecimal bgdec = wget.get_price();
	
      float priceValue = bgdec.floatValue();
     cxt.write(new Text(widgtname),new FloatWritable(priceValue));
    }
  }

  public static class MaxWidgetReducer
      extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    public void reduce(Text txt, Iterable<FloatWritable> vl, Context cxt)
        throws IOException, InterruptedException {

    	float countValue = 0f;
      float sumValue = 0f;
      
	
      for (FloatWritable value : vl) {
       
       sumValue += value.get();
       countValue += 1;
       
      }

      float floatAveragePrice = sumValue/countValue;
      cxt.write(txt, new FloatWritable(floatAveragePrice));
    }
  }

  public int run(String [] args) throws Exception {
    Job jobObject = new Job(getConf());

    jobObject.setJarByClass(MaxWidgetId.class);

    jobObject.setMapperClass(MaxWidgetMapper.class);
    jobObject.setReducerClass(MaxWidgetReducer.class);

    String maxWidget = "MaxWidget";
    String widgets = "widgets";
    
    FileInputFormat.addInputPath(jobObject, new Path("widgets"));
    FileOutputFormat.setOutputPath(jobObject, new Path("MaxWidget"));

    jobObject.setMapOutputKeyClass(Text.class);
    jobObject.setMapOutputValueClass(FloatWritable.class);

    jobObject.setOutputKeyClass(Text.class);
    jobObject.setOutputValueClass(FloatWritable.class);

    jobObject.setNumReduceTasks(1);

    if (!jobObject.waitForCompletion(true)) {
      return 1;
    }

    return 0;
  }

  public static void main(String [] args) throws Exception {
    int toolObject = ToolRunner.run(new MaxWidgetId(), args);
    System.exit(toolObject);
  }
}
