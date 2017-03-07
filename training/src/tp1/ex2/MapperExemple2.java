package tp1.ex2;
import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperExemple2 extends Mapper<LongWritable, Text, Text, FloatWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  FloatWritable c = new FloatWritable();
	  String item;
		
	  String cost;
	  String s = value.toString();

	   String[] result = s.split("\t");
	   
	    	if (result.length==6){
	    		
	    		 item = result[3];
	    		
	    		 cost = result[4];
	    		
	    		 Text outputKey = new Text(item.toUpperCase().trim());
	    		
	    		 c.set(Float.valueOf(cost));
	    		 
	    		  context.write(outputKey, c);
	    	
	    		

	    		
	    	}

  }

}