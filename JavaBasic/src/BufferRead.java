import java.util.Scanner;

public class BufferRead {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);  // Corrected: pass System.in to Scanner

            System.out.print("Enter your name: ");
            int name = sc.nextInt();  // Read full line of text

            System.out.println("Hello, " + name + "!");

            sc.close();  // Always close the Scanner
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
