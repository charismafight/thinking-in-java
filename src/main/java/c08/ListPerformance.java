package c08;

import org.ietf.jgss.Oid;

import java.util.Iterator;
import java.util.List;

public class ListPerformance {
    private static final int REPS = 100;

    private abstract static class Tester {
        String name;
        int size;

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] tests = {
            new Tester("get", 300) {
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < a.size(); j++) {
                            a.get(j);
                        }
                    }
                }
            },
            new Tester("iteration", 300) {
                @Override
                void test(List a) {
                    for (int i = 0; i < 300; i++) {
                        Iterator iter = a.iterator();
                        while (iter.hasNext()) {
                            iter.next();
                        }
                    }
                }
            }
    };
}
