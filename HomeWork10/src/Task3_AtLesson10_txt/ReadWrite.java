package Task3_AtLesson10_txt;

import java.io.*;

public class ReadWrite {

    // читаем файл:
    public static void read(String fileName, Doctor[] d) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        exists(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                int i=0;
                while ((s = in.readLine()) != null) {

                    String[] arrayS = s.split("\\|");

                    d[i].setName(arrayS[0]);
                    d[i].setAge(Integer.valueOf(arrayS[1]));
                    d[i].setUchastkoviy(Boolean.valueOf(arrayS[2]));
                    i++;
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}