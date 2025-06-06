package packag;

///  that file will belong to the packag package

public class Test2 {

    public int access = 3132;

    ///  if you want to access that variable outside the package
    /// then always make it public
    /// by default it can be accessible only with in package
    /// private will accessible with in only same class
    /// the protected will accessible only within same class and same package and subClass
    /// public should accessible anywhere
    /// and default access in same class and same package
    public static <T> void print(T any) {
        System.out.println(any);
    }

    public static void main(String[] a) {
        print("ehlooalajf");
    }
}
