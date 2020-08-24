package com.sexymonkey.leetcodelearn;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bubbleSort(View view) {
        int [] arr = {2,8,6,3,1,5};
        int[] array = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;

                    flag = false;
                }
            }

            if(flag){
                break;
            }
        }

        for (int i : array) {
            Log.d(TAG, "bubbleSort: "+ i + ",");
        }

    }


    public void sellectionSort(View view) {
        int [] arr = {2,8,6,3,1,5};
        int[] array = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < array.length  - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]){
                   int temp = array[j];
                   array[j] = array[i];
                   array[i] = temp;
                }
            }
        }
        for (int i : array) {
            Log.d(TAG, "bubbleSort: "+ i + ",");
        }

    }

    public void reverseListNode(View view){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = node1;
        while (node != null){
            Log.d(TAG,node.value+",");
            node = node.next;
        }
        Log.d(TAG,"\n");

        Node reverseListNode = reverseListNode(node1);
        printListNode(reverseListNode);

    }

    public Node reverseListNode(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node pre = null;
        Node post = null;

        while (head != null){
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }

    public void printListNode(Node head){

        Node current = head;
        while (current != null){
            Log.d(TAG,current.value +",");
            current = current.next;
        }
        Log.d(TAG, "\n");
    }

    public void twoSum(View view) {

        int target = 9;

        int [] array = { 1 , 2 ,6 ,9 ,10 ,7 ,3,-1};

        HashMap<Integer, Integer> tempHashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            int temp = target - array[i];

            if(tempHashMap.containsKey(temp)){
                Log.d(TAG,"索引值分别为 ： " + tempHashMap.get(temp) + ", " + i);
            }else {
                tempHashMap.put(array[i],i);
            }
        }

    }

    public void twoNumAdd(View view) {

        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;


        Node l1 = new Node(5);
        Node l2 = new Node(6);
        Node l3 = new Node(4);
        l1.next = l2;
        l2.next = l3;

        int carrired = 0;

        Node newNode = new Node(-1);

        while (n1 != null || l1 != null){

            newNode.next = new Node(n1.value + l1.value + carrired) ;

            if(newNode.next.value / 10 != 0){
                carrired = newNode.next.value / 10;
                newNode.next = new Node(newNode.next.value % 10);
            }

            n1 = n1.next;
            l1 = l1.next;

            newNode = newNode.next;

            Log.d(TAG,"value = " + newNode.value);
        }

        while (newNode.next != null){
            Log.d(TAG,"value = " + newNode.value);
            newNode = newNode.next;
        }

    }

    public void lengthOfLongestSubstring(View view) {

        String s = "afgfgfgbhgfhcdkjfkdadlkjfkbfkldnfcytyserspaxnzvbb";
        char[] chars = s.toCharArray();
        int len = s.length();

        int start = 0;

        int end = 0;

        int maxMapSize = 0;

        Map<Character,Integer> map = new HashMap<>();

        while (end < len){
            //从0开始遍历字符数组,如果map里没有这个字符就存入对应索引的值为key和索引value
            if(!map.containsKey(chars[end])){
                map.put(chars[end],end);
                //算出map中元素最多时的元素个数即为结果
                maxMapSize = Math.max(maxMapSize,map.size());
                end ++;
            }else{
                //删除map中从0到这个重复字符的所有字符
                while (map.get(chars[end]) != null && start <= map.get(chars[end])){
                    map.remove(chars[start]);
                    start++;
                }
                //重新加入重复的字符
                map.put(chars[end],end);
                end ++;
            }

            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
                    Log.d(TAG,"key = " + characterIntegerEntry.getKey() +
                            ", index = " + characterIntegerEntry.getValue());
            }
            Log.d(TAG,"==========================================" );
        }

        Log.d(TAG,"max = " + maxMapSize);

    }
}
