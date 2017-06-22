package AtLessonRegularReplace;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularEmails {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String numb = in.next();

        Pattern p = Pattern.compile("^\\+375((17)|(29)|(33)|(44))\\d{7}$");
        Matcher m = p.matcher(numb);

        if (m.matches()) {
            System.out.println("номер верный");
        } else {
            System.out.println("номер неверный");
        }


        String text2 = "fhjrilailaerig text@thtext.com ghrjeghle text@text.cohtr gbreg gebr texhtt@tehxt.com fdew";
        text2 = text2.replaceAll("\\w+@\\w+\\.\\w+","");
        System.out.println("text = "+ text2);


    }

}
