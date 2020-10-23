/*
    Given an array of numbers, the task is to print those numbers in ascending order separated by commas which have 1, 2 and 3 in their digits.
    If no number containing digits 1, 2, and 3 present then print -1.
*/

//Time:- O(nlog(n))

import java.util.*;
class java1 {

    public static boolean isUseful(int num) {
        boolean flag1 = false; 
        boolean flag2 = false; 
        boolean flag3 = false; 

        while(num != 0 && (flag1 && flag2 && flag3) == false) {
            int r = num % 10;
            num /= 10;

            if(r == 1) {
                flag1 = true;
            }
            else if(r == 2) {
                flag2 = true;
            }
            else if(r == 3) {
                flag3 = true;
            }
        }

        return (flag1 && flag2 && flag3);
    } 

    public static ArrayList<Integer> solve(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: numbers) {
            if(isUseful(num) == true) {
                list.add(num);
            }
        }

        Collections.sort(list);

        return list;
    }


    public static void main(String[] args) {
        // int[] numbers = {123, 1232, 456, 234, 32145};
        // int[] numbers = {9821, 627183, 12, 1234};
        int[] numbers = {12, 232, 456, 234};

        ArrayList<Integer> list = solve(numbers);
        if(list.size() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(list);
        }
    }
}