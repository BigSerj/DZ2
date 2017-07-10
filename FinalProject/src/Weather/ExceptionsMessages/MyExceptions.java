package Weather.ExceptionsMessages;


import Weather.Constants;
import Weather.EnumMessage;


public class MyExceptions extends Exception{

    // переменная для кода ошибки
    private EnumMessage codeEx;
    private String codeExString;
    private Exception ex;


    // конструктор
    public MyExceptions(EnumMessage codeEx) {
        this.codeEx = codeEx;
    }
    public MyExceptions(String codeExString,Exception ex) {
        this.codeExString = codeExString;
        this.ex = ex;
    }


    // создаем метод со своими сообщениями об ошибках
    public void getRussianMessage(){
        switch (codeEx) {
            case ENTER_INTEGER:
                System.out.println("Введите целое число!");
                break;
            case STRING_TO_DATE_EXC:
                System.out.println("Ошибка при конвертации формата даты из String в Date.\n");
                break;
            default:
                System.out.println(MessagesControlCentre.sbMethod(codeEx));
        }
    }


    public void getRussianMessage(int j){
        System.out.println("Ошибка чтения поля данных \""+codeExString+"\" в элементе массива \""+
                Constants.WEATHER_TAG+"\" № "+(j+1)+". Ошибка: \""+ ex.toString()+"\"");
    }


}
