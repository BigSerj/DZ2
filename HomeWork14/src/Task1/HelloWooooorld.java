package Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HelloWooooorld {

    public static void main(String[] args) {

        Pattern p = Pattern.compile("(?=(.))\\1{2,}");
        Matcher m = p.matcher("helloWoooorld annndd hooooo aarre youu???");

        StringBuffer sb = new StringBuffer();


        while (m.find()) {

            Pattern p2 = Pattern.compile("[A-z]{1}");
            Matcher m2 = p2.matcher(m.group());

            if (m2.find())
                m.appendReplacement(sb, m2.group() + m.group().length());

        }


        System.out.println(sb.toString());
    }

}
