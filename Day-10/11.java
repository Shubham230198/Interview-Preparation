class main11 {

    public static int getMaxSubstr(String str, int k) {     //O(n), it can dealt with the case, when str do not contain k uniq chars.          //O(n)
        int[] freqArr = new int[256];
        int uniqCount = 0;

        int cStart = 0;
        int cEnd = 0;

        int resStart = -1;
        int resLen = -1;

        for(int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);

            if(freqArr[ch] == 0) {
                uniqCount++;
            }

            freqArr[ch]++;
            cEnd++;

            while(uniqCount > k) {
                cStart++;
                int c = str.charAt(cStart);

                if(freqArr[c] == 1) {
                    uniqCount--;
                }

                freqArr[c]--;
            }


            if(uniqCount == k && (cEnd - cStart > resLen) ) {
                resLen = cEnd - cStart;
                resStart = cStart;
            }

        }

        //print "resLen" characters starting from "resStart"
        for(int i = resStart; i < resStart + resLen; i++) {
            System.out.print(str.charAt(i));
        }


        //returning the length
        return resLen;
    }


    
    public static void main(String[] args) {
        // String str = "aabbcc";
        String str = "aabacbebebe";
        int k = 3;

        int maxLength = getMaxSubstr(str, k);
        System.out.println(maxLength);
    }    
}
