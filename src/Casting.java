class AA{
    public void show1(){
        System.out.println("in a");
    }

}

class BB extends  AA{
    public void show2(){
        System.out.println("in b");
    }

}

public class Casting {

    public static void main(String [] args){
        double d = 34.34;
        int i = (int)d;

        System.out.println(i);

        AA obj = (AA) new BB(); // this is call upcasting
        obj.show1();

//        obj.show2(); // be cannot call to show2 but object is BB still wwe
        // do not call show2 beacuse it can referes to the AA class

        BB obj1 =(BB) obj;///this is call downcasting

        obj1.show2();



    }
}
