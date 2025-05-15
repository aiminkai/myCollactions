package algo;

public class CompressString {
    public static int compress(char[] chars) {
        int write_pos = 0;
        int i = 0;

        while (i < chars.length) {
            char current_char = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current_char) {
                i++;
                count++;
            }
            chars[write_pos++] = current_char;

            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[write_pos++] = c;
                }
            }
        }
        return write_pos;
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }
}
