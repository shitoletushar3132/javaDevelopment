import java.util.*;
public class Collections {

    public static void main(String a[]){

        Map <String, Integer> students = new HashMap<>();

        students.put("tushar",100);
        students.put("raj",30);
        students.put("tam",32);
        students.put("ram",10);

        Arrays.asList("Tushar", "Akash", "Ravi", "Amol")
                .stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

//        List <Integer> nums = Arrays.asList(3,4,5,6,6,43);




//        System.out.println(students);

    }
}
