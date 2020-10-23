/*
    Giving a dictionary and a string ‘str’, find the longest string in dictionary which 
    can be formed by deleting some characters of the given ‘str’.
*/

class main4 {

    /****************************************************Method - 1 ***********************************************/
    //Time- O(N*K*n) Here N is the length of dictionary and n is the length of given string ‘str’ 
    //      and K – maximum length of words in the dictionary.

    //space- O(1)
    
    public static boolean isSubseq(String patrn, String str) {
        if(patrn.length() > str.length()) {
            return false;
        }

        int i = 0;   //for patrn
        int j = 0;   //for str

        while(j < str.length() && i < patrn.length()) {
            if(patrn.charAt(i) == str.charAt(j)) {
                i++;
            }
            j++;
        }

        if(i == patrn.length()) {
            return true;
        }
        else {
            return false;
        }
    }


    public static String solve(String str, String[] dict) {
        String res = "";

        for(String s: dict) {
            if(s.length() <= res.length()) {
                continue;
            }

            if(isSubseq(s, str) == true) {
                res = s;
            }
        }

        return res;
    }

    /************************************************************************************************************ */



    /****************************************************Method - 2 **********************************************/


    /************************************************************************************************************ */


    public static void main(String[] args) {
        // String[] dict = {"ale", "apple", "monkey", "plea"};   
        // String str = "abpcplea";

        String[] dict = {"pintu", "geeksfor", "geeksgeeks", "forgeek"};
        String str = "geeksforgeeks";
        
        String res = solve(str, dict);
        System.out.println(res);
    }    
}
