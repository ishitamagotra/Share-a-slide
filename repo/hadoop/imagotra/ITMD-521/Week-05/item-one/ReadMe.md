# Instructions to Compile and Run the code :

1. Using Power Shell, Start the vagrant by using a command: **vagrant up**
2. Now, start the machine by using the command: **vagrant ssh**
3. Next, Rename the file using the command: **cat 1990-sample.txt 1991-sample.txt 1992-sample.txt 1993-sample.txt > 90919293.txt**
4. Make an input directory using the command: **hadoop fs -mkdir -p ima/ncdc/90919293/**
5. Next, Copy from your Local machine all the txt files to the input directory using the command: **hadoop fs -copyFromLocal 90919293.txt ima/ncdc/90919293**
6. Copy all the Max Temperature java files with the command:**/hadoop-book/ch02-intro/src/main/java$ cp MaxTemperature*.java ~/**
7. Navigate to home directory using the command: **cd~**
8. Now do an **ls** to see whether all the txt files which were copied from the local system into the input directory are available. 
9. Using, **vi** or **vim** make changes to MaxTemperatureMapper.java , MaxTemperatureReducer.java , MaxTemperature.java , MaxTemperatureWithCombiner.java files.
10. To rename the file now follow the command: **mv MaxTemperatureMapper.java HighestvisibilityperyearMapper.java** ,
                                               **mv MaxTemperatureReducer.java HighestvisibilityperyearReducer.java** ,
                                               **mv MaxTemperature.java Highestvisibilityperyear.java** ,
                                               **mv MaxTemperatureWithCombiner.java HighestvisibilityperyearWithCombiner.java**
11. Compile all the java files using the command: hadoop com.sun.tools.javac.Main Highestvisibilityperyear*.java
12. Create a jar file as: jar cf hv.jar Highestvisibilityperyear*.class
13. To, find the output use the command: **hadoop jar hv.jar Highestvisibilityperyear ima/ncdc/90919293/90919293.txt output/ncdc/90919293/17**. This will perform a map reduce task. 
14. Final output will be displayed using the command:**hadoop fs -cat output/ncdc/90919293/17/part-r-00000** 

                                         
                                         

# Screenshot of Output of Highest Visibility
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-05/item-one/output.JPG)







# Screenshot of History Server to show the successful completion of the job
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-05/item-one/Jobhistory.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-05/item-one/JH1.JPG)
