import java.util.*;
public class passingTernaryExp {

	public static String parseTernary(String expression) {
        // Write your code here
        Stack<Character> s = new Stack<>();
        for(int i = expression.length()-1;i>=0;--i)
        {
            if(expression.charAt(i) == '?')
            {
                char v1 = s.pop();
                char v2 = s.pop();
                if(expression.charAt(i-1) == 'T')
                {
                    s.push(v1);
                }
                else
                {
                    s.push(v2);
                }
                i--;
            }
            else if(expression.charAt(i) == ':')
               continue;
            else
            {
                s.push(expression.charAt(i));
            }
        }
        return "" + s.pop();
    }

    // Dont make chsnges here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(parseTernary(sc.next()));
    }
}
