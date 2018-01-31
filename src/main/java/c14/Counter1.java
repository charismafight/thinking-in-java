package c14;

import org.ietf.jgss.Oid;

import javax.swing.border.Border;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Counter1 extends Applet {
    private int count = 0;
    private Button onOff = new Button("Toggle"), onStart = new Button("Start");
    private TextField textField = new TextField(10);
    private boolean runFLag = true;

    public void init() {
        add(textField);
        onStart.addActionListener(new StartL());
        add(onStart);
        onOff.addActionListener(new OnOffL());
        add(onOff);

    }

    public void go() {
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

    class StartL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            go();
        }
    }

    class OnOffL implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            runFLag = !runFLag;
        }
    }

    public static void main(String[] args) {
        Counter1 applet = new Counter1();
        Frame aframe = new Frame("Counter1");
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

