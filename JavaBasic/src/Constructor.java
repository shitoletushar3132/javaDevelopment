public class Constructor {
    private int age;
    private String name;
    public Constructor(){
        // when we create a object it will automatically
        // creates a empty or default constructor
        // it is a special method
        // it has the same name as a class name
        // it never return a value
        age = 12;
        name = "raha";
    }

    public  Constructor(int a, String n){
        age =a;
        name=n;
    }

    public static void main(String [] args){
        System.out.println("heool");
    }

}
