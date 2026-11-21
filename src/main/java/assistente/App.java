package assistente;

import javax.swing.SwingUtilities;

import assistente.view.TelaPrincipal;

public class App {
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
    });
    }
}