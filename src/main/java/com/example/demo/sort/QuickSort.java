package com.example.demo.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-23 16:01
 **/
public class QuickSort {
    public static void main(String[] args)
    {
        int[] x =
                { 6, 2, 4, 1, 5, 9 };
        System.out.println(Arrays.toString(x));
        quick_sort(x, 0, x.length - 1);
        System.out.println(Arrays.toString(x));

    }

    private static void quick_sort(int[] unsorted, int low, int high)
    {
        int loc = 0;
        if (low < high)
        {
            loc = partition(unsorted, low, high);
            quick_sort(unsorted, low, loc - 1);
            quick_sort(unsorted, loc + 1, high);
        }

    }

    private static int partition(int[] unsorted, int low, int high)
    {
        int privot = unsorted[low];
        while (low < high)
        {
            while(low <high &&unsorted[high] >privot)
            {
                high -- ;
            }
            unsorted[low]  = unsorted[high];
            while(low<high && unsorted[low]<= privot)
            {
                low++;
            }
            unsorted[high]  = unsorted[low];

        }
        unsorted[low] = privot;
        return low;
    }
}
