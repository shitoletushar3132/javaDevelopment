import packag.Test2;
// that line can import a class from the package and use that any where
//import packag.*;
//this can import all thing form the packag which can import all the java files nota
// folder ...if inside packag we have a another folder pag then it don't import using
// import package.* but we do -> import package.pag.*;9
public class Test3 {

    public static void main(String [] args){
        Test2.print("hello");
    }
}
