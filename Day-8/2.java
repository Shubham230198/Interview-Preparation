//Find Height of tree, represented by parent array.
class Main2{

    static int findHeight(int[] height, int[] arr, int idx) {

        if(height[idx] != 0) {         //applying memoisation
            return height[idx];
        }

        if(arr[idx] == -1) {          //base case (if reached the root)
            height[idx] = 1;
            return height[idx];
        }

        
        int hisHeight = findHeight(height, arr, arr[idx]);
        height[idx] = hisHeight + 1;

        return height[idx];
    }


    public static void main(String[] args) {

        // int[] arr = {1, 5, 5, 2, 2, -1, 3};
        int[] arr = {-1, 0, 0, 1, 1, 3, 5};
        int[] height = new int[arr.length];

        int actualHeight = 0;
        for(int i = 0; i < height.length; i++) {
            int nowHeight = findHeight(height, arr, i);

            actualHeight = Math.max(nowHeight, actualHeight);
        }

        System.out.println(actualHeight);

    }
}