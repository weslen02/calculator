package view;

import model.Calculator;
import model.ValidFormatFieldException;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculatorScreen {
    private JPanel panel1;
    private JTextField txtValue1;
    private JTextField txtValue2;
    private JTextArea txtAreaResult;
    private JButton btnPlus;
    private JButton btnSub;
    private JButton btnMult;
    private JButton btnDiv;
    private Calculator calc;

    public JPanel getPanel1() {
        return panel1;
    }

    public CalculatorScreen() {
        calc = new Calculator();
        txtValue1.setText("0");
        txtValue2.setText("0");

        btnPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (checkEmptyField()) {
                        calc.setVlr1(txtValue1.getText());
                        calc.setVlr2(txtValue2.getText());
                        calc.soma();
                        txtAreaResult.setText(Double.toString(calc.getResult()));
                    }
                } catch (NumberFormatException nbEx) {
                    ValidFormatFieldException vdFormatEx = new ValidFormatFieldException(true);
                    JOptionPane.showMessageDialog(new JFrame(), vdFormatEx.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error", "Atençao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (checkEmptyField()) {
                        calc.setVlr1(txtValue1.getText());
                        calc.setVlr2(txtValue2.getText());
                        calc.subtracao();
                        txtAreaResult.setText(Double.toString(calc.getResult()));
                    }
                } catch (NumberFormatException nbEx) {
                    ValidFormatFieldException vdFormatEx = new ValidFormatFieldException(true);
                    JOptionPane.showMessageDialog(new JFrame(), vdFormatEx.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error", "Atençao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnMult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (checkEmptyField()) {
                        calc.setVlr1(txtValue1.getText());
                        calc.setVlr2(txtValue2.getText());
                        calc.multiplicacao();
                        txtAreaResult.setText(Double.toString(calc.getResult()));
                    }
                } catch (NumberFormatException nbEx) {
                    ValidFormatFieldException vdFormatEx = new ValidFormatFieldException(true);
                    JOptionPane.showMessageDialog(new JFrame(), vdFormatEx.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error", "Atençao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDiv.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (checkEmptyField()) {
                        calc.setVlr1(txtValue1.getText());
                        calc.setVlr2(txtValue2.getText());
                        calc.divisao();
                        if (txtValue2.getText().equals("0")) {
                            try {
                                throw new Exception();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(new JFrame(), "Não pode dividir por zero",
                                "Erro", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            txtAreaResult.setText(Double.toString(calc.getResult()));
                        }
                    }
                } catch (NumberFormatException nbEx) {
                    ValidFormatFieldException vdFormatEx = new ValidFormatFieldException(true);
                    JOptionPane.showMessageDialog(new JFrame(), vdFormatEx.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error", "Atençao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    private boolean checkEmptyField() {
        try {
            txtValue1.setBackground(Color.white);
            txtValue2.setBackground(Color.white);
            if (txtValue1.getText().isEmpty() || txtValue2.getText().isEmpty()) {
                if (txtValue1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Digite o 1 valor",
                            "Atençao", JOptionPane.INFORMATION_MESSAGE);
                    txtValue1.setBackground(Color.pink);
                }
                if (txtValue2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Digite o 2 valor",
                            "Atençao", JOptionPane.INFORMATION_MESSAGE);
                    txtValue2.setBackground(Color.pink);
                }
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error", "Atençao", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
