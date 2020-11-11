package model;

public class ValidFormatFieldException extends Exception{
    private boolean err = false;
    public ValidFormatFieldException(boolean err) {
        this.err = err;
    }
    @Override
    public String getMessage() {
        if (this.err) return "Valor Invalido: Digite apenas numeros, não utilize virgula para ponto flutuante, use ponto!";
        else return "Codigo não encontrado - Valor invalido";
    }
}
