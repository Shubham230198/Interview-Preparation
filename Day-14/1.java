class main1 {
   
    /*****************************************Method - 1 **************************************/

    public static int optimalBstCost(int[] keys, int[] freq, int[] preSum, int sIdx, int eIdx) {
        if(sIdx == eIdx) {           //if only one element present, than it's freq is answer.
            return freq[sIdx];
        }
        if(sIdx > eIdx) {            //if no element is present, than cost is 0.
            return 0;
        }

        int totalFreq = (sIdx == 0 ? preSum[eIdx] : (preSum[eIdx] - preSum[sIdx - 1]));       //sum of freq [sIdx, eIdx]

        int minCost = Integer.MAX_VALUE;
        for(int i = sIdx; i <= eIdx; i++) {
            int leftSubtreeCost = optimalBstCost(keys, freq, preSum, sIdx, i - 1);
            int rightSubtreeCost = optimalBstCost(keys, freq, preSum, i + 1, eIdx);

            int myCost = leftSubtreeCost + rightSubtreeCost + totalFreq;
            minCost = Math.min(myCost, minCost);
        }

        return minCost;
    }
   
    /**********************************************************************************************/






    /****************************************Method - 2 *******************************************/

    public static int optimalBstCostDP(int[] keys, int[] freq, int[] preSum) {
        int[][] DP = new int[keys.length][keys.length];

        for(int l = 0; l < keys.length; l++) {
            for(int i = 0, j = l; i < keys.length && j < keys.length; i++, j++) {
                if(l == 0) {
                    DP[i][j] = freq[i];
                }
                else {

                    int minCostSubTree = Integer.MAX_VALUE;
                    for(int x = i + 1, y = i - 1; x < keys.length || y < j; x++, y++) {
                        int subTreeCost = 0;

                        if(x == i + 1) {
                            subTreeCost = DP[x][j];
                        }
                        else if(y == j - 1) {
                            subTreeCost = DP[i][y];
                        }
                        else {
                            subTreeCost = DP[x][j] + DP[i][y];
                        }

                        minCostSubTree = Math.min(minCostSubTree, subTreeCost);
                    }

                    int totalFreq = (i == 0 ? preSum[j] : (preSum[j] - preSum[i - 1]));
                    int myCost = minCostSubTree + totalFreq;

                    DP[i][j] = myCost;
                }
            } 
        }


        return DP[0][keys.length - 1];
    }

   
    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};

        int[] preSum = new int[freq.length];
        preSum[0] = freq[0];
        for(int i = 1; i < freq.length; i++) {
            preSum[i] = preSum[i - 1] + freq[i];
        }



        /*   //Recursive

        int cost = optimalBstCost(keys, freq, preSum, 0, keys.length - 1);
        System.out.println(cost);
        */



        //DP
        int costDP = optimalBstCostDP(keys, freq, preSum);
        System.out.println(costDP);
    
    }
}