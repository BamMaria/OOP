package polimorphism;

public class Bicycle extends Cycle {
    @Override
    public void ride(Direction key) {
        System.out.println("Bicycle.ride " + key);
        System.out.println("Bicycle has " + wheels() + " wheels");
    }

    @Override
    public int wheels() {
        return 2;
    }
}