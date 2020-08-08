import java.util.*;

class ValidParenthesis {

    private HashMap<Character, Character> map;

    public ValidParenthesis() {
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');     // put (')', ']', '}') as key because,
        this.map.put('}', '{');     // this can easily check the ending of expression by contiansKey method ...
        this.map.put(']', '[');     // if the expression contains key then, simply pop it. Else push into the stack.
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (this.map.containsKey(ch)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char top = '#';
                if(!stack.isEmpty())
                    top = stack.pop();

                if (top != this.map.get(ch))
                    return false;
            } 
            else
                stack.push(ch);
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        while(t --> 0){
            String str = in.next();
            boolean result = new ValidParenthesis().isValid(str);
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        in.close();
    }
}