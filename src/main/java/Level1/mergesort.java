class Solution {
    public int[] sortArray(int[] nums) {

        return mergeSort(nums,0,nums.length-1);
    }

    public int[] mergeSort(int[] arr, int lo, int hi){
        if(lo==hi){
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }

        int mid = (lo+hi)/2;
        int[] left = mergeSort(arr,lo,mid);
        int[] right = mergeSort(arr,mid+1,hi);
        int[] merged = merge(left,right);

        return merged;

    }

    public int[] merge(int[] left, int[] right){
        int[] ans = new int[left.length+right.length];
        int i = left.length-1;
        int j = right.length-1;
        int k = i+j+1;
        while(i>=0 && j>=0){
            if(left[i] > right[j]){
                ans[k] = left[i];
                k--;
                i--;
            }else{
                ans[k] = right[j];
                k--;
                j--;
            }
        }

        while(i>=0){
            ans[k] = left[i];
            i--;
            k--;
        }

        while(j>=0){
            ans[k] = right[j];
            j--;
            k--;
        }

        return ans;
    }
}
