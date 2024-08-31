package com.aryak

import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

import java.util.Properties
import scala.io.Source

object App extends Serializable {

  @transient private lazy val log = Logger.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .config(getSparkConf)
      .getOrCreate();

    spark.close()
    log.info("Hi")
  }

  def getSparkConf : SparkConf = {

    val sparkConf = new SparkConf()
    val props = new Properties()
    props.load(Source.fromFile("spark.conf").bufferedReader())
    props.forEach((k,v) => sparkConf.set(k.toString, v.toString))
    sparkConf
  };

}