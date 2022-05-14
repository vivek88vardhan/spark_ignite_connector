package com.vivek;

import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.ignite.IgniteSparkSession;

public class StartMainIgniteSpark {
    private static final String CONFIG = "/Users/vivek/Documents/spaceandtime/apache-ignite-2.13.0-bin/examples/config/spark/example-shared-rdd.xml";

    public static void main(String args[]) throws AnalysisException {

        IgniteSparkSession igniteSession = IgniteSparkSession.builder()
                .appName("Spark Ignite catalog example")
                .master("local")
                .config("spark.executor.instances", "2")
                .igniteConfig(CONFIG)
                .getOrCreate();

        igniteSession.catalog().listTables().show();

    }
}
