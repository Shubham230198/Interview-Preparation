/**
    Given two strings str1 and str2, find if str1 is a subsequence of str2. 
    Expected time complexity is linear.
 */


class main3 {

    public static boolean isSubseq(String str1, String str2) {
        if(str1.length() > str2.length()) {
            return false;
        }

        int i = 0;        //for str1
        int j = 0;        //for str2

        while(j < str2.length() && i < str1.length()) {
            if(str2.charAt(j) == str1.charAt(i)) {
                i++;
            }
            j++;
        }

        if(i == str1.length()) {
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        // String str1 = "AXY";
        // String str2 = "ADXCPY";

        // String str1 = "AXY";
        // String str2 = "YADXCP";

        String str1 = "gksrek";
        String str2 = "geeksforgeeks";

        boolean flag = isSubseq(str1, str2);
        System.out.println(flag);
    }
}   
    