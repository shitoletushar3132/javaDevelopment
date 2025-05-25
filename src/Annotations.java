// it is a meta data or suppliment to compiler
class A3{
    public void showAa(){
        System.out.println("in Show A");
    }
}

class B3 extends  A3{
    @Override
    public void showAa(){
        System.out.println("in show B");
    }
}
public class Annotations {

    public static void main(String [] arg){
        B3 obj = new B3();
        obj.showAa();
    }
}
