package Bankomat_HomeWork7OnLesson8;

public class Ui implements OnBankomatListener{

    public void startUi(){

        Bankomat bankomat = new Bankomat();
        bankomat.setUi(new OnBankomatListener() {   // АНОНИМНЫЙ КЛАСС (потому что никто не знает его имени). Нужен для того, чтобы конкретно при вызове этой ф-ии сработал именно этот код
            @Override
            public void onGetMoney(int money) {
                System.out.println("fvesbsb");
            }

            @Override
            public void onSetMoney(boolean isOk) {
                System.out.println("ffjsoughreghre");
            }
        });
        bankomat.setUi(this);// отправляем именно ЭТОТ объект "Ui" в банкомат, теперь мы можем вызывать в банкомате методы ЭТОГО класса


        // имитация снятия денег
        bankomat.getMoney(70);





        // имитация получения денег
        bankomat.setMoney(100);




    }


    @Override
    public void onGetMoney(int money){
        if (money >0)
            System.out.println("Деньги получены");
        else
            System.out.println("Ошибка");
    }

    @Override
    public void onSetMoney(boolean isOk){
        if (isOk)
            System.out.println("Ok");
        else
            System.out.println("Ошибка");
    }
}
