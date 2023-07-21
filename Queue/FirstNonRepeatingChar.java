package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {

    Queue<Character> q = new LinkedList<>();
    String str = "";
    char[] arr = new char[26];

    void findFirstCharacter(String s) {
        for(char ch: s.toCharArray()) {
            arr[ch - 'a']++;
            q.add(ch);
            char firstCh = q.peek();
            while (arr[firstCh - 'a'] > 1) {
                q.remove();
                arr[firstCh - 'a']--; 
                if (!q.isEmpty())
                    firstCh = q.peek();
                else {
                    firstCh = '#';
                    break;
                }

            }
            System.out.println(q);
            str += firstCh;

        }
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar obj = new FirstNonRepeatingChar();
        String s = "abcbadc";
        obj.findFirstCharacter(s);
        System.out.println(obj.str);
    }
}
