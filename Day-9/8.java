import java.util.*;
class Main8 {
    static class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        Pair(char c, int f) {
           this.ch = c;
           this.freq = f; 
        }

        public int compareTo(Pair other) {
            return other.freq - this.freq;
        }
    }


    public static String rearrange(String str, int d) {
        int[] freqArr = new int[256];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            freqArr[(int)ch]++; 
        }

        ArrayList<Pair> arrList = new ArrayList<>();
        for(int i = 0; i < freqArr.length; i++) {
            arrList.add(new Pair((char)i, freqArr[i]));
        }
        Collections.sort(arrList);

        StringBuilder  resStr = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            resStr.append("\0");
        }


        int idx = 0;
        for(int i = 0; i < arrList.size(); i++) {
            char ch = arrList.get(i).ch;
            int freq = arrList.get(i).freq;
            
            if(freq == 0) {              //filled all required characters (with freq >= 1).
                break;
            }

            while(resStr.charAt(idx) != '\0') {
                idx++;
            }

            for(int j = 0; j < freq; j++) {
                
                if(idx + d*j >= resStr.length()) {
                    return "Not possible";
                }

                resStr.setCharAt(idx + d*j, ch);
            }
        }

        return resStr.toString();
    }



    public static void main(String[] args) {
        String str = "geeksforgeeks";

        String resStr = rearrange(str, 3);
        System.out.println(resStr);
    }
}
