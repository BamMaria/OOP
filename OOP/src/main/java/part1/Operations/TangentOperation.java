package part1.Operations;
public class TangentOperation extends Operation {
    @Override
    double apply(double number) {
        return Math.tan(number);
    }
}
