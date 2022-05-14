package com.vivek;

import org.apache.ignite.spark.IgniteDataFrameSettings;
import org.apache.spark.SparkException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
public class StartMainUsingSparkLocal {

    private static final String CONFIG = "/Users/vivek/Documents/spaceandtime/apache-ignite-2.13.0-bin/examples/config/spark/example-shared-rdd.xml";

    private static final String CACHE_NAME = "testCache";

    public static void main(String args[]) throws SparkException  {

        SparkSession spark = SparkSession
                .builder()
                .appName("JavaIgniteDataFrameJoinExample")
                .master("local")
                .config("spark.executor.instances", "1")
                .getOrCreate();

        Dataset<Row> df = spark.read()
                .format(IgniteDataFrameSettings.FORMAT_IGNITE()) //Data source type.
                .option(IgniteDataFrameSettings.OPTION_TABLE(), "City") //Table to read.
                .option(IgniteDataFrameSettings.OPTION_CONFIG_FILE(), CONFIG) //Ignite config.
                .load();

        Dataset<Row> igniteDF = spark.sql("SELECT * FROM City");
        System.out.println("Result schema:");
        igniteDF.printSchema(); //Printing query schema to console.
        System.out.println("Result content:");
        igniteDF.show();
    }
}
