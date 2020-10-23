import java.util.*;
class Main1 {

    public static String largestPalindromic(String str, int k) {
        HashSet<Integer> hs = new HashSet<>();               //to keep track of what elements i have changed.
        char[] arr  = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {                             //to make it palindromic
            if(arr[left] - arr[right] > 0) {
                arr[right] = arr[left];
                
                hs.add(right);
                k--;
            }
            else if(arr[left] - arr[right] < 0) {
                arr[left] = arr[right];

                hs.add(left);
                k--;
            }

            left++;
            right--;
        }


        if(k > 0) {                               //to make it largest in palidromes (if k is available)
            left = 0;
            right = arr.length - 1;

            while(left < right ) {
                if(arr[left] != '9' && k >= 2) {
                    arr[left] = arr[right] = '9';

                    if(hs.contains(left) || hs.contains(right)) {
                        k -= 1;
                    }
                    else {
                        k -= 2;
                    }
                }

                left++;
                right--;
            }

            if(left == right && k > 0) {
                arr[left] = '9';
            }
        }
        else if(k < 0) {
            return "Not possible";
        }

        StringBuilder res = new StringBuilder();
        for(char ch: arr) {
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "12345";
        int k = 1;

        String resStr = largestPalindromic(str, k);
        System.out.println(resStr);
    }
}