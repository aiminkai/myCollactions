package algo;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        // Шаг 1: Находим точку перегиба (первый элемент, который меньше следующего)
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Шаг 2: Если такая точка найдена, находим элемент для обмена
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Шаг 3: Переворачиваем оставшуюся часть массива
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] mass = new int[]{1,1,5,4,3};
        nextPermutation(mass);
        System.out.println(Arrays.toString(mass));
    }
}
