package UI;

import javax.swing.*;

public class Home extends Interface {
    @Override
    public JPanel mostrar(){
        JPanel panel1 = new JPanel();
        JButton buttonItens = new JButton("Consulta Itens");
        JButton buttonEmprestimos = new JButton("Novo Empréstimo");
        JButton buttonDevolucao = new JButton("Devolução");

        return panel1;
    }
}
