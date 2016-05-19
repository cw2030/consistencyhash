package com.jdd.datacenter.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        List<String> nodes = new ArrayList<>();
        for(int i=0; i<10; i++){
        	nodes.add("machine_" + i);
        }
        
        // default hash
        ConsistentHash<String> hash = new ConsistentHash<>(5, nodes);
        // 
        String hashStr = (String)hash.get("machine_10");
        System.out.println(" belong to " + hashStr);
        System.out.println(" hash circle : " + hash.getNodeHashDesc());
        
        // assign hash 
        ConsistentHash<String> hash1 = new ConsistentHash<>(HashAlgorithm.JS_HASH,5, nodes);
        // 
        String hashStr1 = (String)hash1.get("machine_50");
        System.out.println(" belong to node " + hashStr1);
        System.out.println(" current hash circle describe : " + hash1.getNodeHashDesc());
    }
}
