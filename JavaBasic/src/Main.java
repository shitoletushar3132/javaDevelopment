class Mobile{
    String brand;
    int Price;


    static String name;
    // The `static` keyword is used when we want to share
    // the same property or method across all objects of a class.
    // A static variable belongs to the class, not to any specific object.
    // So all instances (objects) share the same copy of it.
    // static variable should be call through class name
    // Mobile.name;


    static{
        name="phone";
        System.out.println(name);

        // in that static block it call once only when the class is loaded
        // no matter how many objects should created .....

        // but if we use constructor then it will we create a muliple times
        // as a object created
    }

    void show(){
        System.out.println(brand+Price+name);
    }
}

public class Main {
    public static void main(String[] args) {

        String name2 = new String("tusahr");
        String name = "Tushar";
        String sirName ="shitole";

        //the difference in both are the name should store in the
        // only the string pool where name2 will store in heap and
        // also in the string pool
        // string pool -> it is a space where the string literal are save
        // also when we save a="tuahr" also b="tuahr" then it points to same object


        // strings are immutable when we can change name="shitole" then it can create a new
        // object in string pool and only it points to that

        String s1= "Tushar";




        // string buffer
        StringBuffer sb = new StringBuffer("Tushar");

        sb.append(" Shitole");

        // System.out.println(sb);


        Mobile obj1 = new Mobile();
        Mobile.name = "Apple";
        obj1.Price=1342;
        obj1.brand="apple";

        Mobile obj2 = new Mobile();
        obj2.Price=1342;
        obj2.brand="apple";




    }
}