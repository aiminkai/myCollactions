package algo;

import java.util.Arrays;

//Дан массив целых чисел, отсортированный по возрастанию, верните массив квадратов каждого числа, отсортированный по возрастанию.
//        Ввод: [-9, -5, 1, 5, 13]
//        Вывод: [1, 25, 25, 81, 169]
public class SortedSquares {
    public static int[] arrayToSq(int [] inputArr) {
        int length = inputArr.length;
        int[] result = new int[length];
        int f = 0;
        int l = length -1;

        for (int i = length -1 ; i >= 0; i--){
            if(inputArr[f] * inputArr[f] > inputArr[l] * inputArr[l])  {
                result[i] = inputArr[f] * inputArr[f];
                f++;
            } else {
                result[i] = inputArr[l] * inputArr[l];
                l--;
            }

        }
//        Arrays.sort(result);
        return result;
    }

    public static int[] sortedSquares(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        // два указателя: l — на начало (самые отрицательные), r — на конец (самые большие)
        int l = 0, r = n - 1;
        // заполняем итоговый массив с конца, куда идут наибольшие квадраты
        for (int i = n - 1; i >= 0; i--) {
            // сравниваем абсолютные значения концов
            if (Math.abs(a[l]) > Math.abs(a[r])) { // квадрат левого элемента больше — записываем и сдвигаем l вправо
                res[i] = a[l] * a[l];
                l++;
            } else {// иначе — правый элемент, сдвигаем r влево
                res[i] = a[r] * a[r];
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-9, -5, 1, 5, 13};

        System.out.println(Arrays.toString(SortedSquares.arrayToSq(input)));
        System.out.println(Arrays.toString(SortedSquares.sortedSquares(input)));
    }
}
