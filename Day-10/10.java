class main9 {

    public static int getResults(int n, String str) {
        int[] freqArr = new int[26];
        int resultCount = 0;

        for(int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'A';

            if(freqArr[ch] == 0) {
                freqArr[ch] = 1;         //mark as visited

                if(n > 0) {
                    n--;
                    freqArr[ch] = 2;       //mark as alloted a computer
                }
                else {
                    resultCount++;
                }
            }
            else if(freqArr[ch] == 1) {
                freqArr[ch] = 0;
            }
            else {
                n++;
                freqArr[ch] = 0;
            }
            
        }

        return resultCount;
    }

    public static void main(String[] args) {
        String str = "GACCBDDBAGEE";
        int n = 3;

        int result = getResults(n, str);
        System.out.println(result);
    }
}
