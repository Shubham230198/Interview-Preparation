class Main3 {

    static char decryptedCharacter(String str, int k, int idx) {
        if(idx >= str.length()) {
            return ' ';
        }

        int i = idx;

        String substr = "";           //building current level substring.
        while(str.charAt(i) > '9') {
            substr += str.charAt(i);
            i++;
        }

        int num = 0;                     //building level number.
        while(i < str.length() && str.charAt(i) < 'a') {
            num = num * 10 + (str.charAt(i) - '0');
            i++;
        }

        // System.out.println(substr + " -> " + num);

        int length = num * substr.length();              //length of current substring decoding.
        
        if(k < length) {               //if K-th character is present in the present level sub-string
            k %= substr.length();
            return substr.charAt(k);
        }
        else {
            return decryptedCharacter(str, k - length, i);
        }
    }


    public static void main(String[] args) {
        String str = "aa2b12c3";
        int k = 14;

        char ch = decryptedCharacter(str, k - 1, 0);        //here k - 1 is passed, to make k start with 0 (same as index)
        if(ch == ' ') {
            System.out.println("value of k is out of bound");
        }
        else {
            System.out.println(ch);
        }
    }
}
