import br.com.alura.models.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println(list);
        list.addFirst("Jader");
        System.out.println(list);
        list.addFirst("Gabi");
        System.out.println(list);
        list.addFirst("Laura");
        System.out.println(list);
        list.add("Marly");
        System.out.println(list);
        list.add(2,"Rita");
        System.out.println(list);

        Object x = list.get(2);
        System.out.println(x);

        System.out.println(list.size());

        list.removeFromStart();
        System.out.println(list);

        list.removeFromEnd();
        System.out.println(list);

        list.add("Bacon");
        list.add("Homer");
        list.add("Batman");
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        System.out.println(list.contains("Gabi"));
        System.out.println(list.contains("Marly"));
    }
}
