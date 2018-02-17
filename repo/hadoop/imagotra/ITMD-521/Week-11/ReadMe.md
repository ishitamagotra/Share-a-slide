# 1 a. Steps to follow to Create a .sql script named create.sql that will create the database hadoopguide, table widgets, and follow the schema given in the book
Created a sql script **"create.sql"** to create the database named as **'hadoopguide'** and table as **'widgets'** in mysql.**I have also submitted create.sql** It contians the following sql commands:

DROP DATABASE hadoopguide is EXISTS;

CREATE DATABASE hadoopguide;

use hadoopguide;

CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,widget_name VARCHAR(64) NOT NULL,price DECIMAL(10,2),
design_date DATE,version INT,design_comment VARCHAR(100));

# 2. Steps to follow to include a script named step-2.* that will generate 5000 records (based on the 4 sample items given in the text) and INSERT this into the widgets table.

In this step I have written a java code **"step_2.java"** to access ,generate random records on the basis of 4 records shown in the book and insert 
those 5000 records into the widget table in the mysql.

**To access the code open the file "step_2.java" as submitted by me.**

## Output for "step_2.java" are as follows:-
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans2%20hadoop.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans2.1%20hadoop.JPG)

# 3. Steps to follow to include a shell script named: step-3.sh that will execute the Sqoop import as given by the text book

In this step I have created a shell script **"step-3.sh"** to execute the sqoop import statement into the HDFS and the output of hadoop by running the command **hadoop fs -cat widgets/part-m-00000**.

**I have also submitted a part-m-00000 Ans 3 file ans step-3.sh to have full access to the records**. 

## Output: 
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-3.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/map-reduce%20ans%203%20continue.JPG)

# Output of part-m-00000 containing 5000 records
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans3%20hadoop.JPG)

# 4. Steps to follow to Include a shell script named step-4.sh that only import record 1000-3000 for an sqoop import

In this step I have created a shell script **"step-4.sh"** to execute the sqoop import statement of records from 1000 to 3000 into the HDFS using the command **where "id >='1000' and id <='3000'"**  and showing the output of hadoop by running the command **hadoop fs -cat widgets/part-m-00000**.

**I have also submitted a part-m-00000 ans 4 file ans step-4.sh to have full access to the records**.

## Output:
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-4.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/4.JPG)

# Output of part-m-00000 containing 3000 records
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans%204%20output.JPG)

# 5. Steps to follow to Run the MaxWidgetID.java file as detailed under the heading “Working with Imported data”

In order to run the java file , we introduce **SQOOP_HOME=/home/vagrant/sqoop** in ( .bashrc file) in our classpath. Then I made a directory **sqoop_hw** to copy MaxwidgetId.java and Widget.java 

Then, from the Hadoop book chapter-15 we will use the MaxWidgetID.java. We will compile two java file MaxWidgetID.java and Widget.java by running the command 
**hadoop  com.sun.tools.javac.Main MaxWidgetId.java Widget.java**

 And then create a sqoop-exmps.jar by taking all the class file  and run the command**jar cf sqoop-examples*.class**
 
Now in the next step we will run the jar file to find the MaxWidget Id from the HFDS which got imported by sqoop.The output is obtained by the command **hadoop fs -cat maxwidget/part-r-00000**

**I have also submitted a part-r-00000 ans5 to get full access to the output**

## Output:
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-5.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-5%20continue.JPG)

# Output of part-r-00000
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans%20-5%20output.JPG)

# 6. Steps to Modify the MaxWidgetID.java file to find average price for each widget

Here, I have modified the **MaxWidget.java file** and included that file in this assignment. I made a directory named **part6** to copy Widget.java. To compile the code I used the command **hadoop com.sun.tools.javac.Main MaxWidgetId.java Widget.java** Then to create a jar file I used the command   jar cf part6.jar *.class

Finally I used the command  **hadoop jar part6.jar MaxWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar** This produced a Map-Reduce job.
To get the output I used the command **hadoop fs -cat AveragePrice/part-r-00000**

I have also included a **part-r-00000 ans 6** in this assignment

**To access the code use MaxWidget.java file that I have places in this assignment.**

## Output:
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-6.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/mr-6.1.JPG)

# Output of part-r-00000
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans-6.1.JPG)









 





