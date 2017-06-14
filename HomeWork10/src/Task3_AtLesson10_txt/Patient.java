package Task3_AtLesson10_txt;

public class Patient extends People {



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int id;
    private int color;

    @Override
    public void myTest() {
        System.out.println("Pacient My Test");
    }

}
