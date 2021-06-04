package main.java.Impl.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomHashMap <K, V> {

    private class Pair <I, J> {

        private I key;
        private J value;

        Pair(I key, J value){
            this.key = key;
            this.value = value;
        }

        I getKey() {
            return this.key;
        }

        J getValue() {
            return this.value;
        }
    }

    private List<Pair> bucket;

    CustomHashMap(){
        bucket = new ArrayList<>();
    }

    private void setBucket(K key, V value){
        bucket.add(new Pair(key, value));
    }

    Pair getBucketByKey(String key){
        for(Pair p : bucket) {
            if(key.equals(p.getKey())) return p;
        }
        return null;
    }


    public static void main(String[] args) {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.setBucket("Paras", "1234");
        map.setBucket("DK", "2564862");
        map.setBucket("Modi", "38719");
        map.setBucket("Chitti", "jdhuosfgs");

        System.out.println(map.getBucketByKey("DK").getValue());
        System.out.println(map.getBucketByKey("Modi").getValue());
        System.out.println(map.getBucketByKey("Chitti").getValue());
        System.out.println(map.getBucketByKey("Paras").getValue());
    }

}

