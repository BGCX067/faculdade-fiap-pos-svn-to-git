package br.com.exemplo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


/**
 * Hello world!
 *
 */
@Configuration
@ImportResource("classpath:spring-batch.xml")
public class App 
{
    public static void main( String[] args ) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
    {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		Job job = (Job) context.getBean("jobMonitoramentoTiss2");

		jobLauncher.run(job, new JobParameters());
        
    }
}
