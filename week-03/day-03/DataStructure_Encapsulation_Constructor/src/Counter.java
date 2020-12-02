public class Counter {
    int counter;
    int initial = 0;

    public Counter () {}
    public Counter (int start) {
        counter = start;
        initial = start;
    }

    public void add (int number) {
        counter = counter + number;
    }

    public void add () {
        counter++;
    }

    public int get () {
        return counter;
    }

    public void reset () {
        counter = initial;
    }
}
