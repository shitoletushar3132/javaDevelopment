// ---------------------------------------------
// Functional Interface Example
// This interface is marked with @FunctionalInterface,
// meaning it can have only one abstract method.
// It is used to enable lambda expressions or method references,
// which help write concise and readable code.
// ---------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;

@FunctionalInterface
interface fun {
    void show(String msg);
}

public class Lambda {

    public static void main(String a[]) {
        fun obj = (msg) -> System.out.println("hwllow" + msg);

        obj.show("Hlwo");

        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 23, 23));


    }
}
