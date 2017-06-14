package Task3_AtLesson10_txt;

public abstract class People {


    public abstract void myTest();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;


    // если делаем переопределение - обязательно помечать словом "@Override"  !!!!!   Это ускорит работу проги
    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}
