package additional_task;
public class Unicycle extends Cycle {
    @Override
    public void ride(Direction key) {
        System.out.println("Unicycle.ride " + key);
        System.out.println("Unicycle has " + wheels() + " wheel");
    }

    @Override
    public int wheels() {
        return 1;
    }
}