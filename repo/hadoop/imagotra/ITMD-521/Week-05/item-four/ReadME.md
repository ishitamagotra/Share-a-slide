# Instructions to Compile and Run the code :

1. Using Power Shell, Start the vagrant by using a command: **vagrant up**
2. Now, start the machine by using the command: **vagrant ssh**
3. Next, Rename the file using the command: **cat 1990-sample.txt 1993-sample.txt  > 9093.txt**
4. Make an input directory using the command: **hadoop fs -mkdir -p input/9093**
5. Next, Copy from your Local machine all the txt files to the input directory using the command: **hadoop fs -copyFromLocal 9093.txt input/9093/**
6. Copy all the Max Temperature java files with the command:**/hadoop-book/ch02-intro/src/main/java$ cp MaxTemperature*.java ~/**
7. Navigate to home directory using the command: **cd~**
8. Now do an **ls** to see whether all the txt files which were copied from the local system into the input directory are available. 
9. Using, **vi** or **vim** make changes to MaxTemperatureMapper.java , MaxTemperatureReducer.java , MaxTemperature.java , MaxTemperatureWithCombiner.java.
10. To rename the file now follow the command: **mv MaxTemperatureMapper.java MaxTempPerLattitudeMapper.java** ,
                                               **mv MaxTemperatureReducer.java MaxTempPerLattitudeReducer.java** ,
                                               **mv MaxTemperature.java MaxTempPerLattitude.java**.
                                               **mv MaxTemperatureWithCombiner.java MaxTempPerLattitudeWithCombiner.java**
                                               
                                               
11. Compile all the java files using the command: hadoop com.sun.tools.javac.Main MaxTempPerLattitude*.java
12. Create a jar file as: jar cf ml.jar MaxTempPerLattitude*.class
13. To, find the output use the command: **hadoop jar ml.jar MaxTempPerLattitude input/9093/9093.txt /out1/9093/2**.This will perform a map reduce task. 
14. Final output will be displayed using the command: **hadoop fs -cat out1/9093/2/part-r-00000**.


# Assumptions Made in code: MaxTempPerLattitudeMapper.java
1. Consider only the southern hemisphere, Firstly sorted out the Lattitude values having '-'
2.Now, we collect only the first two digits of the Lattitude values, since they are already 1000 times the original in the dataset.
3. Followed by this we, wrote a If statement, consolidating the values for every 10 increments.
4. Finally, we validated all the values with airTemperature, and sent them to the reducer with key/value pairs.

# Assumptions Made in code: MaxTempPerLattitudeReducer.java
1. Here, we made the key/value pairs, key as a Text element which was initialized in If statement previously in the Mapper.
2. The value as airTemperature,to find the MAX temperature by doing groupby among the 'Key'.

# Output is as follows:
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-05/item-four/item-4.1.JPG)

# Job History 
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-05/item-four/jb.JPG)
