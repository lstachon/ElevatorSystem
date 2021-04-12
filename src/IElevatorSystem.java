import java.util.List;

public interface IElevatorSystem {

    void pickup(int from, int to);

    void update(int elevatorID, int currentFloor, int targetFloor);

    void step();

    List<ElevatorValues> status();

    void addNewElevator();

    void printElevatorStatuses();

}
