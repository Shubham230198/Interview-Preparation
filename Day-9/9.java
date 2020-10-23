class Main9 {

/****************************************Mehtod - 1************************************************* */

    public static String firstPalindromic1(String str) {
        int[] freqArr = new int[26];
        StringBuilder resStr = new StringBuilder();   //empty string of size str.length()

        for(int i = 0; i < str.length(); i++) {     //Building freq array and empty string.
            int cIdx = str.charAt(i) - 'a';
            freqArr[cIdx]++;

            resStr.append("\0");
        }

        boolean firstOddDone = false;
        char oddChar = '-';

        int left = 0;
        int right = resStr.length() - 1;
        for(int i = 0; i < freqArr.length; i++) {
            char ch = (char)(i + 'a');
            
            if(freqArr[i] % 2 == 0) {
                while(freqArr[i] != 0) {
                    resStr.setCharAt(left, ch);
                    resStr.setCharAt(right, ch);

                    freqArr[i] -= 2;
                    left++;
                    right--;
                }
            }
            else {

                if(firstOddDone == true) {
                    return "No Pallindrome Possible.";
                }
                firstOddDone = true;
                oddChar = ch;

                while(freqArr[i] != 1) {
                    resStr.setCharAt(left, ch);
                    resStr.setCharAt(right, ch);

                    freqArr[i] -= 2;
                    left++;
                    right--;
                }
            }
        }
         
        if(oddChar != '-') {
            resStr.setCharAt(left, oddChar);
        }

        return resStr.toString();
    }

/************************************************************************************ */




/********************************************Mehtod-2********************************* */
  
    public static String firstPalindromic2(String str) {
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int cIdx = str.charAt(i) - 'a';
            freq[cIdx]++;
        }

        StringBuilder firstHalf = new StringBuilder();
        StringBuilder lastHalf = new StringBuilder();
        char oddChar = '-';

        for(int i = 0; i < freq.length; i++) {
            char ch = (char)(i + 'a');
            
            if(freq[i] % 2 == 0) {
                while(freq[i] != 0) {
                    firstHalf.append(ch);
                    lastHalf.append(ch);

                    freq[i] -= 2;
                }
            }
            else {
                if(oddChar != '-') {
                    return "No palindrome possible";
                }
                oddChar = ch;
                System.out.println(ch);

                while(freq[i] != 1) {
                    firstHalf.append(ch);
                    lastHalf.append(ch);

                    freq[i] -= 2;
                }
            }
        }

        lastHalf = lastHalf.reverse();

        StringBuilder finalString = new StringBuilder();
        finalString.append(firstHalf);
        finalString.append(oddChar);
        finalString.append(lastHalf);

        return finalString.toString();
    }


    public static void main(String[] args) {
        String str = "malayalam";
        // String str = "apple";

        // String resStr = firstPalindromic1(str);

        String resStr = firstPalindromic2(str);
        System.out.println(resStr);
    }    
}
