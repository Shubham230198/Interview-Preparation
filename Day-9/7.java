class Main7 {

    public static int getCount(String str) {
        int state = 0;
        int resCount = 0; 
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '0') {
                if(state == 0) {
                    //do nothing
                }
                if(state == 1) {
                    state = 2;
                }
                else if(state == 2) {
                    //do nothing
                }
            }
            else if(ch == '1'){
                if(state == 0) {
                    state = 1;
                }
                else if(state == 1) {
                    //do nothing
                }
                else if(state == 2) {
                    resCount++;
                    state = 1;
                }
            }
            else {
                state = 0;
            }
        }

        return resCount;
    }


    public static void main(String[] args) {
        String str = "10101001";

        int patrnCount = getCount(str);
        System.out.println(patrnCount);
    }
}
