import br.com.alura.stackj.StackJ;

import java.util.Stack;

public class StackJTest {
    public static void main(String[] args) {
        StackJ stackJ = new StackJ();

        stackJ.insert("Jader");
        System.out.println(stackJ);

        stackJ.insert("Gabi");
        System.out.println(stackJ);

        String r1 = stackJ.remove();
        System.out.println(r1);

        String r2 = stackJ.remove();
        System.out.println(r2);

        System.out.println(stackJ);

        System.out.println(stackJ.empty());

        Stack<String> stringStack = new Stack<String>();

        stringStack.push("Jader");
        stringStack.push("Gabi");

        System.out.println(stringStack);


        //stringStack.pop();
        String name = stringStack.peek();
        System.out.println(name);
    }
}
