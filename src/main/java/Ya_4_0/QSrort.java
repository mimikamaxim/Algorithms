package Ya_4_0;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class QSrort {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 7, 3, 2};
//        int[] arr2 = {3,7,1};
//        int[] arr3 = Arrays.stream(arr1).skip(1).toArray();
//        int just = arr2[arr2.length];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(qSort(arr1)));
    }

    static Random randomProvider = new Random();

    public static int[] qSort(int[] arr) {
        int arrLength = arr.length;
        int pivot = randomProvider.nextInt(0, arr[arrLength - 1]);
        int equalsPoint = 0, greaterPoint = 0, nextPoint = 0;
        while (nextPoint < arrLength) {
            switch (intCompare(pivot, arr[nextPoint])) {
                case 1 -> {
                    nextPoint++;
                }
                case -1 -> {
                    int acc = arr[nextPoint];
                    arr[nextPoint] = arr[greaterPoint];
                    arr[greaterPoint] = arr[equalsPoint];
                    arr[equalsPoint] = acc;
                    equalsPoint++;
                    greaterPoint++;
                    nextPoint++;
                }
                case 0 -> {
                    int acc = arr[nextPoint];
                    arr[nextPoint]=arr[greaterPoint];
                    arr[greaterPoint]= acc;
                    greaterPoint++;
                    nextPoint++;
                }
            }
        }

        return join(qSort(Arrays.copyOfRange(arr,0,equalsPoint-1)),
                Arrays.copyOfRange(arr,equalsPoint,greaterPoint-1),
                qSort(Arrays.copyOfRange(arr,greaterPoint,arrLength-1)));
    }

    public static int intCompare(int pivot, int current) {
        if (pivot < current) return 1;
        if (pivot > current) return -1;
        return 0;
    }

    public static int[] join(int[] a, int[] b, int[] c)
    {
        int[] arr1 = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .toArray();
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(c))
                .toArray();
    }
}
