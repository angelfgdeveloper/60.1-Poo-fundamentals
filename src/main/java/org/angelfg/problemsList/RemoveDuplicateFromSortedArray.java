package org.angelfg.problemsList;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

    public static final int[] NUMBERS = new int[]{1,2,2};

    // 1,1,2
    // ^
    //   ^

    // 0,0,1,1,1,2,2,3,3,4
    // ^
    //  ^

    // 0, 1, 2,3

    public static void main(String[] args) {
        int index2 = numbersUniques2(NUMBERS);
        System.out.println("Index2: " + index2);
    }

    private static int numbersUniques2(int[] nums) {

        int puntero1 = 0;
        int puntero2 = 1;
        int puntero3 = 0;
        int size = nums.length - 1;

        if (nums.length == 1) return 1;

        while (size >= puntero1) {

            if (puntero1 == size && puntero2 == size) {
                nums[puntero3] = nums[puntero2];
                puntero3++;
                break;
            }

            if (nums[puntero2] == nums[puntero1] && puntero1 > puntero2 && puntero1 == size) {
                nums[puntero3] = nums[puntero2];
                puntero3++;
                break;
            } else if (nums[puntero2] == nums[puntero1]) {
                puntero1++;
            } else if (nums[puntero2] < nums[puntero1]) {
                nums[puntero3] = nums[puntero2];
                puntero3++;
                puntero2 = puntero1;
            } else if (nums[puntero2] > nums[puntero1]) {
                nums[puntero3] = nums[puntero1];
                puntero3++;
                puntero1++;
            } else if (nums[puntero1] == size) {
                nums[puntero3] = nums[puntero1];
                puntero1++;
                puntero3++;
            }

        }

        Arrays.stream(nums).forEach(System.out::println);

        return puntero3;
    }

}
