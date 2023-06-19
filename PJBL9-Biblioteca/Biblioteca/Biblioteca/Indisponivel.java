package Biblioteca;

public class Indisponivel extends Exception {
    public Indisponivel() {
        super("Notebooks não estão disponíveis para empréstimos, apenas para uso na biblioteca");
    }
}