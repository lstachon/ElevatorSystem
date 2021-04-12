import org.junit.Test;

import static org.junit.Assert.*;

public class ElevatorTest {

    @Test
    public void elevatorTargetFloorTest1() {
        Elevator elevator = new Elevator(0, 0);
        elevator.addtarget(10);
        elevator.step();
        assertEquals(elevator.getTargetFloor(), 10);
    }

    @Test
    public void elevatorTargetFloorTest2() {
        Elevator elevator = new Elevator(0, 0);
        elevator.addtarget(5);
        elevator.step();
        elevator.addtarget(6);
        elevator.step();
        assertEquals(elevator.getTargetFloor(), 6);
    }

    @Test
    public void elevatorTargetFloorTest3() {
        Elevator elevator = new Elevator(0, 0);
        elevator.addtarget(5);
        elevator.addtarget(6);
        elevator.step();
        assertEquals(elevator.getTargetFloor(), 5);
    }

    @Test
    public void elevatorCurrentFloorTest1() {
        Elevator elevator = new Elevator(0, 0);
        elevator.addtarget(5);
        elevator.step();
        elevator.step();
        assertEquals(elevator.getCurrentFloor(), 5);
    }

    @Test
    public void elevatorCurrentFloorTest2() {
        Elevator elevator = new Elevator(0, 0);
        elevator.addtarget(5);
        elevator.addtarget(99);
        elevator.addtarget(8);
        elevator.step();
        elevator.step();
        elevator.step();
        assertEquals(elevator.getCurrentFloor(), 99);
    }


}
