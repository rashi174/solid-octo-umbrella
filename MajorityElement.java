class Solution {
    public int majorityElement(int[] a) {
        int count=0;
        int ansIndex=0;
        int size=a.length;
        for(int i=0;i<size;i++){
            if (a[i]==a[ansIndex]){
                count++;
            }
            else{
                count--;
            }
            if (count==0){
                ansIndex=i;
                count++;
            }
        }
        return a[ansIndex];
    }
}