import java.util.*;
class Main5 {

    public static void printDistinct(String str) {
        HashSet<Character> hs = new HashSet<>();

        for(char ch: str.toCharArray()) {
            if(ch == ' ') {                //to not consider the space character.
                continue;
            }

            if(hs.contains(ch) == false) {
                System.out.print(ch);
                hs.add(ch);
            }
        }

    }


    public static void main(String[] args) {           //Time: O(n)      //Space: O(1) {as total numbers of characters are 256}
        String str = "Hello Geeks";

        printDistinct(str);
    }    
}
