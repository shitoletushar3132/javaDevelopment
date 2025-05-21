class AC{
    int age;

    public void show(){
        System.out.println("in show");
    };

    class BC{
        public void config(){
            System.out.println("in config");
        }
    }
}

public class InnerClass {

    public static void main(String [] a){
        AC obj = new AC();

        obj.show();

        AC.BC obj1 = obj.new BC();// to create a object of the
// inner class

    }

}
