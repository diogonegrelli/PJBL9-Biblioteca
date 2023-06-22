package Biblioteca;

public class Indisponivel extends Exception {
    public Indisponivel() {
        super("Pesquisas não estão disponíveis para empréstimos, apenas para uso na biblioteca");
    }
}