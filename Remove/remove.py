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
      counts.discard(s2[i])

    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("set: ", t1_stop-t1_start)

    counts.clear()
    
    for i in range(0, 10000000):
      counts.add(s[i])
      
  for j in range(0,5):
    
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      sorted_set.discard(s2[i])
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedSet: ", t1_stop-t1_start)
    
    sorted_set.clear()
    
    for i in range(0, 10000000):
      sorted_set.add(s[i])
      
  for j in range(0,5):
  
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      dict1.pop(s2[i], None)
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("Dictionary: ", t1_stop-t1_start)
    
    dict1.clear()
    	
    for i in range(0, 10000000):
      dict1[s[i]] = s[i]
      
  for j in range(0,5):
  
    # Start the stopwatch / counter 
    t1_start = perf_counter() 

    for i in range(0, 10000000):
      dict2.pop(s2[i], None)
		
    # Stop the stopwatch / counter
    t1_stop = perf_counter()

    print("SortedDict: ", t1_stop-t1_start)
    
    dict2.clear()
    
    for i in range(0, 10000000):
      dict2[s[i]] = s[i]
         
my_function()

