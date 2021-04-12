import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class ElevatorEngine implements IElevatorSystem {

    final List<Elevator> elevators = new ArrayList<Elevator>();

    @Override
    public void pickup(int from, int to) {
        if (findClosestElevator(from) != -1) {

            update(findClosestElevator(from), elevators.get(findClosestElevator(from)).getCurrentFloor(), from);
            elevators.get(findClosestElevator(from)).pickUpOrder.remove(from);
            elevators.get(findClosestElevator(from)).addtarget(to);

        } else {
            System.out.println("no elevators added");
        }
    }

    @Override
    public void update(int elevatorID, int currentFloor, int targetFloor) {
        elevators.get(elevatorID).setCurrentFloor(currentFloor);
        elevators.get(elevatorID).setTargetFloor(targetFloor);
    }

    @Override
    public void step() {
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }

    @Override
    public List<ElevatorValues> status() {
        List<ElevatorValues> result = new ArrayList<>();
        for (Elevator elevator : elevators) {
            ElevatorValues row = new ElevatorValues();
            row.elevatorID = elevator.getElevatorID();
            row.currentFloor = elevator.getCurrentFloor();
            row.targetFloor = elevator.getTargetFloor();
            result.add(row);
        }
        return result;
    }

    @Override
    public void addNewElevator() {
        if (elevators.size() < 16) {
            elevators.add(new Elevator(elevators.size(), 0));
        }
    }

    private int findClosestElevator(int currentFloor) {
        int minDistance = Integer.MAX_VALUE;
        int closestElevatorID = -1;
        for (int i = 0; i < elevators.size(); i++) {
            if (abs(elevators.get(i).getCurrentFloor() - currentFloor) < minDistance) {
                minDistance = abs(elevators.get(i).getCurrentFloor() - currentFloor);
                closestElevatorID = i;
            }
        }
        return closestElevatorID;
    }

    @Override
    public void printElevatorStatuses() {
        for (Elevator elevator : elevators) {
            System.out.println("Elevator ID:" + elevator.getElevatorID());
            System.out.println("Elevator current floor:" + elevator.getCurrentFloor());
            System.out.println("Elevator target floor:" + elevator.getTargetFloor());
            System.out.println("===");
        }
    }

}
