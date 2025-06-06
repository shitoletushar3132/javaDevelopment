class A1{
    public void show(){
        System.out.println("Print in A");
    }
}

class B1 extends A1{
    public void show(){
        System.out.println("Print in B");
    }
}


public class Polymorphism {

    // polymorphism means "many forms"
    // it is concept of oops in that one method,name or operator to
    // behave differently depending on the context
    //In Java, polymorphism allows objects to behave differently based on their class type, even if they
    // share the same interface or superclass.

    // 1. compile-time polymorphism (method overriding)
    // method name is the same but parameters are different (type or number)
    // 2. Runtime polymorphism (Method Overriding)
    // A subclass provides a specific implementation of a method that
    // is already defined in its superclass


    public static void main(String [] ar){
        A1 obj = new A1();
        // in java we can make a type as a parent and obj as a child
        // means obj is referes as type of A1

        obj.show();

        obj = new B1();

        obj.show();

        // in that obj should behave differently with
        // different objects of class .... this is call dynamic polymorphism


    }
}
