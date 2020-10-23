import java.util.*;
class main7 {

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        
        ArrayList<StringBuilder> results = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            results.add(new StringBuilder());
        }
        

        int currRow = 0;
        boolean goingDown = false;             //imp to keep it negative at first, bcz check will make it true, at (i = 0);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            results.get(currRow).append(ch);
            
            if(currRow == 0 || currRow == numRows - 1) {       //fliping the direction
                goingDown = !goingDown;
            }
            
            currRow += (goingDown) ? 1 : -1;                   //going to next or prev row, as per the direction.
        }
        
        
        StringBuilder output = new StringBuilder();
        for(StringBuilder str : results) {
            output.append(str);
        }
        
        return output.toString();
    }
    
    public static void main(String[] args) {

        String s = "GEEKSFORGEEKS";
        int n = 3;

        String output = convert(s, n);
        System.out.println(output);
        
    }
}
