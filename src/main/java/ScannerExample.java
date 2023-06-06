import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args){

        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter Your age: ");
        int age = scanner.nextInt();
        System.out.println("Enter your Name: ");
        String name = scanner.next();
        System.out.println("Hi," + name + "your age is " + age );
    }
}
