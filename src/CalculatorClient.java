import calcModule.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

import java.util.Scanner;

public class CalculatorClient {

    public static void main(String args[]) {

        try {

            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);

            Calculator calcObj =
                    CalculatorHelper.narrow(
                            ncRef.resolve_str("Calculator"));

            Scanner sc = new Scanner(System.in);

            int choice;
            double a, b, result;

            do {

                System.out.println("\n===== CORBA Calculator =====");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                if (choice >= 1 && choice <= 4) {

                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();

                    switch(choice) {

                        case 1:
                            result = calcObj.add(a, b);
                            System.out.println("Result = " + result);
                            break;

                        case 2:
                            result = calcObj.sub(a, b);
                            System.out.println("Result = " + result);
                            break;

                        case 3:
                            result = calcObj.mul(a, b);
                            System.out.println("Result = " + result);
                            break;

                        case 4:
                            result = calcObj.div(a, b);
                            System.out.println("Result = " + result);
                            break;

                        default:
                            System.out.println("Invalid choice");
                    }

                } else if (choice == 5) {

                    System.out.println("Exiting Calculator...");

                } else {

                    System.out.println("Invalid choice");
                }

            } while(choice != 5);

            sc.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}