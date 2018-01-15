package sort;


public class Sorts {
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //从第二个数开始往后走，缓存下当前这个数来找地方插入
            int current = arr[i];
            //初始化前一个数，因为current往后走所以before会越来越多，所以对于before又有一个往前的循环
            int before = i - 1;
            for (; before >= 0 && arr[before] > arr[i]; before--) {
                arr[before + 1] = arr[before];
            }
            arr[before + 1] = current;
        }
        return arr;
    }
}
