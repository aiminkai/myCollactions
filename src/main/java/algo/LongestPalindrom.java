package algo;

public class LongestPalindrom {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Для нечетных палиндромов (центр - один символ)
            int len1 = expandAroundCenter(s, i, i);
            // Для четных палиндромов (центр - два символа)
            int len2 = expandAroundCenter(s, i, i + 1);
            // Выбираем максимальную длину
            int len = Math.max(len1, len2);

            // Если нашли палиндром длиннее предыдущего
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        // Расширяемся в обе стороны, пока символы совпадают
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Возвращаем длину палиндрома
        return right - left - 1;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
