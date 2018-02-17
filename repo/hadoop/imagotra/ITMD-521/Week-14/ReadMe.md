# TEST 1
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 4 reducers took the least time to finish the job
2. The Text file as input and with 1 reducer has taken the maximum time
3. For reducer 1, the GZ file as input has taken the least MapReduce time
4. For 2 reducer, the Text file as input has taken the least MapReduce time
5. For 4 reducer Text file as input has taken the least MapReduce time
6. For 8 reducer Text file as input has taken the least MapReduce time
7. Hence, Bz input file is taking more time than Gz input file (except for 8 Reducer Bz) but less than Text file.
## Analysis  for Test 1
The Text file as input and with 4 reducers is consuming the least MapReduce time because there are 69 splits in the text file which are processed in a parallel fashion. Now, with the data having an input memory of 8.4 gb Text file with 8 reducers would function in the best manner. (Last paragraph of Page no. 123)

# TEST 2
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%202%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%202.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Gz file as input and with 2 reducers took the least time to finish the job
2. The Text file as input and with 4 reducer has taken the maximum time
3. For reducer 1, the GZ file as input has taken the least MapReduce time
4. For reducer 2, the Text file as input has taken the least MapReduce time
5. For reducer 4, Gz file as input has taken the least MapReduce time
6. For reducer 8, Bz file as input has taken the least MapReduce time
7. Hence the Text and Gz input files are more efficient than the Bz file (except for 8 reducer Bz)  
## Analysis  for Test 2
This MapReduce process is not dependent on the format of the input.
However, this is the best MapReduce process for having a low MapReduce time which is very effective and we didn't got such outcomes from the result of the Test 2 that is due to the excessive number of failures seen in the MapReduce procedure. It might be taken into consideration because of poor machine arrangement. The procedure is quicker because of the quick transfer rate between the input of the reducer and the output of the map. (Page no. 126)

# TEST 3
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%203%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%203.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 4 reducers took the least time to finish the job
2. The Text file as input and with 1 reducer has taken the maximum time
3. For reducer 1, the Gz file as input has taken the least MapReduce time
4. For reducer 2, the Gz file as input has taken the least MapReduce time
5. For reducer 4, Text file as input has taken the least MapReduce time
6. For reducer 8, Text file as input has taken the least MapReduce time
7. Hence the Text input file is more efficient than the Bz file and the GZ file.

## Analysis for Test 3
The transfer rate between the mapper and the reducer is lowered because of the combiner class which is like a reducer for the output of the map phase and the result is passed on to the reducer wherein the the functionality of the work that is done by the reducer is decreased.
The least MapReduce time is taken by the Text file with 4 reducers because the text file has 69 splits, which are parallelly processed. So, for the data with input memory of 8.4 gb Text file and with 4 reducers functions in the best manner. (Last paragraph of Page no. 123)
As per the result seen in the cluster it was observed that this was better than Test 2, but the order of test based on efficient map reduce time is as below
Test 2(most efficient)
Test 3
Test 1 

# TEST 4
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%204%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%204.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1.  The Bz file as input and with 2 reducers took the least time to finish the job
2. The Gz file as input and with 2 reducers has taken the maximum time
3. For reducer 1, the Bz file as input has taken the least MapReduce time
4. For reducer 2, the Bz file as input has taken the least MapReduce time
5. For reducer 4, Bz and Text file as input has taken the least MapReduce time rather they took the same time.
6. For reducer 8, Textfile as input has taken the least MapReduce time
7. Hence the Bz input file is the more efficient than the Gz file and Text file (except for 8 Reducer Bz)  
## Analysis for Test 4
Now, the size of the file is really huge upto 103 GB so, the BZ file with 2 reducers have best efficiency when compared to all the map reduce process time.
Th reason as to why the GZ file as input and with 2 reducer has taken the maximum time is because  there can be only one split in the GZ at a time. Due to this the MapReduce time is increased.
But, the Text file did not show upto 770 splits and this might affect the datanodes.

# TEST 5
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%205%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%205.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 2 reducers took the least time to finish the job
2. The Gz file as input and with 1 reducer has taken the maximum time
3. For reducer 1, the Text file as input has taken the least MapReduce time
4. For reducer 2, the Text file as input has taken the least MapReduce time
5. For reducer 4, the Text file as input has taken the least MapReduce time
6. For reducer 8, the Text file as input has taken the least MapReduce time
7. Hence the Text input file is the most efficient than the Gz and Bz file.  

## Analysis for Test 5:
Here, the input file format is independent of the kind of MapReduce process. So, among Test 4, Test 5 and Test 6 the output for the intermediate compression with combiner should be the best for a 103 gb data. Anything can be the best file format. 
Therefore, only one reducer is the good fit for this data.
This is the best test amongst the Test 5, Test 6 and Test 4 in the cluster and it is also true.

# TEST 6
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%206%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%206.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Bz file as input and with 8 reducers took the least time to finish the job
2. The Bz file as input and with 2 reducer has taken the maximum time
3. For reducer 1, the Bz file as input has taken the least MapReduce time
4. For reducer 2, the Text file as input has taken the least MapReduce time
5. For reducer 4, the Text file as input has taken the least MapReduce time
6. For reducer 8, the Bz file as input has taken the least MapReduce time
7. Hence the Text input file is the most efficient than the Gz file (except for 1 reducer Text file) but same as Bz file.

## Analysis for Test 6
In this Test the similar 3 scenarios are seen but with the only exception is that now it is with larger file.
Here the test reside under the second position amongst Test 4, Test 5 and Test 6 and it is true.

# TEST 7
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%207%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%207.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 2 reducers took the least time to finish the job
2. The Bz file as input and with 8 reducer has taken the maximum time
3. For reducer 1, the Text file as input has taken the least MapReduce time
4. For reducer 2, the Text file as input has taken the least MapReduce time
5 For reducer 4, the Text file as input has taken the least MapReduce time
8. For reducer 8, the Text file as input has taken the least MapReduce time
7. Hence the Text input file is the most efficient than the Bz file. 

## Analysis for Test 7
The least time is consumed by the text file with 2 reducers for data of 169gb but in reality this may harm  the data nodes since 1264 is the split number, So in reality, the least time should be taken by BZ.

# TEST 8
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%208%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%208.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 1 reducers took the least time to finish the job
2. The Bz file as input and with 4 reducer has taken the maximum time
3. For reducer 1, the Text file as input has taken the least MapReduce time
4. For reducer 2, the Bz file as input has taken the least MapReduce time
5. For reducer 4, the Text file as input has taken the least MapReduce time
6. For reducer 8, the Text file as input has taken the least MapReduce time
7. Hence the Text input file works the best than the Bz file (except for 2 reducer Text file)

## Analysis for Test 8
This type of a MapReduce process is independent of the input file format.
So, the Test 8 falls is more efficient as compared to Test 7 and Test 9

# TEST 9
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%209%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%209.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 8 reducers took the least time to finish the job
2. The Text file as input and with 2 reducer has taken the maximum time
3. For reducer 1, the Text file as input has taken the least MapReduce time
4. For reducer 2, the Bz file as input has taken the least MapReduce time
5. For reducer 4, the Text file as input has taken the least MapReduce time
6. For reducer 8, the Text file as input has taken the least MapReduce time
7. Hence the Text input file works the best the Bz file (except for 2 reducer Text file)
## Analysis for Test 9
The text file with 8 reducers performs efficiently for 1264 splits, but the data mode is at risk, in reality Bz should have the first occurance.
The observed pattern is :
Test 8,
Test 7
Test 9
But in reality it should be: 
Test 8 
Test 9
Test 7

# TEST 10
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2010%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2010.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 2 reducers has taken the least time to complete the job.
2. The Text file as input and with 1 reducers has taken the maximum time to complete the job.
3.  Hence the Text file works with 2R

## Analysis for Test 10:
The 2 reducer are best suited for the 256 mb block size for 632 splits .


# TEST 11
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2011%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2011.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file with 1 reducers has taken least time taken to complete the job
2. The Text file as input and with 4 reducers has taken the maximum time to complete the job
3. Hence the Text file works with 1 reducer with compression
## Analysis of Test 11 
Since it is intermediate compression, 1 reducer is perfect for the block size of 256 Mb for 632 splits. But inefficiency is seen in the results when compared with Test 10 and Test 12. 

# TEST 12
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2012%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2012.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file with 4 reducers has taken least time taken to complete the job
2. The Text file as input and with 2 reducers has taken the maximum time to complete the job
 3. Hence the Text file works with 4 reducers with combiner

## Analysis Test 12 
In this test, 4 reducers are suitable for a block size of 256 Mb for 632 splits. With proper observation this is first amongst Test 10 test, Test 11 and Test 12

# TEST 13
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2013%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2013.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,

1. The Text file with 2 reducers has taken least time taken to complete the job
2. The Text file as input and with 1 reducers has taken the maximum time to complete the job
3. Hence the Text file works with 2 reducers with combiner
## Analysis for Test 13:
In this test 2 reducers are suitable for a block size of 512 Mb for 316 splits. It falls last amongst Test 13,  Test 14 and Test 15.

# TEST 14
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2014%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2014.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file with 2 reducers has taken least time taken to complete the job
2. The Text file as input and with 1 reducers has taken the maximum time to complete the job
3. Hence the Text file works with 2 reducers with combiner

## Analysis Test 14
Since this is intermediate compression, it is independent of the file format, so 2 reducer is the best suited for it.

# TEST 15
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2015%20graph.JPG)
![IM](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%2015.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file with 1 reducers has taken least time taken to complete the job
2. The Text file as input and with 8 reducers has taken the maximum time to complete the job
3. Hence the Text file works with 1 reducers with combiner

## Analysis for Test 15
In this test, 1 reducer is suitable for a block size of 512 Mb for 316 splits. With proper observation, it falls first amongst Test 13, Test 14 and Test 15

# TEST 16
![im](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%2016%20graph.JPG)

## So from the graph I have observed the following observations,
1. The above output tell the overall execution time comparison for all the 15 tests we have performed.
2. For the gzip files tests with 1 reducer, with combiner and with intermediate compression run fast as compared to other tests.
3. For Text files, with 4 reducers, with combiners and also with intermediate compression runs faster than other tests.
4. For Bz files Tests with 1 reducer, with combiner and also with intermediate compression executes faster than other tests. 

# CONCLUSION
1. Even if the Map Reduce is capable of reading and writing uncompressed data, it is highly beneficial to compress the intermediate map output. The map output is compressed which provides performance gain and the volume of data transfer is reduced..
2. With the help of combiners, the mappers output is reduced which is fed to reducers and also each mapper output is filtered by the combiners and this reduced  the volume of data  that is fed to reducers. Even in this case execution time will decrease.
3. With an increase in the size of the block the execution time is decreased. When the size of dataset is huge, using block of bigger size is very helpful. Because, the data that is handled by the mapper and reduced is also increased. So, there can be decrease in execution time.
