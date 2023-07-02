import java.util.concurrent.atomic.AtomicInteger;

public class Toy {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);                    
    private final String name;                
    private final int id;
    private int value;               
    private double periode;            


    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", periode=" + periode +
                '}';
    }

    public Toy(String name, int value, double periode) {
        this.id = COUNTER.getAndIncrement();
        this.name = name;
        this.value = value;
        this.periode = periode;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getValue() {
        return value;
    }


    public double getPeriode() {
        return periode;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public void setPeriode(double periode) {
        this.periode = periode;
    }
    
}