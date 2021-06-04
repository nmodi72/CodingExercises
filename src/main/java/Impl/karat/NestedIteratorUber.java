package main.java.Impl.karat;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// A NestedInteger itself can be an integer or an list contains NestIntegers, e.g.
// NestedInteger: 1
// NestedInteger: [1, 2]
// NestedInteger: [1, [7, 8]]
public class NestedIteratorUber<T> {
//
//    T curr;
//
//    // Constructor initializes an empty NestedInteger.
//    public NestedIteratorUber(){
//        this.curr =
//    }
//    // Constructor initializes a single integer.
//    public NestedIteratorUber(int value) {
//        this.curr = (Integer) value;
//    }
//    // @return true if this NestedInteger holds a single integer, rather than a nested list.
//    public boolean isInteger() {
//        return (this.curr != null && this.curr instanceof Integer);
//    }
//
//    // @return the single integer that this NestedInteger holds, if it holds a single integer
//    // Return null if this NestedInteger holds a nested list
//    public <T> T getInteger() {
//        if(this.curr == null || !(this.curr instanceof Integer)) return null;
//        return this.curr;
//    }
//
//    // Set this NestedInteger to hold a single integer.
//    public void setInteger(int value) throws Exception {
//        if(this.curr == null || !(this.curr instanceof Integer)) throw new RuntimeException("Not setting value on a Integer type!");
//        this.curr = (Integer) value;
//    }
//
//    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//    public void add(NestedIteratorUber ni) throws Exception {
//        if(this.curr == null) throw new RuntimeException("Not setting value on a colletion type!");
//        List<NestedIteratorUber> list = (List) this.curr;
//        list.add((NestedIteratorUber) ni);
//        this.curr = list;
//    }
//    // @return the nested list that this NestedInteger holds, if it holds a nested list
//    // Return null if this NestedInteger holds a single integer
//    public List<NestedIteratorUber> getList() {
//        if(this.curr == null || !(this.curr instanceof List)) return null;
//        return (List) this.curr;
//    }
//
//    // [1, [2, 3]] -> [1, 2, 3]
//    public <T> List<T> flatten() {
//        List<T> result = new ArrayList<T>();
//        traverse(this, result);
//        return result;
//    }
//
//    private <T> void traverse(NestedIteratorUber node, List<T> result){
//        if(node == null) return;
//        if(node.isInteger()) result.add(node.getInteger());
//        for(NestedIteratorUber item : node.getList()){
//            traverse(item);
//        }
//    }
//}
//
//// [1, [2, 3]]
//// Main class should be named 'Solution'
//class Solution {
//    public static void main(String[] args) {
//        try {
//            NestedIteratorUber root = new NestedIteratorUber();
//            NestedIteratorUber n1 = new NestedIteratorUber(1);
//            root.add(n1);
//
//            NestedIteratorUber l1 = new NestedIteratorUber();
//            NestedIteratorUber l12 = new NestedIteratorUber(2);
//            NestedIteratorUber l13 = new NestedIteratorUber(3);
//
//            l1.add(l12);
//            l1.add(l13);
//            root.add(l1);
//
//            for(Integer i : root.flatten()){
//                System.out.println(i);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error occured");
//        }
//        System.out.println("Hello, World");
//    }
}
