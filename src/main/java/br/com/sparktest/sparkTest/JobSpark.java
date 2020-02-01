package br.com.sparktest.sparkTest;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobSpark implements Job {
	// instancia Spark
	SparkConf conf = new SparkConf();

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {

			// configs do Spark
			conf.setAppName("Spark MultipleContest Test");
			conf.set("spark.driver.allowMultipleContexts", "true");
			conf.setMaster("local");

			SparkContext sc = new SparkContext("local", "spark-mysql-test", conf);
			SQLContext sqlContext = new SQLContext(sc);

			// Dataframe Select mysql
			String sql = "entidade";
			DataFrame dataFrame = sqlContext.read().format("jdbc").option("url",
					"jdbc:mysql://localhost/basespark?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC")
					.option("user", "root").option("password", "root").option("dbtable", sql).load();

			// Resultado do Select
			System.out.println("Em execução..." + dataFrame.showString(3, false));

			// Saida txt file

			sc.stop();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
