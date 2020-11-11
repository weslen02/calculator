package com.java.maromo.fatecmm;

import view.CalculatorScreen;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new CalculatorScreen().getPanel1());
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Deseja realmente fechar?",
                    "Sair da aplicacao",
                    JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });


    }
}
