package tp1.ex1;
 
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerExemple1 extends Reducer<Text, FloatWritable, Text, FloatWritable> {

  @Override
  public void reduce(Text key, Iterable<FloatWritable> values, Context context)
      throws IOException, InterruptedException {
	

	  float salesTotal=0;
	  for(FloatWritable value : values){
		   salesTotal+=value.get();
	   }
	   context.write(key, new FloatWritable(salesTotal));
  }
}