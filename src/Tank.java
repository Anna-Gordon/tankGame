public class Tank {
    private final String TANK_MODEL = "T34"; // константа
    private static int tankCount; // статичное поле

    private int y; // vertical
    private int x; // horizontal
    private int direction = 1;
    private int fuel;
    private int count;

    // constructors
    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int y, int x) {
        this(y, x, 100);
    }

    public Tank(int y, int x, int fuel) {
        this.y = y;
        this.x = x;
        this.fuel = fuel;
        count = ++tankCount;
    }


    protected void goForward(int step) {

        if (step > fuel) step = fuel;
        else if (step < 0 && -step > -fuel) {
            step = -fuel;
        }

        if (direction == 0) x -= step;
        else if (direction == 1) y += step;
        else if (direction == 2) x += step;
        else y -= step;

        fuel -= step;
    }

    protected void printPosition() {
        System.out.printf("The Tank %s-%d is at %d, %d now.\n", TANK_MODEL, count, y, x);
    }

    protected void goBackward(int step) {
        goForward(-step);
    }

    public void turnRight() {
        direction++;
        if (direction == 4) direction = 0;
    }

    public void turnLeft() {
        direction--;
        if (direction == -1) direction = 3;
    }
}
