package Biblioteca;

public class Usuario {
    int IdUsuario;
    String NomeAluno;

    public Usuario(int IdUsuario, String NomeAluno) {
        this.IdUsuario = IdUsuario;
        this.NomeAluno = NomeAluno;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNomeAluno() {
        return NomeAluno;
    }
}
