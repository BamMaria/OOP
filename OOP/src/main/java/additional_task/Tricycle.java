package additional_task;

public class Tricycle extends Cycle {
    @Override
    public void ride(Direction key) {
        System.out.println("Tricycle.ride " + key);
        System.out.println("Tricycle has " + wheels() + " wheels");
    }

    @Override
    public int wheels() {
        return 3;
    }
}