class MyException extends Exception{
    public MyException(String str){
            super(str);
    }
}

public class Errors {

    public static void main(String []arg){
        System.out.println("hello");

        int i = 9;

        try{
            int j = 8/i;
            if(j == 0){
                throw new MyException("i don't want a zero as output");
            }
            System.out.println(j);
        }catch (Exception e){
            System.out.println("Something went wrong "+ e);
        }



        System.out.println("by");
    }
}
