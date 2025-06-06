// ===============================
// 📌 Enum in Java
// ===============================
// An enum (short for "enumeration") is a special Java type used to define
// a collection of constants (fixed set of named values).
//
// ✅ Why use enum:
// - Improves type safety (only predefined constants allowed).
// - Makes code more readable and maintainable.
// - Can have fields, methods, and constructors.

enum Status {
    Running, Failed, pending, Success;
}

public class Enum {
    public static void main(String[] a) {
        int i = 5;
        Status s = Status.pending;
        System.out.println(Status.Running);

        Status[] ss = Status.values();

        for (Status s1 : ss) {
            System.out.println(s1);
        }

        switch (s) {
            case Success -> System.out.println("Success");
            case Failed -> System.out.println("Failed");
            default -> System.out.println("Not a case");
        }
    }
}
