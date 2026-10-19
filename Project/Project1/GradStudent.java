package Project1;

public class GradStudent extends Student {

    public GradStudent(String name, int id, double mark) {
        super(name, id, mark);
    }

    public double getPassingPercentage() {
        return 80;
    }

    public String getType() {
        return "Graduate";
    }
}
