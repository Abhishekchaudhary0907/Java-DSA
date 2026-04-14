class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {//[1,3,6,7] 2
        // code here
        for(int i = 1; i<arr.length; i++){
            int j = i-1;// sorted arr
            int pivote = arr[i];// a fix number which have to insert in sorted array
            
            while(j>=0){
                if(arr[j] > pivote){
                    arr[j+1] = arr[j];
                    j--;
                }else{
                    break;
                }
            }
            arr[j+1] = pivote;
        }
    }
}
