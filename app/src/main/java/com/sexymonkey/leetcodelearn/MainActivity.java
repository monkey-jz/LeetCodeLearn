package com.sexymonkey.leetcodelearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
        int [] arr = {2,8,6,3,1,5};
//        bubbleSort(arr);
//        sellectionSort(arr);
        reverseListNode();
    }

    private void bubbleSort(int[] arr) {
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


    private void sellectionSort(int[] arr) {
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

    public void reverseListNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = node1;
        while (node != null){
            Log.d(TAG,node.value+",");
            node = node.next;
        }
        Log.d(TAG,"\n");

        ListNode reverseListNode = reverseListNode(node1);
        printListNode(reverseListNode);

    }

    public ListNode reverseListNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode post = null;

        while (head != null){
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }

    public void printListNode(ListNode head){

        ListNode current = head;
        while (current != null){
            Log.d(TAG,current.value +",");
            current = current.next;
        }
        Log.d(TAG, "\n");
    }

    public class ListNode{
        public ListNode next;
        public ListNode pre;
        public int value;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
