package Streams;

public class MyExceptions extends Exception{

    // переменная для кода ошибки
    private String codeExString;
    private Exception ex;


    // конструктор
    public MyExceptions(String codeExString, Exception ex) {
        this.codeExString = codeExString;
        this.ex = ex;
    }


    // геттеры
    public String getCodeExString() {
        return codeExString;
    }


    public void getRussianMessage(int j){
        System.out.println("Ошибка чтения поля данных \""+codeExString+"\" в элементе массива \""+Constants.WEATHER_TAG+
                "\" № "+(j+1)+". Ошибка: \""+ ex.toString()+"\"");
    }


}
