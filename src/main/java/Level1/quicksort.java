class Solution {
    public void quickSort(int[] arr, int low, int high) {
        
        if(low>high){
            return;
        }
        
        int pivotIdx = partition(arr,low,high);
        quickSort(arr,low,pivotIdx-1);
        quickSort(arr,pivotIdx+1,high);
        
        
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        int i = low;
        int j = low;
        int pivot = arr[high];
        
        while(i<=high){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j-1;
    }
}
