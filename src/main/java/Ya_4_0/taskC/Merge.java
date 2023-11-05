package Ya_4_0.taskC;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("start----------------------------------->");
        int arr1Size = scanner.nextInt();//Integer.parseInt(scanner.nextLine());
        int[] arr1= new int[arr1Size];
        for (int i = 0; i < arr1Size; i++) {
            arr1[i]=scanner.nextInt();
        }
        int arr2Size = scanner.nextInt();//Integer.parseInt(scanner.nextLine());
        int[] arr2 = new int[arr2Size];
        for (int i = 0; i < arr2Size; i++) {
            arr2[i] = scanner.nextInt();
        }
//        System.out.println("end");
        int[] resArr = MergeArr.mergeArr(arr1,arr2);
//        System.out.println(Arrays.toString(resArr));
        for (int i : resArr) {
            System.out.print(i);
            System.out.print(' ');
        }
    }
    public static final class MergeArr {
        public static int[] mergeArr(int[] arr1,int[] arr2) {
            int arr1Size = arr1.length;
            int arr2Size = arr2.length;
            int resArrSize = arr1Size + arr2Size;
            int[] resArr = new int[resArrSize];
            int pointerArr1 = 0;
            int pointerArr2 = 0;
            int pointerResArr = 0;
            if (arr1Size <= arr2Size) {
                if (arr1Size < arr2Size) {
                    while(pointerArr1 < arr1Size) {
                        if (arr1[pointerArr1] < arr2[pointerArr2]) {
                            resArr[pointerResArr++] = arr1[pointerArr1++];
                        } else {
                            resArr[pointerResArr++] = arr2[pointerArr2++];
                        }
                    }

                    while(pointerResArr < resArrSize) {
                        resArr[pointerResArr++] = arr2[pointerArr2++];
                    }
                } else {
                    while(pointerArr1 < arr1Size && pointerArr2 < arr2Size) {
                        if (arr1[pointerArr1] < arr2[pointerArr2]) {
                            resArr[pointerResArr++] = arr1[pointerArr1++];
                        } else {
                            resArr[pointerResArr++] = arr2[pointerArr2++];
                        }
                    }

                    if (pointerArr1 == arr1Size) {
                        while(pointerResArr < resArrSize) {
                            resArr[pointerResArr++] = arr2[pointerArr2++];
                        }
                    } else {
                        while(pointerResArr < resArrSize) {
                            resArr[pointerResArr++] = arr1[pointerArr1++];
                        }
                    }
                }
            } else {
                while(pointerArr2 < arr2Size) {
                    if (arr1[pointerArr1] < arr2[pointerArr2]) {
                        resArr[pointerResArr++] = arr1[pointerArr1++];
                    } else {
                        resArr[pointerResArr++] = arr2[pointerArr2++];
                    }
                }

                while(pointerResArr < resArrSize) {
                    resArr[pointerResArr++] = arr1[pointerArr1++];
                }

                return resArr;
            }

            return resArr;
        }
    }
}
