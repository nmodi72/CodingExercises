package main.java.Impl.karat;

import java.util.HashMap;
import java.util.Map;

public class FindMidSubject {
    /*

    Sample input 1: (arbitrarily ordered) prereqs_courses1 = [
    ["Foundations of Computer Science", "Operating Systems"],
    ["Data Structures","Algorithms"],
    ["Computer Networks", "Computer Architecture"],
    ["Algorithms","Foundations of Computer Science"],
    ["Computer Architecture","Data Structures"],
    ["Software Design", "Computer Networks"] ]

    In this case, the order of the courses in the program is:
    Software Design
    Computer Networks
    Computer Architecture
    Data Structures
    Algorithms
    Foundations of Computer Science
    Operating Systems

    Sample output 1: "Data Structures"

    Sample input 2: prereqs_courses2 = [
    ["Data Structures", "Algorithms"],
    ["Algorithms", "Foundations of Computer Science"],
    ["Foundations of Computer Science", "Logic"] ]
     */
    private String findMidCourse(String[][] preReq){
        Map<String, Node> map = new HashMap<String, Node>();
        Node head = null;
        for(String[] req: preReq){
            String pre = req[0]; //
            Node pNode = map.getOrDefault(pre, new Node(pre));
            pNode.next = map.getOrDefault(req[1], new Node(req[1]));
            pNode.next.prev = pNode;

            if(head == null){
                head = pNode;
            }
            map.put(pre, pNode);
            map.put(req[1], pNode.next);
        }
        int size = map.size();
        while(head. prev != null){
            head = head.prev;
        }

        int k = 1;
        while(k< (size+1)/2){
            head = head.next;
            k++;
        }

        return head.data;

    }

    class Node {
        String data;
        Node prev;
        Node next;

        Node(String dt) {
            this.data = dt;
            prev = null;
            next = null;
        }
    }

    public static void main(String[] args) {

        FindMidSubject f = new FindMidSubject();
        String[][] prereqsCourses1 = {
                { "Foundations of Computer Science", "Operating Systems" },
                { "Data Structures", "Algorithms" },
                { "Computer Networks", "Computer Architecture" },
                { "Algorithms", "Foundations of Computer Science" },
                { "Computer Architecture", "Data Structures" },
                { "Software Design", "Computer Networks" } };

        String[][] prereqsCourses2 = {
                { "Data Structures", "Algorithms" },
                { "Algorithms", "Foundations of Computer Science" },
                { "Foundations of Computer Science", "Logic" }
        };

        String[][] prereqsCourses3 = { { "Data Structures", "Algorithms" } };

        System.out.println(f.findMidCourse(prereqsCourses2));

    }
}
