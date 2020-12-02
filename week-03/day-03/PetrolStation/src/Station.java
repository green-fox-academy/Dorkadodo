public class Station {
    int gasAmount = 1000000;

    public Station(){}
    public Station (int initialGasAmount) {
        this.gasAmount=initialGasAmount;
    }

    public void refill(Car car) {
        gasAmount = gasAmount - (car.capacity - car.gasAmount);
        car.gasAmount=car.capacity;
    }
}
