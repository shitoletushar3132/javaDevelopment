class Human{
    private int age;
    private String name;

    public int getAge(){
        return  age;
    }

    public String getName(){
        return name;
    }


    public void setAge(int age){
        this.age =age;

        //this refers to the current object
        // When we write age = age, both refer to the method parameter, not the instance variable.
        // It doesn't give an error, but it doesn't do what we want — it just assigns the parameter to itself.
        // To solve this, we use 'this.age = age;' where 'this' refers to the current object.
        // 'this' means the object for which the method is being called.

        // USAGE of 'this':
        // 1. To refer to current class instance variables (as shown above)
        // 2. To invoke current class methods
        // 3. To call current class constructors using 'this()' (constructor chaining)
        // 4. To pass the current object as a parameter to another method or constructor
        // 5. To return the current object from a method (used in method chaining)
    }

    public void setName(String n){
        name =n;
    }
}

class DefaultValues {
    int a;
    boolean b;
    long c;
    short d;
    char e;
    float f;
    double g;

    public void printDefaults() {
        System.out.println("int: " + a);
        System.out.println("boolean: " + b);
        System.out.println("long: " + c);
        System.out.println("short: " + d);
        System.out.println("char: [" + e + "]");
        System.out.println("float: " + f);
        System.out.println("double: " + g);
    }
}

public class Encapsulation {

    public static void main(String args[])
    {
       new DefaultValues().printDefaults();




        Human h1= new Human();
        h1.setAge(23);
        h1.setName("tushar");
        System.out.println(h1.getName() + h1.getAge());
    }

}
