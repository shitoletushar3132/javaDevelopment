class A{
    public A()
    {
        //  even we do not mention every constructor has
        // a super() method by default first
        super();
        System.out.println("In A");
    }

    public A(int n){
        System.out.println(n);
    }

}
class B extends A{
    public B(){
        super();
        System.out.println("IN B");
    }

    public B(int n){
        // super(n);
        // it can call the constructor of the parent class
        this();
        // this can call the another constructor of the class
        System.out.println("in B int");
    }

}

class Calc{
    public int add(int n1, int n2){
        return n1+n2;
    }

    public int sub (int n1, int n2){
        return  n1-n2;
    }
}

class AdvCal extends Calc{

    @Override
    public int add(int n1,int n2){
        return n1+n2;
    }
    // in that we can create a same method as a parent class
    // with same name same parameters
    // but when we call it can call its own method not parent

    public int mul(int n1, int n2){
        return n1*n2;
    }

    public int div(int n1, int n2){
        return  n1/n2;
    }
}


class VeryAdvCalc extends AdvCal {
    public double Pow(int n,int p){
        return Math.pow(n,p);
    }
}


public class Inheritance {

    public static void main(String [] args){
        VeryAdvCalc obj = new VeryAdvCalc();
        int r1 = obj.add(1,2);
        int r2 = obj.sub(1,2);
        int r3 = obj.mul(24,2);
        int r4 = obj.div(1234,1234);
        double r5 = obj.Pow(2,4);



        System.out.println(r1+"  "+r2+" "+r3+" "+r4+" "+r5);
    }
}
