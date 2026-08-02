
import lists.MyArrayList;
import lists.MyLinkedList;
import trees.Tree;
import trees.TreeNode;

import java.beans.PropertyEditorManager;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.Insert(10);
        tree.Insert(20);
        tree.Insert(5);
        tree.Insert(30);
        tree.Insert(15);

        tree.InorderTraversal();
        System.out.println();
        tree.PostOrderTraversal();

        System.out.println();

//        TreeNode res = tree.isNodePresent(15);
//        if(res != null){
//            System.out.println(res.getVal());
//        }

        tree.delTreeNode(12);
    }

    public static void helper(Integer counter){
//        MyLinkedList<Integer> mylist = new MyLinkedList<>();
//        Random rand = new Random();
//        Integer count = 1;
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i< 100000; i++){
//            mylist.AddtoFront(rand.nextInt() % 100);
//        }
//
//        while(mylist.getSize() != 0){
//            for(int i = 0; i< 200; i++){
//                mylist.removeAtPost(rand.nextInt() % 100);
//            }
//            map.put(count, mylist.getSize());
//            count++;
//        }
//        drawGraph(count);
    }

    public static void drawGraph(Integer count){
        for(int i= 0 ; i < count/10 ; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}