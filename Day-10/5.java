/*
    Search a Word in a 2D Grid of characters:-

    The directions are diagonals, horizontal and vertical.
*/
class main5 {

    public static void findPattern(String[] grid, String word, int r, int c) {
        if(r == grid.length) {
            return;
        }

        if(grid[r].charAt(c) == word.charAt(0)) {

            //right
            boolean flagR = true;
            for(int j = 0; j < word.length(); j++) {
                if(j + c >= grid[0].length()) {
                    flagR = false;
                    break;
                }

                if(word.charAt(j) != grid[r].charAt(j + c)) {
                    flagR = false;
                    break;
                }
            }

            if(flagR == true) {
                System.out.println("pattern found at " + r + ", " + c);
            }


            //bottom
            boolean flagB = true;
            for(int i = 0; i < word.length(); i++) {
                if(i + r >= grid.length) {
                    flagB = false;
                    break;
                }

                if(word.charAt(i) != grid[r + i].charAt(c)) {
                    flagB = false;
                    break;
                }
            }

            if(flagB == true) {
                System.out.println("Pattern is found at " + r + ", " + c);
            }


            //right-bottom
            boolean flagRB = true;
            for(int i = 0, j = 0; i < word.length(); i++, j++) {
                if(i + r >= grid.length || j + c >= grid[0].length()) {
                    flagRB = false;
                    break;
                }

                if(word.charAt(i) != grid[r + i].charAt(c + j)) {
                    flagRB = false;
                    break;
                }
            }

            if(flagRB == true) {
                System.out.println("Pattern is found at " + r + ", " + c);
            }
        }
        
        if(c == grid[0].length() - 1) {
            findPattern(grid, word, r + 1, 0);
        }
        else {
            findPattern(grid, word, r, c + 1);
        }
    }


    public static void main(String[] args) {
        // String[] grid = {"GEEKSFORGEEKS",
        //             "GEEKSQUIZGEEK",
        //             "IDEQAPRACTICE"};
        // String word = "GEEKS";


        String[] grid = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        String word = "EEE";

        findPattern(grid, word, 0, 0);
    }    
}
