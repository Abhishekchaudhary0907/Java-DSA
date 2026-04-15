class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //length// say 3    //[1,2,3]
        //cal binary of 0 to ((2 power length) - 1) // 0 ,1 2, 3, 4, 5, 6, 7, 8
        //[0,0,0]
        //[0,0,1]
        //[0,1,0]
        //[0,1,1]
        //[1,0,0]
        //[1,0,1]
        //[1,1,0]
        //[1,1,1]

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int limit = (int)Math.pow(2,nums.length);// 8

        for(int i=0; i<limit; i++){
            // convert binary for every i
            List<Integer> sublist = new ArrayList<Integer>();
            int idx = nums.length-1;
            int number = i;

            for(int j=0; j<nums.length; j++){
                // length 3 hai to 0 se 7 tk ka only 3 time me hi binary aa jayega

                int r = number%2;
                number = number/2;
                if(r == 1){
                    // first value of r represent last and so on
                    sublist.addFirst(nums[idx]);
                }
                idx--;
            }
            ans.add(sublist);

        }
        return ans;
    }
}
