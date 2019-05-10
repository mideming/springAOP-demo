package com.example.demo.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-23 15:23
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int [] x = {6,2,4,1,5,0};
        System.out.println("开始之前" + Arrays.toString(x));
        bubble_sort(x);
        System.out.println("开始之后" + Arrays.toString(x));
    }
    public static void bubble_sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length-1; i++) {// 外层循环控制排序趟数
            for (int j = 0; j < unsorted.length-1-i; j++) {// 内层循环控制每一趟排序多少次
                if (unsorted[j] > unsorted[j+1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp;
                }
            }
            System.out.println("--->" + Arrays.toString(unsorted));
            boolean a = true;
            for (int x = 0; x < unsorted.length-1; x++) {
                if(unsorted[x+1] < unsorted[x]) {
                    a = false;
                }
            }
            if(a) {
                return;
            }
        }
    }
}
