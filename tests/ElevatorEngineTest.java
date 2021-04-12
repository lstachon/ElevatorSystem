import org.junit.Test;

import static org.junit.Assert.*;

public class ElevatorEngineTest {

    @Test
    public void pickUpTest1() {
        ElevatorEngine elevators = new ElevatorEngine();
        elevators.addNewElevator();
        elevators.pickup(0,10);
        elevators.step();
        elevators.pickup(3,4);
        assertEquals(elevators.elevators.get(0).getTargetFloor(),3);
    }

    @Test
    public void pickUpTest2() {
        ElevatorEngine elevators = new ElevatorEngine();
        elevators.addNewElevator();
        elevators.addNewElevator();
        elevators.pickup(5,10);
        elevators.step();
        elevators.pickup(3,4);
        assertEquals(elevators.elevators.get(0).getTargetFloor(),3);
    }

    @Test
    public void pickUpTest3() {
        ElevatorEngine elevators = new ElevatorEngine();
        elevators.addNewElevator();
        elevators.addNewElevator();
        elevators.pickup(5,10);
        elevators.step();
        elevators.step();
        elevators.pickup(3,4);
        assertEquals(elevators.elevators.get(0).getTargetFloor(),10);
    }

    @Test
    public void maxElevatorsNumber() {
        ElevatorEngine elevators = new ElevatorEngine();
        for(int i =0; i < 20; i++){
            elevators.addNewElevator();
        }
        assertEquals(elevators.elevators.size(),16);
    }

    @Test
    public void updateTest() {
        ElevatorEngine elevators = new ElevatorEngine();
        elevators.addNewElevator();
        elevators.addNewElevator();
        elevators.pickup(5,10);
        elevators.step();
        elevators.step();
        elevators.update(0,9,12);
        assertEquals(elevators.elevators.get(0).getCurrentFloor(),9);
    }


}
