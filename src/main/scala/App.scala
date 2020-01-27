import java.io.File

import org.apache.spark.sql.{Row, SaveMode, SparkSession}

object App {
  def main(args: Array[String]): Unit = {
    val warehouseLocation = new File("/Users/jacob/dev/spark-2.1.0-bin-hadoop2.7/bin/spark-warehouse").getAbsolutePath

    val spark = SparkSession.builder().appName("Spark Hive Example").master("local[*]").config("spark.sql.warehouse.dir", warehouseLocation).enableHiveSupport().getOrCreate()

//    val spark= SparkSession.builder.master("spark://127.0.0.1:7077").enableHiveSupport().getOrCreate()


    import spark.implicits._
    import spark.sql
    val tables = spark.catalog.listTables()
    tables.show()
    sql("show databases").show()
  }
}
