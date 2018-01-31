package c10;

import jdk.nashorn.api.tree.CaseTree;

import java.io.*;
import java.util.Hashtable;

class Counter {
    int i = 1;

    int read() {
        return i;
    }

    void increment() {
        i++;
    }
}

public class SortedWordCount {
    FileInputStream fileInputStream;
    StreamTokenizer streamTokenizer;
    Hashtable counts = new Hashtable();

    SortedWordCount(String filename) {
        try {
            fileInputStream = new FileInputStream(filename);
            Reader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            streamTokenizer = new StreamTokenizer(reader);
            streamTokenizer.ordinaryChar('.');
            streamTokenizer.ordinaryChar('-');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void cleanUp() {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void countWords() {
        try {
            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                String s;
                switch (streamTokenizer.ttype) {
                    case StreamTokenizer.TT_EOL:
                        s = new String("EOL");
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        s = Double.toString(streamTokenizer.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = streamTokenizer.sval; // Already a String
                        break;
                    default: // single character in ttype
                        s = String.valueOf((char) streamTokenizer.ttype);
                        break;
                }
                if (counts.contains(s)) {
                    ((Counter) counts.get(s)).increment();
                } else {
                    counts.put(s, new Counter());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


