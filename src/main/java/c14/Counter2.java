package c14;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Counter2 extends Applet {
    private int count = 0;
    private Button onOff = new Button("Toggle"), onStart = new Button("Start");
    private TextField textField = new TextField(10);
    private boolean runFLag = true;

    public void init() {
        add(textField);
        onStart.addActionListener(new Counter2.StartL());
        add(onStart);
        onOff.addActionListener(new Counter2.OnOffL());
        add(onOff);

    }


    class StartL implements ActionListener {
        NewThread myNewThread = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (myNewThread == null) {
                myNewThread = new NewThread();
                myNewThread.start();
            }
        }
    }

    class OnOffL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            runFLag = !runFLag;
        }
    }

    class NewThread extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                }
                if (runFLag) {
                    textField.setText(Integer.toString(count++));
                }
            }
        }
    }

    public static void main(String[] args) {
        Counter2 applet = new Counter2();
        Frame aframe = new Frame("Counter2");
        aframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        aframe.add(applet, BorderLayout.CENTER);
        aframe.setSize(300, 200);
        applet.init();
        applet.start();
        aframe.setVisible(true);
    }
}
