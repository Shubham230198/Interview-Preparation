class main8 {

    public static void printAns(String str, int idx, String asf) {
        if(idx == str.length()) {
            System.out.println(asf);
            return;
        }
        
        String temp = "(";
        for(int i = idx; i < str.length(); i++) {
            temp += str.charAt(i);
            printAns(str, i + 1, asf + temp + ")");
        }
    }
    
    public static void main(String[] args) {
        String str = "abc";

        printAns(str, 0, "");
    }
}
