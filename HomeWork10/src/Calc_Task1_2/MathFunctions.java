package Calc_Task1_2;

import java.util.Scanner;

public class MathFunctions extends MyExceptions{

    public MathFunctions(int codeEx) {
        super(codeEx);
    }

    public static StringBuilder switchMethodFunc(int a, int b, int c){
        StringBuilder sb = new StringBuilder();
        try {
            switch (c) {
                case 1:
                    try {
                        return sb.append(a).append("+").append(b).append("=").append(a + b);
                    }catch (Exception e) {
                        throw new MyExceptions(11);
                    }
                case 2:
                    try {
                        return sb.append(a).append("-").append(b).append("=").append(a - b);
                    }catch (Exception e){
                        throw new MyExceptions(12);
                    }
                case 3:
                    try {
                        return sb.append(a).append("*").append(b).append("=").append(a * b);
                    }catch (Exception e){
                        throw new MyExceptions(13);
                    }
                case 4:
                    try {
                        return sb.append(a).append("/").append(b).append("=").append(a / b);
                    }catch (Exception e){
                        throw new MyExceptions(14);
                    }
            }
        }catch (MyExceptions ex){
            ex.getRussianMessage();
        }
        return sb;
    }



    public static int inMethodScanner(int inX) {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.next();

            try {
                int i;
                try {
                    i = Integer.parseInt(s);
                }catch (Exception e){
                    throw new MyExceptions(1);
                }
                if ((i<1||i>4) && inX==3)
                    throw new MyExceptions(2);
                return i;
            } catch (MyExceptions e) {
                e.getRussianMessage();
            }
        }
    }
}