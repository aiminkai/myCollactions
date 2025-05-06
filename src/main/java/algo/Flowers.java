package algo;

public class Flowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean prevEmpty = (i == 0) || (flowerbed[i-1] == 0);
            boolean nextEmpty = (i == flowerbed.length - 1) || (flowerbed[i+1] == 0);
            if(flowerbed[i] == 0 && prevEmpty && nextEmpty) {
                flowerbed[i] = 1;
                count++;
                if (count >= n) {
                    return true;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n)); // Вывод: true
    }
}
