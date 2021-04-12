import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

    final ElevatorValues values = new ElevatorValues();

    final LinkedList<Integer> pickUpOrder = new LinkedList<Integer>();

    public Elevator(int elevatorID, int currentFloor) {
        this.values.elevatorID = elevatorID;
        this.values.currentFloor = currentFloor;
        this.values.targetFloor = Integer.MAX_VALUE;
    }

    public int getCurrentFloor() {
        return this.values.currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.values.currentFloor = floor;
    }

    public int getTargetFloor() {
        return this.values.targetFloor;
    }

    public void setTargetFloor(int floor) {
        this.values.targetFloor = floor;
    }

    public int getElevatorID() {
        return this.values.elevatorID;
    }

    public void addtarget(int targetFloor) {
        this.pickUpOrder.addLast(targetFloor);
    }

    public void step() {
        if(this.values.targetFloor != Integer.MAX_VALUE) {
            this.values.currentFloor = this.values.targetFloor;
        }
        if (!this.pickUpOrder.isEmpty()) {
            this.values.targetFloor = this.pickUpOrder.removeFirst();
        }
    }

}
