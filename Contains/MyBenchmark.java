/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.avenuecode.snippet;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

import java.io.*;

import java.util.*;

@State(Scope.Thread)
public class MyBenchmark {

    int x = 10000000;
    HashSet<String> counts = new HashSet<String>();
    TreeSet<String> counts2 = new TreeSet<String>();
    HashMap<String, String> map = new HashMap<>();
    TreeMap<String, String> map2 = new TreeMap<>();
    ArrayList<String> mylist = new ArrayList<String>();
    String[] s = new String[x];
    String[] s2 = new String[x];
    
    /**
     * Setup method to initialize data for the benchmark.
     */
    @Setup(Level.Trial)
    public void setup() {
        for (int i=0; i < x; i++)
            mylist.add(String.valueOf(i*2));
    	    
    	Collections.shuffle(mylist); 
        
	for (int i=0; i < x; i++)
	    s[i] = mylist.get(i);
	    
	Collections.shuffle(mylist); 
        
	for (int i=0; i < x; i++)
	    s2[i] = mylist.get(i);
	    
	for (int i=0; i < x; i++)		
	    counts.add(s[i]);
	for (int i=0; i < x; i++)		
	    counts2.add(s[i]);
	for (int i=0; i < x; i++)		
	    map.put(s[i], s[i]);
	for (int i=0; i < x; i++)		
	    map2.put(s[i], s[i]);
    }
            
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public long _0_HashSetContains() {
        for (int i=0; i < x; i++)		
	    counts.contains(s2[i]);
        return 0;
    }

    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public long _1_TreeSetContains() {
        for (int i=0; i < x; i++)		
	    counts2.contains(s2[i]);
        return 0;
    }        
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public long _2_HashMapContainsKey() {
	for (int i=0; i < x; i++)		
	    map.containsKey(s2[i]);
        return 0;
    }
    
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public long _3_TreeMapContainsKey() {
	for (int i=0; i < x; i++)		
	    map2.containsKey(s2[i]);   
        return 0;
    }
                
    /**
     * Main method to run the benchmark.
     *
     * @param args Command line arguments
     * @throws Exception If an error occurs during benchmark execution
     */
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

}
