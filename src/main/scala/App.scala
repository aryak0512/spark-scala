package com.aryak

import org.apache.spark.sql.SparkSession

object App extends Serializable {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder()
      .appName("")
      .master("local[*]")
      .getOrCreate();

    spark.close()
    println("Hello world!")
  }

}