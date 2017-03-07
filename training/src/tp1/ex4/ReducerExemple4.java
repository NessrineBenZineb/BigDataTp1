package tp1.ex4;
 
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerExemple4 extends Reducer<Text, FloatWritable, Text, FloatWritable> {

  @Override
  public void reduce(Text key, Iterable<FloatWritable> values, Context context)
      throws IOException, InterruptedException {


	  float salesTotal=0;
	  int nb=0;
	  for(FloatWritable value : values){
		   salesTotal+=value.get();
		   nb++;
	   }
	   context.write(new Text(String.valueOf(nb)), new FloatWritable(salesTotal));
  }
}