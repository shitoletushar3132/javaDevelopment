// in a class has a abstract and it contains only abstract methods
// then we use interfaces
// the interfaces should contains only the abstract methods


// we cannot create there object only we can give the reference of that
interface A2{
    int age=12; // the variables in interface are by default a final and static
    void show(); // that method is by default a abstact method
    void config();
}

interface X{
    void run();
}

interface  Y extends X{
    void walk();
}

// implement is used to inherites the interface so
// class can inherites a two or more interfaces
class B2 implements A2,Y{
   public void show(){
        System.out.println("in Show");
    };
   public void config(){
       System.out.println("in Config");
   }

   public void walk(){};

   public void run(){}
}



public class Interface {

    public static void main(String [] a){
        A2 obj = new B2();
        obj.config();
        obj.show();

        System.out.println(A2.age);
    }
}

/*
class - class -> extends
class - interface -> implements
interface - interface -> extends
*/