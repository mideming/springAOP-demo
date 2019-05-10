package com.example.demo.sort;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-23 16:15
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,10};
        binarySerach(array, 9);
    }
    static int binarySerach(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
