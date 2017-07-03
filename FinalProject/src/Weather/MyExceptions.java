package Weather;

public class MyExceptions extends Exception{

    // переменная для кода ошибки
    private int codeEx;
    private String codeExString;
    private Exception ex;


    // конструктор
    public MyExceptions(int codeEx) {
        this.codeEx = codeEx;
    }
    public MyExceptions(String codeExString,Exception ex) {
        this.codeExString = codeExString;
        this.ex = ex;
    }


    // геттеры
    public int getCodeEx() {
        return codeEx;
    }
    public String getCodeExString() {
        return codeExString;
    }

    // создаем метод со своими сообщениями об ошибках
    public void getRussianMessage(){
        switch (codeEx) {
            case 1:
                System.out.println("Введите целое число!");
                break;
            case 2:
                System.out.println(LoopedMessages.sbMethod(codeEx).toString());
                break;
        }
    }


    public void getRussianMessage(int j){
        System.out.println("Ошибка чтения поля данных \""+codeExString+"\" в элементе массива \""+
                Constants.WEATHER_TAG+"\" № "+(j+1)+". Ошибка: \""+ ex.toString()+"\"");
    }


}
