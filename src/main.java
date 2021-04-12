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

        boolean flag = true;
        while(flag){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            if(str.equals("q")) flag = false;

            if(str.equals("add")){
                elevators.addNewElevator();
                System.out.println("elevator added");
            }

            if(str.equals("pickup")){
                System.out.println("enter start floor");
                Scanner sc=new Scanner(System.in);
                int startFloor = sc.nextInt();
                System.out.println("enter target floor");
                Scanner sc2=new Scanner(System.in);
                int targetFloor = sc2.nextInt();
                elevators.pickup(startFloor,targetFloor);
                System.out.println("pickup request added");
            }

            if(str.equals("step")){
                elevators.step();
                System.out.println("stepped");
            }

            if(str.equals("print")){
                elevators.printElevatorStatuses();
            }

            if(str.equals("update")){
                System.out.println("enter elevatorID");
                Scanner sc=new Scanner(System.in);
                int elevatorID = sc.nextInt();
                System.out.println("enter start floor");
                Scanner sc2=new Scanner(System.in);
                int startFloor = sc2.nextInt();
                System.out.println("enter target floor");
                Scanner sc3=new Scanner(System.in);
                int targetFloor = sc3.nextInt();
                elevators.update(elevatorID,startFloor,targetFloor);
                System.out.println("updated");
            }

        }
    }


}
