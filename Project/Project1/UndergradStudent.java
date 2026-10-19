package Project1;

public class UndergradStudent extends Student {

    public UndergradStudent(String name, int id, double mark) {
        super(name, id, mark);
    }

    public double getPassingPercentage() {
        return 60;
    }

    public String getType() {
        return "Undergraduate";
    }
}
