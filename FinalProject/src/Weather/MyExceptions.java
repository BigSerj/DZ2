package Weather;

public class MyExceptions extends Exception{

    // переменная для кода ошибки
    private int codeEx;

    // конструктор
    public MyExceptions(int codeEx) {
        this.codeEx = codeEx;
    }

    // геттер
    public int getCodeEx() {
        return codeEx;
    }

    // создаем метод со своими сообщениями об ошибках
    public void getRussianMessage(){
        if (codeEx==1)
            System.out.println("Введите целое число!");
        else if (codeEx==2)
            System.out.println(LoopedMessages.sbMethod(codeEx).toString());
    }

}
