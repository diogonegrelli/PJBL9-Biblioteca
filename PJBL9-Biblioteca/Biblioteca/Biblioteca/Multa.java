package Biblioteca;

public class Multa extends Exception {
    private float valorMulta;

    public Multa(String message, float valorMulta) {
        super(message);
        this.valorMulta = valorMulta;
    }

    public float getValorMulta() {
        return valorMulta;
    }

    
}
