class main2 {

    public static boolean wildcardMatching(String text, String patrn, int tPtr, int pPtr) {
        if(tPtr == text.length() && pPtr == patrn.length()) {  //if both ends
            return true;
        }
        else if(pPtr == patrn.length()) {    //if pattern ends first,
            return false;
        }
        else if(tPtr == text.length()) {     //if text ends.
            
            while(pPtr != patrn.length()) {
                if(patrn.charAt(pPtr) != '*')
                    return false;
                
                pPtr++;
            }
            return true;
        }


        boolean flag = false;
        if((patrn.charAt(pPtr)) == '?' || (patrn.charAt(pPtr) == text.charAt(tPtr))) {
            flag = wildcardMatching(text, patrn, tPtr + 1, pPtr + 1);
            
            if(flag) {
                return flag;
            }
        }
        else if(patrn.charAt(pPtr) == '*'){          //in case of star

            flag = wildcardMatching(text, patrn, tPtr, pPtr + 1);
            if(flag) {
                return flag;
            }

            flag = wildcardMatching(text, patrn, tPtr + 1, pPtr);
        }

        return flag;
    } 



    public static void main(String[] args) {
        String text = "ababab";
        String patrn = "aba*";

        // String text = "baaabab";
        // String patrn = "a*ab";

        boolean isMatch = wildcardMatching(text, patrn, 0, 0);
        System.out.println(isMatch);
    }
}
