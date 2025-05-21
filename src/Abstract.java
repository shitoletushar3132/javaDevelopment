//An abstract class can’t be instantiated.
//A subclass must implement all abstract methods, unless it’s also abstract.
//Use abstraction to focus on what an object does, not how it does it.

abstract  class Car {
    // abstract method is in only the abstract class
    public abstract void drive(); /// declare a method


    // abstract class has normal method also too
    public void playMusic(){
        System.out.println("play music");
    }
}

class Alto extends Car{
    public void drive(){
        System.out.println("car should drive");
    }

}


public class Abstract {
    public static void main(String [] ar){

//        Car obj = new Car();
//        we cannot create a object of the abstract class. we can only implement by using that
//        class

        Car obj = new Alto();
        obj.drive();
        obj.playMusic();
    }

}
