package Students_Task2;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Main {

    public static void main(String[] args) throws ParseException {

        System.out.println("Введите кол-во студентов в списке: ");
        Student[] arrayOfStudents = new Student[new Scanner(System.in).nextInt()];

        for (int i = 0; i < arrayOfStudents.length; i++)
            arrayOfStudents[i] = new Student();

        for (int i = 0; i < arrayOfStudents.length; i++) {
            StringBuilder sb = new StringBuilder();

            System.out.println(sb.append("Студент №").append(i + 1).append(":\nВведите имя Студента: "));
            //arrayOfStudents[i].setName(new Scanner(System.in).next());

            System.out.println("Введите фамилию Студента: ");
            //arrayOfStudents[i].setSecondName(new Scanner(System.in).next());

            System.out.println("Введите дату рождения Студента (пример: 17:32:43,23.02.1988): ");
            arrayOfStudents[i].setDateOfBirth(new SimpleDateFormat("HH:mm:ss,dd.MM.yyyy").parse(new Scanner(System.in).next()));
        }


        System.out.println("Средний возраст всех студентов: ");

        int sumMonths = 0;

        int xYears = 0;
        int xMonths = 0;
        int xDays = 0;
        int xHours = 0;
        int xMinutes = 0;
        int xSeconds = 0;
        for (Student arrayOfStudent : arrayOfStudents) {
            Calendar calendarThis = Calendar.getInstance();
            calendarThis.setTime(arrayOfStudent.getDateOfBirth());
            int hourThis = calendarThis.get(Calendar.HOUR);
            int minThis = calendarThis.get(Calendar.MINUTE);
            int secThis = calendarThis.get(Calendar.SECOND);
            int yearThis = calendarThis.get(Calendar.YEAR);
            int monthThis = calendarThis.get(Calendar.MONTH) + 1;
            int dateThis = calendarThis.get(Calendar.DATE);

            Calendar calendarNow = Calendar.getInstance();
            calendarNow.setTime(new GregorianCalendar().getTime());
            int hour = calendarNow.get(Calendar.HOUR);
            int min = calendarNow.get(Calendar.MINUTE);
            int sec = calendarNow.get(Calendar.SECOND);
            int year = calendarNow.get(Calendar.YEAR);
            int month = calendarNow.get(Calendar.MONTH) + 1;
            int date = calendarNow.get(Calendar.DATE);

            //легкое задание:
            sumMonths += (year - yearThis - 1) * 12 + 12 - monthThis + month;

            //сложное задание:
            xYears += year - yearThis - 1;
            if (month >= monthThis)
                xYears++;
            xMonths += month - monthThis - 1;
            if (date >= dateThis) {
                xMonths++;
                xDays += date - dateThis;
            } else xDays += date + switchDays(month, year) - dateThis;

            if (hour >= hourThis)
                xHours += hour - hourThis;
            else
                xHours += hour + 24 - hourThis;

            if (min >= minThis)
                xMinutes += min - minThis;
            else
                xMinutes += min + 60 - minThis;

            if (sec >= secThis)
                xSeconds += sec - secThis;
            else
                xSeconds += sec + 60 - secThis;

        }

        //легкое задание:
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(sumMonths / arrayOfStudents.length / 12).append(" лет ").append(sumMonths / arrayOfStudents.length % 12).append(" месяцев"));

        //сложное задание:
        sb.delete(0, sb.length());
        sb.append(xYears/arrayOfStudents.length).append(" лет ").append(xMonths/arrayOfStudents.length).append(" месяцев ").append(xDays/arrayOfStudents.length).append(" дней ").append(xHours/arrayOfStudents.length).append(" часов ").append(xMinutes/arrayOfStudents.length).append(" минут ").append(xSeconds/arrayOfStudents.length).append(" секунд.");
        System.out.println(sb.toString());
    }


    private static int switchDays(int month,int year){
        switch (month){
            case 2:
                if ((year%4==0 && year%100!=0) || year%400==0)
                    return 29;
                else
                    return 28;
            case 1:case 3:case 5:case 7:case 8:case 10:case 12: return 31;
            default: return 30;
        }
    }

}

/*
06:32:00,27.02.1988
00:20:00,09.06.2017
 */

