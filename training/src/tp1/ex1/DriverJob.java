package tp1.ex1;
 
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class DriverJob {

  public static void main(String[] args) throws Exception {

    /*
     * Verifier qu'il s'agit de 2 arguments
     */
    if (args.length != 2) {
      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
      System.exit(-1);
    }

    /*
     * La configuration. 
     */
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf,"ventes par  magasin");
   
    
  
    //nom du job 
    job.setJarByClass(DriverJob.class);
    job.setJobName("Stub Driver");
    
    //nom du mapper 
    job.setMapperClass(MapperExemple1.class);
    
    //nom du reducer
    job.setReducerClass(ReducerExemple1.class);
    
    //Configuration de input et output
    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(FloatWritable.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

  
    boolean success = job.waitForCompletion(true);
    System.exit(success ? 0 : 1);
  }
}