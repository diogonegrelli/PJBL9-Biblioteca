package UI;

import javax.swing.*;

public abstract class Interface {

    private static final JFrame mainWindow = new JFrame("Gerenciamento da Biblioteca");
    private JPanel panel1 ;

    public static void iniciaSystem(JPanel panel1){
        mainWindow.add(panel1);
        mainWindow.setSize(500, 300);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void changeScreen(JPanel panel1){
        mainWindow.getContentPane().removeAll();
        mainWindow.getContentPane().add(panel1);
        mainWindow.revalidate();
        mainWindow.repaint();

    }
    public abstract JPanel mostrar();
}
