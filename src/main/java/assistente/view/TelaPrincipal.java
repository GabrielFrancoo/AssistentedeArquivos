package assistente.view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Assistente de Arquivos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botaoEscolherPasta = new JButton("Escolher pasta");
        JLabel textoPasta = new JLabel("Nenhuma pasta selecionada");

        JPanel painel = new JPanel();
        painel.add(botaoEscolherPasta);
        painel.add(textoPasta);

        DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nome do arquivo"}, 0);
        JTable tabela = new JTable(modelo);

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        botaoEscolherPasta.addActionListener(evento -> {
            JFileChooser seletor = new JFileChooser();
            seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int resultado = seletor.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                String caminho = seletor.getSelectedFile().getAbsolutePath();
                textoPasta.setText(caminho);
                modelo.setRowCount(0);

                File[] itens = seletor.getSelectedFile().listFiles();

                if (itens != null) {
                    for (File item : itens) {
                        if (item.isFile()) {
                            modelo.addRow(new Object[]{item.getName()});
                        }
                    }
                }
            }
        });
    }
}