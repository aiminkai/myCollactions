package algo;

import java.util.Arrays;

public class ReverseString {

    public static String reverse(String s){
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = words.length-1; i >= 0; i--){
            result.append(words[i].trim());
            if(i != 0){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse(" Hello  world "));
    }
}
