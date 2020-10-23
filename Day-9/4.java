class Main4 {

    public static int countAns(String str) {
        if(str.length() == 1) {
            return 1;
        }

        int res = 1;

        for(int i = 0; i < str.length(); i++) {
            
            if(i == 0) {
                if(str.charAt(i) == str.charAt(i + 1)) {
                    res *= 1;
                }
                else {
                    res *= 2;
                }
            }
            else if(i == str.length() - 1) {
                if(str.charAt(i) == str.charAt(i - 1)) {
                    res *= 1;
                }
                else {
                    res *= 2;
                }
            }
            else {
                if(str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i + 1)) {
                    res *= 1;
                }
                else if(str.charAt(i) == str.charAt(i - 1) || str.charAt(i) == str.charAt(i + 1) || str.charAt(i - 1) == str.charAt(i + 1)) {
                    res *= 2;
                }
                else {
                    res *= 3;
                }
            }

        }

        return res;
    }



    public static void main(String[] args) {
        String str = "aab";

        int resCount = countAns(str);
        System.out.println(resCount);
    }
}
