class main6 {

    public static int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }


    //construct a count array where value at every index contains
    //count of smaller and equal characters in whole string.
    public static void populateCount(int[] count, char[] str) {     //O(str.length)
        for(int i = 0; i < str.length; i++) {
            count[str[i]]++;
        }

        for(int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
    }

    //removes a character ch from count[] array
    public static void updateCount(int[] count, char ch) {         //O(1)
        for(int i = ch; i < 256; i++) {
            count[i]--;
        }
    }


    public static int findRank(char[] str) {
        int len = str.length;
        int mul = factorial(len);
        int rank = 1;

        int[] count = new int[256];
        populateCount(count, str);

        for(int i = 0; i < len; i++) {
            mul /= len - i;

            // count number of char smaller than str[i] 
            // fron str[i+1] to str[len-1]
            rank += count[str[i] - 1] * mul;

            //reduce the count of characters greater than str[i]
            updateCount(count, str[i]);
        }

        return rank;
    }


    public static void main(String[] args) throws Exception{
        // char[] str = "cba".toCharArray();
        char[] str = "string".toCharArray();

        int rank = findRank(str);         //O(len)
        System.out.println(rank);

    }    
}
