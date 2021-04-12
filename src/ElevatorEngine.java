import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import static java.lang.Math.abs;

public class ElevatorEngine implements IElevatorSystem {

    final List<Elevator> elevators = new ArrayList<Elevator>();

    @Override
    public void pickup(int from, int to) {
        if (findClosestElevator(from) != -1) {

        boolean flag = true;

        if(to<from){
            boolean flag2 = true;
            int elevidnex= -1;
            for (Elevator elevator : elevators) {
                if(elevator.getCurrentFloor()>=from && elevator.getTargetFloor()<=to){
                    elevidnex = elevator.getElevatorID();
                    flag = false;
                }
                else if(elevator.getCurrentFloor()>=from && elevator.getTargetFloor()>to){
                    elevidnex = elevator.getElevatorID();
                    flag2 = false;
                }
            }
            if(!flag) {
                if(elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE) {
                    int elevatorPrevTarget = elevators.get(elevidnex).getTargetFloor();
                    elevators.get(elevidnex).pickUpOrder.addFirst(elevatorPrevTarget);

                }

                if(elevators.get(elevidnex).getTargetFloor() < to && elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE){
                    update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                    elevators.get(elevidnex).pickUpOrder.addFirst(to);
                }
                else {
                    update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                    elevators.get(elevidnex).addtarget(to);
                }
            }
            else if(!flag2){
                if(elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE) {
                    int elevatorPrevTarget = elevators.get(elevidnex).getTargetFloor();
                    elevators.get(elevidnex).pickUpOrder.addFirst(elevatorPrevTarget);
                }
                update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                elevators.get(elevidnex).addtarget(to);
            }

        }
        else if(to>from){
            boolean flag2 = true;
                int elevidnex= -1;
                for (Elevator elevator : elevators) {
                    if(elevator.getCurrentFloor()<=from && elevator.getTargetFloor()>=to){
                        elevidnex = elevator.getElevatorID();
                        flag = false;
                    }
                    else if(elevator.getCurrentFloor()<=from && elevator.getTargetFloor()<to){
                        elevidnex = elevator.getElevatorID();
                        flag2 = false;
                    }
                }
                if(!flag) {
                    if(elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE) {
                        int elevatorPrevTarget = elevators.get(elevidnex).getTargetFloor();
                        elevators.get(elevidnex).pickUpOrder.addFirst(elevatorPrevTarget);
                    }

                    if(elevators.get(elevidnex).getTargetFloor() > to && elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE){
                        update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                        elevators.get(elevidnex).pickUpOrder.addFirst(to);
                    }
                    else {
                        update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                        elevators.get(elevidnex).addtarget(to);
                    }
                }
                else if(!flag2){
                    if(elevators.get(elevidnex).getTargetFloor()!= Integer.MAX_VALUE) {
                        int elevatorPrevTarget = elevators.get(elevidnex).getTargetFloor();
                        elevators.get(elevidnex).pickUpOrder.addFirst(elevatorPrevTarget);
                    }
                    update(elevidnex, elevators.get(elevidnex).getCurrentFloor(), from);
                    elevators.get(elevidnex).addtarget(to);
                }
            }

        if(flag){
            if(elevators.get(findClosestElevator(from)).getTargetFloor()== Integer.MAX_VALUE){
                update(elevators.get(findClosestElevator(from)).getElevatorID(),elevators.get(findClosestElevator(from)).getCurrentFloor(),from);
                if(from == 0){
                    update(elevators.get(findClosestElevator(from)).getElevatorID(),elevators.get(findClosestElevator(from)).getCurrentFloor(),to);
                }
            }
            else {
                elevators.get(findClosestElevator(from)).addtarget(from);
                elevators.get(findClosestElevator(from)).addtarget(to);
            }
        }

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
