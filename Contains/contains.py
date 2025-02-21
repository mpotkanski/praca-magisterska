from time import perf_counter
import random
import sys
from sortedcontainers import SortedSet
from sortedcontainers import SortedDict

def my_function():
  s = list(range(0,10000000))
  s2 = list(range(0,10000000))
  
  for i in range(0, 10000000):
    s[i] = str(s[i])
    s2[i] = str(s2[i]*2)
    
  random.shuffle(s)
  random.shuffle(s2)
  
  counts = set()
  sorted_set = SortedSet()
  dict1 = {}
  dict2 = SortedDict()
  
  for i in range(0, 10000000):
      counts.add(s[i])
      sorted_set.add(s[i])
      dict1[s[i]] = s[i]
      dict2[s[i]] = s[i]
      
  for j in range(0,5):
    
    # Start the stopwatch / counter 
    t1_start = perf_counter() 
  
    for i in range(0, 10000000):
      s2[i] in counts

    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("set: ", t1_stop-t1_start)

  for j in range(0,5):
    
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      s2[i] in sorted_set
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedSet: ", t1_stop-t1_start)
    
  for j in range(0,5):
  
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      s2[i] in dict1
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("Dictionary: ", t1_stop-t1_start)
    	
  for j in range(0,5):
  
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      s2[i] in dict2
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedDict: ", t1_stop-t1_start)
          
my_function()

