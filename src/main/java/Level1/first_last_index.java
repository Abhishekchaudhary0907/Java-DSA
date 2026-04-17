class Solution {
    public int[] searchRange(int[] nums, int target) {//[2,4,4,4,4,4,4,4,6]lo = 5 and hi = 8
        
        int lo = 0;
        int hi = nums.length-1;
        int li = -1;
        // first last index
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>target){
                hi = mid-1;
            }else if(nums[mid]<target){
                lo = mid+1;
            }else{
                li = mid;
                lo=mid+1;;
            }

        }

        // first index

        lo = 0;
        hi = nums.length-1;
        int fi = -1;
        // first find fi
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>target){
                hi = mid-1;
            }else if(nums[mid]<target){
                lo = mid+1;
            }else{
                fi = mid;
                hi = mid-1;
            }

        }
        int [] ans = {fi,li};
        return ans;

    }
}
