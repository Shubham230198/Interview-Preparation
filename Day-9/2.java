class Main2 {

    public static boolean checkPalindrome(String str) {
        int left = 0; 
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    public static int LongestLength_NonPalindrome(String str) {

        boolean allAreSame = true;                      //check if all characters are same in the string
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) != str.charAt(i + 1)) {
                allAreSame = false;
                break;
            }
        }        
        
        if(allAreSame == true) {
            return 0;
        }
        

        boolean isPalindrome = checkPalindrome(str);        //check if str is palindromic in nature.
        if(isPalindrome == true) {
            return str.length() - 1;
        }
        else {
            return str.length();
        }
    }


    public static void main(String[] args) { 
        String str = "abba";
        System.out.println(LongestLength_NonPalindrome(str));
    }    
}
