package algo;

import java.util.Arrays;

public class MergeSortedArrs {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Указатель на конец первого массива (без нулей)
        int j = n - 1; // Указатель на конец второго массива
        int k = m + n - 1; // Указатель на конец результирующего массива

        // Идем с конца и заполняем nums1 наибольшими элементами
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Если остались элементы во втором массиве, копируем их
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        System.out.println(Arrays.toString((nums1)));
    }

    public static void main(String[] args) {
        int[] ar1 = {1,2,3,0,0,0};
        int[] ar2 = {2,5,6};
        int m = 3;
        int n = 3;
        MergeSortedArrs.merge(ar1, m, ar2, n);
    }
}
