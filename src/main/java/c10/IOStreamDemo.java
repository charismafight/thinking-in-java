package c10;

import java.io.*;

//typical IO stream configurations
public class IOStreamDemo {
    public static void main(String[] args) {
        try {
            // 1. buffered input file
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("test"));
//            String s, s2 = new String();
//            while ((s = bufferedReader.readLine()) != null) {
//                s2 += s + "\n";
//            }
//            bufferedReader.close();

            String s2 = "ttt";
            // 2. input from memory
            StringReader stringReader = new StringReader(s2);
            int c;
            while ((c = stringReader.read()) != -1) {
                System.out.println((char) c);
            }
            // 3. formatted memory input
            File file = new File("test");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("test"), "UTF-8"));

            PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("test")));
            printStream.println("testetstset");
            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
