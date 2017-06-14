package Task3_AtLesson10_txt;

public class Doctor extends People{

    private int room;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public boolean isUchastkoviy() {
        return isUchastkoviy;
    }

    public void setUchastkoviy(boolean uchastkoviy) {
        isUchastkoviy = uchastkoviy;
    }

    private String name;
    private int age;
    private boolean isUchastkoviy;

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public void myTest() {
        System.out.println("Doctor My Test");
    }
}
