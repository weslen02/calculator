package model;

public class Calculator {
    private String vlr1;
    private String vlr2;
    private double result;

    private String getVlr1() {
        return vlr1;
    }

    public void setVlr1(String vlr1) {
        this.vlr1 = vlr1;
    }

    private String getVlr2() {
        return vlr2;
    }

    public void setVlr2(String vlr2) {
        this.vlr2 = vlr2;
    }

    public double getResult() {
        return result;
    }

    private void setResult(double result) {
        this.result = result;
    }

    public void soma() {
        setResult( (Double.parseDouble(getVlr1())) + (Double.parseDouble((getVlr2()))) );
    }

    public void subtracao() {
        setResult( (Double.parseDouble(getVlr1())) - (Double.parseDouble((getVlr2()))) );
    }

    public void multiplicacao() {
        setResult( (Double.parseDouble(getVlr1())) * (Double.parseDouble((getVlr2()))) );
    }

    public void divisao() {
        setResult( (Double.parseDouble(getVlr1())) / (Double.parseDouble((getVlr2()))) );
    }
}
