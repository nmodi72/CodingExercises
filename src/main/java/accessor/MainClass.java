package main.java.accessor;

import main.java.Impl.CS_Dojo.FindAllSubsetOfSet;
import main.java.Impl.CS_Dojo.MaximumSumSubArray_KadenAlgo;
import main.java.Impl.TusharRoy.MedianOfTwoSortedArrayOfDifferentLength;
import main.java.Impl.concept.Tree.LevelBasedSumBFS;
import main.java.Impl.concept.Tree.PreInPostOrderTraversal;
import main.java.Impl.concept.Graph.BreadthFirstSearch;
import main.java.Impl.concept.Graph.DepthFirstSearch;
import main.java.model.GraphNode;
import main.java.model.TreeNode;

/**
 * This is the main class to initiate the method execution of other classes.
 */
public class MainClass {

    public static void main(String args[]) throws Exception {

//        DictionaryWithTrie dictionaryWithTrie = new DictionaryWithTrie();
//        String[] keys = {"the", "a", "there", "thereare", "answer", "any",
//                "by", "bye", "their"};
//        List<String> wordList = Arrays.asList(keys);
//        wordList.forEach(word -> {
//            dictionaryWithTrie.insert(word);
//        });
//
//        System.out.println("Is \"there\" in dictionary? " + dictionaryWithTrie.search("there"));
//        System.out.println("Is \"by\" in dictionary? " + dictionaryWithTrie.search("by"));
//        System.out.println("Is \"the\" in dictionary? " + dictionaryWithTrie.search("the"));
//        System.out.println("Is \"they\" in dictionary? " + dictionaryWithTrie.search("they"));
//        System.out.println("Is \"are\" in dictionary? " + dictionaryWithTrie.search("are"));

        PreInPostOrderTraversal preInPostOrderTraversal = new PreInPostOrderTraversal();
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

//        System.out.print("Pre-Order Traversal with Recursion: ");
//        preInPostOrderTraversal.preOrderWithRecursion(treeNode);
//        System.out.println("");
//
//        System.out.print("Pre-Order Traversal without Recursion: ");
//        preInPostOrderTraversal.preOrderWithoutRecursion(treeNode);
//        System.out.println("");
//
//        System.out.print("Pre-Order Traversal with Morris Traversal: ");
//        preInPostOrderTraversal.preOrderWithMorrisTraversal(treeNode);
//        System.out.println("");
//
//        System.out.print("In-Order Traversal with Recursion: ");
//        preInPostOrderTraversal.inOrderPrint(treeNode);
//        System.out.println("");
//
//        System.out.print("In-Order Traversal without Recursion: ");
//        preInPostOrderTraversal.inOrderWithoutRecursion(treeNode);
//        System.out.println("");
//
//        System.out.print("In-Order Traversal with Morris Traversal: ");
//        preInPostOrderTraversal.inOrderWithMorrisTraversal(treeNode);
//        System.out.println("");
//
//        System.out.print("Post-Order Traversal with Recursion: ");
//        preInPostOrderTraversal.postOrderPrint(treeNode);
//        System.out.println("");
//
//        System.out.print("Post-Order Traversal without Recursion: ");
//        preInPostOrderTraversal.postOrderWithoutRecursion(treeNode);
//        System.out.println("");
//
//        System.out.print("Post-Order Traversal with Morris Traversal: ");
//        preInPostOrderTraversal.postOrderWithMorrisTraversal(treeNode);
//        System.out.println("");

//        LRUCache lruCache = new LRUCache(5);
//        lruCache.set(1, 11);
//        lruCache.set(2, 22);
//        lruCache.set(3, 33);
//        System.out.println("Get Key: 1 :" + lruCache.get(1));
//        lruCache.set(4, 44);
//        lruCache.set(5, 55);
//        lruCache.set(6, 66);
//        lruCache.set(4, 77);
//        System.out.println("Get Key:");
//        System.out.println("Get Key: 1 :" + lruCache.get(1));
//        System.out.println("Get Key: 2 :" + lruCache.get(2));
//        System.out.println("Get Key: 3 :" + lruCache.get(3));
//        System.out.println("Get Key: 4 :" + lruCache.get(4));
//        System.out.println("Get Key: 5 :" + lruCache.get(5));
//        System.out.println("Get Key: 6 :" + lruCache.get(6));


        GraphNode graphNode = new GraphNode(8);

        graphNode.addEdge(0, 1);
        graphNode.addEdge(0, 2);
        graphNode.addEdge(0, 3);
        graphNode.addEdge(1, 4);
        graphNode.addEdge(2, 5);
        graphNode.addEdge(3, 6);
        graphNode.addEdge(4, 7);
//
//        System.out.println("Following is Breadth First Traversal "+
//                "(starting from vertex 2)");
//        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
//        breadthFirstSearch.breadthFirstSearchPrintNodes(graphNode, 0);
//        System.out.println("");
//        System.out.println("Following is Depth First Traversal "+
//                "(starting from vertex 2)");
//        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
//        depthFirstSearch.printDepthFirstSearchTraversal(graphNode, 0);
//
//
//        TreeNode anotherTreeNode = new TreeNode(5);
//        anotherTreeNode.left = new TreeNode(4);
//        anotherTreeNode.left.left = new TreeNode(3);
//        anotherTreeNode.left.left.left = new TreeNode(1);
//        anotherTreeNode.right = new TreeNode(9);
//        anotherTreeNode.right.left = new TreeNode(6);
//
//        System.out.println("Level Order Print: ");
//        new LevelBasedSumBFS().printEachNodes(anotherTreeNode);
//        System.out.println("");

        int[] input1 = {1, 3, 8, 9, 15};
        int[] input2 = {7, 11, 18, 19, 21, 25};
        MedianOfTwoSortedArrayOfDifferentLength medianOfTwoSortedArrayOfDifferentLength = new MedianOfTwoSortedArrayOfDifferentLength();
        System.out.println("Median is:" + medianOfTwoSortedArrayOfDifferentLength.findMedianOfTwoSortedArrays(input1, input2));

        Integer[] input3 = {1, 2, 3};
        FindAllSubsetOfSet findAllSubsetOfSet = new FindAllSubsetOfSet();
        System.out.println("Find Subset are:");
        findAllSubsetOfSet.findAllSubset(input3);

        int[] input4 = {-2, 3, 2, -1};
        MaximumSumSubArray_KadenAlgo maximumSumSubArray_kadenAlgo = new MaximumSumSubArray_KadenAlgo();
        System.out.println("Max value is:" + maximumSumSubArray_kadenAlgo.findMaximumSum(input4));
}
}
