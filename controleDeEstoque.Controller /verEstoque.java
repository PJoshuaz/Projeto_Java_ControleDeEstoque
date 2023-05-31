package controleDeEstoque.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verEstoque extends JFrame {
    private final JTextArea AreaDeTextoVerEstoque;

    public verEstoque() {
        // Configurações da janela existente
        setTitle("visualizarEstoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Componentes existentes na tela
        JPanel panel = new JPanel(new BorderLayout());
        // ...
        // Adicione aqui os componentes existentes na sua tela

        // Adiciona o painel à janela existente
        add(panel);

        // Cria um novo JTextArea para exibir os dados do estoque
        AreaDeTextoVerEstoque = new JTextArea();
        AreaDeTextoVerEstoque.setEditable(false);
        panel.add(new JScrollPane(AreaDeTextoVerEstoque), BorderLayout.CENTER);

        // Botão "Visualizar Estoque"
        JButton visualizarEstoque = new JButton("Visualizar Estoque");
        visualizarEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirEstoque();
            }
        });
        panel.add(visualizarEstoque, BorderLayout.SOUTH);

        // Exibe a janela existente
        setVisible(true);
    }

    private void exibirEstoque() {
        // Conectar ao banco de dados e recuperar os dados do estoque

        // Código para recuperar os dados do estoque

        // Exibir os dados do estoque no JTextArea
        AreaDeTextoVerEstoque.setText("");
        // Código para exibir os dados do estoque no JTextArea
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new verEstoque());
    }
}
