package org.example;

    public class Reverse {
        public int [] reverseArray(int[] array) {
            int left = 0, right = array.length - 1;
            while (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
            return array;
        }
    }
