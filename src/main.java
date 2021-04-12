import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class main {

    public static void main(String args[]) throws IOException {

        IElevatorSystem elevators = new ElevatorEngine();

        System.out.println("To exit write q");
        System.out.println("Actions:");
        System.out.println("add - adds new elevator (max 16)");
        System.out.println("pickup - call an elevator");
        System.out.println("step - moves elevators");
        System.out.println("print - prints statuses of every added elevator");
        System.out.println("update - updates values of inserted elevator");
        System.out.println("help - writes the possible actions");

        boolean flag = true;
        while(flag){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            switch (str) {
                case "q":
                    flag = false;
                    break;
                case "add":
                    elevators.addNewElevator();
                    System.out.println("elevator added");
                    break;
                case "pickup": {
                    System.out.println("enter start floor [number]");
                    Scanner sc = new Scanner(System.in);
                    int startFloor = sc.nextInt();
                    System.out.println("enter target floor [number]");
                    Scanner sc2 = new Scanner(System.in);
                    int targetFloor = sc2.nextInt();
                    elevators.pickup(startFloor, targetFloor);
                    System.out.println("pickup request added");
                    break;
                }
                case "step":
                    elevators.step();
                    System.out.println("stepped");
                    break;
                case "print":
                    elevators.printElevatorStatuses();
                    break;
                case "update": {
                    System.out.println("enter elevatorID [number]");
                    Scanner sc = new Scanner(System.in);
                    int elevatorID = sc.nextInt();
                    System.out.println("enter start floor [number]");
                    Scanner sc2 = new Scanner(System.in);
                    int startFloor = sc2.nextInt();
                    System.out.println("enter target floor [number]");
                    Scanner sc3 = new Scanner(System.in);
                    int targetFloor = sc3.nextInt();
                    elevators.update(elevatorID, startFloor, targetFloor);
                    System.out.println("updated");
                    break;
                }
                case "help":
                    System.out.println("To exit write q");
                    System.out.println("Actions:");
                    System.out.println("add - adds new elevator (max 16)");
                    System.out.println("pickup - call an elevator");
                    System.out.println("step - moves elevators");
                    System.out.println("print - prints statuses of every added elevator");
                    System.out.println("update - updates values of inserted elevator");
                    System.out.println("help - writes the possible actions");
                    break;
                default:
                    System.out.println("no command matching, write a command from one of the followings:");
                    System.out.println("To exit write q");
                    System.out.println("Actions:");
                    System.out.println("add - adds new elevator (max 16)");
                    System.out.println("pickup - call an elevator");
                    System.out.println("step - moves elevators");
                    System.out.println("print - prints statuses of every added elevator");
                    System.out.println("update - updates values of inserted elevator");
                    System.out.println("help - writes the possible actions");
                    break;
            }

        }
    }


}
