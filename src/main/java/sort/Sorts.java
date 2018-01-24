package sort;

public class Sorts {
    public static void main(String[] args) {
        int[] result = quickSort(new int[]{3, 2, 234, 64, 5, 768, 3, 5, 7, 4643, 6});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

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

    public static int[] quickSort(int[] arr) {
        _quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void _quickSort(int[] arr, int from, int to) {
        if (from >= to) {
            return;
        }

        int target = arr[to];
        int pos_for_target = from;
        for (int i = from; i < to; i++) {
            if (arr[i] < target) {
                int tmp = arr[i];
                arr[i] = arr[pos_for_target];
                arr[pos_for_target] = tmp;
                pos_for_target++;
            }
        }

        int tmp = arr[pos_for_target];
        arr[pos_for_target] = arr[to];
        arr[to] = tmp;

        _quickSort(arr, from, pos_for_target - 1);
        _quickSort(arr, pos_for_target + 1, to);

        return;
    }
}


