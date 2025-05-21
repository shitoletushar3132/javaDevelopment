final class Ca{
//    if you use a final keyword in a class then it do
//    not exetended by another class
//    you can stop inheritance by using Ca class
    public void show(){
        System.out.println("in calc show");
    }

    public final void add(int a, int b){
//        to stop overriding of the method we can use a
//        final keyword to stop overriding of the method
        System.out.println(a+b);
    }
}

//class Ba extends Ca{
//
//}


public class FinalVariable {
    public static void main(String [] a){
        final int num = 8;
//        num = 9;
//        the final key word should use to make a value as a constant
//        no one change that value
        System.out.println(num);

        Ca obj = new Ca();


//      every class can inherites the object class by default
//        and the object class can contains a method like toString(), equals()
//        that method we can use in our object

    }
}
