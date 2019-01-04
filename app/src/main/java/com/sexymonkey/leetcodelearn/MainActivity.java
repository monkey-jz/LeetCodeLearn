package com.sexymonkey.leetcodelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        sellectionSort(arr);
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
}
