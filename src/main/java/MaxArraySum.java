public class MaxArraySum {

    public static int getMaxArraySum(int[] arr) {
        int maxSum = arr[0];
        int maxSum1 = arr[1];
        for (int i = 2; i < arr.length; i += 2) {
            maxSum = Math.max(Math.max(maxSum, arr[i] + maxSum), arr[i]);
        }
        for (int i = 3; i < arr.length; i += 2) {
            maxSum1 = Math.max(Math.max(maxSum1, arr[i] + maxSum1), arr[i]);
        }
        return Math.max(maxSum, maxSum1);
    }

    public static void main(String[] args) {
        //int arr[] = {-2,1,3,4,5};
        //int arr[] = {1,6,5,2,-9,11,2,1,-2,-3,7};
        //int arr[] = {-1,-2,-3,31,-2};
        int arr[] = {8006,-3505,-2450,-2399,-3423,8968,-2026,-3762,3229,3390,-3828,5507,-2903,-2470,-3401,5498,6049};
        int maxArrSum = getMaxArraySum(arr);
        System.out.println(maxArrSum);
    }
}
