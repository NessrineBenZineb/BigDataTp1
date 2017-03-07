package tp1.ex4;
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperExemple4 extends Mapper<LongWritable, Text, Text, FloatWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  FloatWritable c = new FloatWritable();
	 Text t= new Text ();
	 float som=0;
	  String cost;
	  String s = value.toString();

	   String[] result = s.split("\t");
	   
	    	if (result.length==6){
	    		
	    		
	    		
	    		 cost = result[4];
	    		 som+=Float.valueOf(cost);
	    		
	    		t.set("clé");
	    	
	    		
	    		 c.set(Float.valueOf(som));
	    		 
	    		  context.write(t, c);
	    	
	    		

	    		
	    	}

  }

}