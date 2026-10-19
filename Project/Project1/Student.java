package Project1;

public abstract class Student implements Passable {
    private String name;
    private int id;
    private double mark;

    public Student(String name, int id, double mark) {
        this.name = name;
        this.id = id;
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
            this.mark = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public double getMark() {
        return mark;
    }

    public boolean setMark(double mark) {
        if (mark < 0 || mark > 100) {
            return false;
        }
        this.mark = mark;
        return true;
    }

    public abstract String getType();

    public boolean isPassed() {
        return mark >= getPassingPercentage();
    }

    public String toString() {
        String result = isPassed() ? "Passed" : "Failed";
        return "ID: " + id + " | Name: " + name + " | Type: " + getType()
                + " | Mark: " + mark + " | Required: " + getPassingPercentage()
                + "% | Result: " + result;
    }
}
