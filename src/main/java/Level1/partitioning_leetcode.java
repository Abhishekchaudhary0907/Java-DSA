class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int i=0 , left = 0;
        int k = nums.length-1;
        int right = k;
        int[] res = new int[k+1];
        
        while(i<nums.length){
            if(nums[i] < pivot){
                res[left] = nums[i];
                left++;
            }
            if(nums[k] > pivot){
                res[right] = nums[k];
                right--;

            }
            i++;
            k--;
        }

        while(left<=right){
            res[left] = pivot;
            left++;
        }

        return res;
    }
}
