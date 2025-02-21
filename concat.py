import numpy as np
from time import perf_counter_ns

# Define two Python lists 
py_list1 = list(range(10000000)) 
py_list2 = list(range(10000000, 20000000))  

# Define two Numpy arrays 
np_array1 = np.arange(10000000) 
np_array2 = np.arange(10000000, 20000000)  

# Adding Python lists 
t1_start = perf_counter_ns()
result_list = [a + b for a, b in zip(py_list1, py_list2)] 
t1_stop = perf_counter_ns()

print((t1_stop-t1_start) / 1000000000, 's')

# Adding Numpy arrays 
t2_start = perf_counter_ns()
result_array = np_array1 + np_array2 
t2_stop = perf_counter_ns()

print((t2_stop-t2_start) / 1000000000, 's')
