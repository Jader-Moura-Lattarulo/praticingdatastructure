import br.com.alura.models.Student;
import br.com.alura.structures.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Student s1 = new Student("Jader");
        Student s2 = new Student("Gabi");
        Student s3 = new Student("Laura");

        Vector list = new Vector();
        System.out.println(list.size());
        list.add(s1);
        System.out.println(list.size());
        list.add(s2);
        System.out.println(list.size());

        System.out.println(list);

        System.out.println(list.contain(s2));
        System.out.println(list.contain(s3));

        Student x = list.get(1);
        System.out.println(x);

        list.add(1, s3);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        for (int i = 0; i < 300; i++) {
            Student y = new Student("Jader" + i);
            list.add(y);
        }

        System.out.println(list);
    }
}
