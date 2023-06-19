package Biblioteca;

import java.util.ArrayList;

public class Usuario {
    private int IdUsuario;
    private String NomeAluno;
    private ArrayList<Emprestimo> emprestimosUsuario;



    public Usuario(int IdUsuario, String NomeAluno, ArrayList<Emprestimo>emprestimosUsuario) {
        this.IdUsuario = IdUsuario;
        this.NomeAluno = NomeAluno;
        this.emprestimosUsuario = emprestimosUsuario;

    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNomeAluno() {
        return NomeAluno;
    }
}
