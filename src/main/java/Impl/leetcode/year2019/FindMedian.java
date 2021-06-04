package main.java.Impl.leetcode.year2019;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
/*
295 Find a median from data steam
 */
public class FindMedian {

        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;
        double median;

        /** initialize your data structure here. */
        public FindMedian() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            median = Double.valueOf(0);
        }

        public void addNum(int num) {
            if(minHeap.size() == 0 && maxHeap.size() == 0) {
                minHeap.add(num);
                this.median = Double.valueOf(num);
                return;
            }
            if(num < this.median) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            reshuffleQueue(minHeap, maxHeap);
            calculateMedian(minHeap, maxHeap);
        }

        public double findMedian() {
            return this.median;
        }

        private void calculateMedian(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
            if (minHeap.size() + maxHeap.size() == 0) this.median = Double.valueOf(0);
            if (minHeap.size() > maxHeap.size()) {
                this.median = Double.valueOf(minHeap.peek());
            } else if (maxHeap.size() > minHeap.size()) {
                this.median = Double.valueOf(maxHeap.peek());
            } else {
                double med = Double.valueOf(maxHeap.peek() + minHeap.peek());
                this.median = med/2;
            }
        }

        private void reshuffleQueue(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if(minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }
        }
    /*
    ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
     */
    public static void main(String[] args) {
        FindMedian fm = new FindMedian();
        fm.addNum(-1);
        System.out.println(fm.findMedian());
        fm.addNum(-2);
        System.out.println(fm.findMedian());
        fm.addNum(-3);
        System.out.println(fm.findMedian());
        fm.addNum(-4);
        System.out.println(fm.findMedian());
        fm.addNum(-5);
        System.out.println(fm.findMedian());
    }

}
