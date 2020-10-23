class Main6 {
    public static void main(String[] args) {
        String str = "00011110001110";

        int zeroSubstr = 0;
        int oneSubstr = 0;

        if(str.charAt(0) == '0') {
           zeroSubstr++; 
        }
        else {
            oneSubstr++;
        }

        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i - 1)) {
                if(str.charAt(i) == '0') {
                    zeroSubstr++;
                }
                else {
                    oneSubstr++;
                }
            }
        }

        
        int minSubstrFlip = Math.min(zeroSubstr, oneSubstr);
        System.out.println(minSubstrFlip);
        
    }    
}
