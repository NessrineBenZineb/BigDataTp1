package tp1.ex3;
 
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

public class DriverJob3 {

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
    Job job = Job.getInstance(conf,"Max de montant du vente par  magasin");
   
    
  
    //nom du job 
    job.setJarByClass(DriverJob3.class);
    job.setJobName("Stub Driver");
    
    //nom du mapper 
    job.setMapperClass(MapperExemple3.class);
    
    //nom du reducer
    job.setReducerClass(ReducerExemple3.class);
    
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