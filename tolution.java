class tolution {
    public int maxSubArray(int[] nums) {
        int globalSum = Integer.MIN_VALUE;
        int CurrentSum = 0;
        for (int i=0;i<nums.length;i++){
            CurrentSum += nums[i];
            
            if (CurrentSum>globalSum)
            {
                globalSum = CurrentSum;
            }
            
            if (CurrentSum<0){
                CurrentSum=0;
            }
            
        }
        return globalSum;
    }


public static void main(String[] args) {
    tolution Myobject = new tolution();
    int[] nums = {10, 20, -30, 40};
    int res = Myobject.maxSubArray(nums);
    System.out.println(res);

}
}