1 d. $SPARK_HOME/bin/spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

import com.databricks.spark.avro._


val sqlContext = new org.apache.spark.sql.SQLContext(sc)


val categories= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/category/categories.avro")


categories.show()



For Products: 

import com.databricks.spark.avro._


val sqlContext = new org.apache.spark.sql.SQLContext(sc)


val products= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/products/products.avro")


products.show()




1 e. import com.databricks.spark.avro._
     val sqlContext = new org.apache.spark.sql.SQLContext(sc)
     val prd = sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/products/products.avro")

     import org.apache.spark.rdd.RDD
     import org.apache.spark.sql.Row
     val df = prd.selectExpr("_1","_2","_3","cast(_4 as float) _4","_5")
     val rdd_rws: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = df.rdd
     val Nrdd = rdd_rws.filter(t => (t(3) != null))
     
     val srcrdd = Nrdd.map(_.mkString(","))
     val a = srcrdd.map(_.split(",")).filter(_(3).toFloat < 100)
     val msp = a.map(_.mkString(","))

     msp.coalesce(1).saveAsTextFile("hdfs://localhost/user/vagrant/output/4/")
     hadoop fs -cat output/4/part-00000


1f. import com.databricks.spark.avro._
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val prd= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/products/products.avro")
    import org.apache.spark.rdd.RDD
    import org.apache.spark.sql.Row
    val df = prd.selectExpr("_1","_2","_3","cast(_4 as float) _4","_5")
    val rdd_rws: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = df.rdd
    val Nrdd = rdd_rws.filter(t => (t(3) != null))
    val srcrdd = Nrdd.map(_.mkString(","))
    val a = srcrdd.map(_.split(",")).filter(_(3).toFloat < 100)
    val msp = a.map(_.mkString(","))

   import com.databricks.spark.avro._
   val sqlContext = new org.apache.spark.sql.SQLContext(sc)
   val category= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/category/categories.avro")
   case class products(product_id: String, category_id: String, product_name: String, price: String, link: String)
   val text = msp.map(line => line.split(",").map(_.trim))
   val prd = text.map{case Array(s0, s1, s2, s3,s4) => product(s0, s1, s2, s3,s4)}.toDF
   val catgry_seqn = Seq("category_id", "category_name")
   val catgrydf = category.toDF(catgry_seqn: _*)
   val catgry = catgrydf.selectExpr("category_id","category_name")
   val joining_df = catgry.join(prd, "category_id")

    import org.apache.spark.sql.expressions.Window
    val bdf =  joining_df.select(col("category_id"), col("category_name"), col("product_name"), col("price") ,row_number().over(Window.partitionBy(col("category_id")).orderBy(col("price").desc)).alias("Row_Num"))
    val filldf = bdf.where(bdf("Row_Num") <=10)
    val selctDF = filldf.select(col("category_name"),col("product_name"),col("price"))
    val sortingdf = selctdf.sort(col("category_name"),col("product_name"),col("price"))
    val rdd_f: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = sortingdf.rdd
    val rdd_df = rdd_f.map(_.mkString("\t"))
    rdd_df.coalesce(1).saveAsTextFile("hdfs://localhost/user/vagrant/output/5/")
    hadoop fs -cat output/5/part-00000
     


1 g.     import com.databricks.spark.avro._
        val sqlContext = new org.apache.spark.sql.SQLContext(sc)
        val prd= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/products/products.avro")

        import org.apache.spark.rdd.RDD
        import org.apache.spark.sql.Row
        val df = prd.selectExpr("_1","_2","_3","cast(_4 as float) _4","_5")
        val rdd_rws: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = df1.rdd
        val Nrdd = rdd_rws.filter(t => (t(3) != null))
        val srcrdd = Nrdd.map(_.mkString(","))
        val a = srcrdd.map(_.split(","))
        val msp = a.map(_.mkString(","))

        import com.databricks.spark.avro._
        val sqlContext = new org.apache.spark.sql.SQLContext(sc)
        val category= sqlContext.read.avro("hdfs://localhost/user/vagrant/sparkdataset/category/categories.avro")
        case class products(product_id: String, category_id: String, product_name: String, price: String, link: String)
        val text = msp.map(line => line.split(",").map(_.trim))
        val prod = txt.map{case Array(s0, s1, s2, s3,s4) => product(s0, s1, s2, s3,s4)}.toDF
        val catgr_seqn = Seq("category_id", "category_name")
        val catgrydf = category.toDF(catgry_seqn: _*)
        val catgry = catgrydf.selectExpr("category_id","category_name")
        val joining_df = catgry.join(pro, "category_id")

        import org.apache.spark.sql.expressions.Window
        val maximum_seqn = Seq("category_id", "category_name", "highest_product_name", "highest_product_price","Row_Num_high")
        val minimum_seqn = Seq("category_id", "category_name_low", "lowest_product_name", "lowest_product_price","Row_Num_low")

        val maximum_df =  joining_df.select(col("category_id"), col("category_name"), col("product_name"), col("price")        ,row_number().over(Window.partitionBy(col("category_id")).orderBy(col("price").desc)).alias("Row_Num"))
         val maximumdf = maximum_df.where(maximum_df("Row_Num") <= 1)
         val minimum_df =  joining_df.select(col("category_id"), col("category_name"), col("product_name"), col("price") ,row_number().over(Window.partitionBy(col("category_id")).orderBy(col("price").asc)).alias("Row_Num"))
         val minimumdf = minimum_df.where(minimum_df("Row_Num") <= 1)
         val highestdf = maximumdf.toDF(maximum_seqn: _*)
         val lowestdf = minimumdf.toDF(minimum_seqn: _*)
         val prsdf = highestdf.join(lowestdf,"category_id")
         val fndf =   prsdf.select(col("Category_name"),col("highest_product_name"),col("highest_product_price"),col("lowest_product_name"),col("lowest_product_price"))
         fndf.collect().foreach(println)


        val rdd_fn: org.apache.spark.rdd.RDD[org.apache.spark.sql.Row] = fndf.rdd
        val rdd_d = rdd_fn.map(_.mkString("|"))
        
        rdd_d.coalesce(1).saveAsTextFile("hdfs://localhost/user/vagrant/output/1g/9/")
        finalDF.coalesce(1).write.avro("hdfs://localhost/user/vagrant/output/1g/10/")
        hadoop fs -cat output/1g/9/part-00000
        hadoop fs -cat output/1g/10/part-00000