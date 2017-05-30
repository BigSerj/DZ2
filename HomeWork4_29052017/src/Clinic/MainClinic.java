package Clinic;


import java.util.Scanner;

public class MainClinic {
    public static void main(String[] args) {

        System.out.print("Введите количество новых пациентов: ");
        Patient[] patientArray = new Patient[scannerInInt()];

        for (int i=0;i<patientArray.length;i++){
            patientArray[i] = new Patient();
            StringBuilder builder = new StringBuilder();
            System.out.println(builder.append("Заполните анкету пациента №").append(i+1).append(": ").toString());

            int sequence = 1;//счетчик номера сеттера по порядку (для корректной нумерации)
            patientArray[i].setNamePatient(sequence++,i);
            patientArray[i].setAge(sequence++,i);
            patientArray[i].setHealthGroup(sequence++,i);
            patientArray[i].setIsNowSick(sequence++,i);
            patientArray[i].setDistrictDoctorName(sequence,i);
        }
        System.out.printf("%nПациент “ФИО” - Возраст = “возраст”:%n");
        //вывод на экран в виде:      Пациент “ФИО” - Возраст = “возраст”
        for (Patient i : patientArray) {
            System.out.println(soutBuilder(i));
        }

        //поиск:
        System.out.printf("%nПоиск по ФИО, либо, по возрасту пациента (введите ФИО, либо, возраст искомого пациента): ");
        while (true) {//update задания, чтобы удобнее было проверять поиск (все-равно поиск - последнее задание в задаче).
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {//если ввели int - ищем по возрасту
                int wantedAge = in.nextInt();
                for (Patient i : patientArray) {
                    if (i.getAge() == wantedAge)
                        System.out.println(soutBuilder(i));
                }
            } else{//иначе - по ФИО
                String wantedName = in.nextLine();
                for (Patient i : patientArray) {
                    if (i.getName().equals(wantedName))
                        System.out.println(soutBuilder(i));
                }
            }
        }




    }



    static String scannerInString(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }
    static int scannerInInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    static boolean scannerInBoolean(){
        Scanner in = new Scanner(System.in);
        return in.nextBoolean();
    }
    private static String soutBuilder(Patient patientX){
        StringBuilder builder = new StringBuilder();
        return builder.append("Пациент “").append(patientX.getName()).append("” - Возраст = ”").append(patientX.getAge()).append("”").toString();
    }


}