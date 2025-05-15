package algo;

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
// Шаг 1: Подсчет частот
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Шаг 2: Сортировка по убыванию частоты
        List<Integer> elements = new ArrayList<>(frequencyMap.keySet());
        elements.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        // Шаг 3: Выбор первых k элементов
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = elements.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3,3,3,3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1))); // [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2))); // [1]
    }
}
