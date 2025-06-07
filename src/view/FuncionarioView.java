package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FuncionarioView extends JFrame {
    private JTextField txtNome, txtEmail, txtCargo, txtSalario;
    private JButton btnSalvar, btnRemover, btnEditar;
    private JTable tabelaFuncionarios;
    private DefaultTableModel modeloTabela;

    public FuncionarioView() {
        super("Cadastro de Funcionário");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Formulário
        JPanel painelForm = new JPanel(new GridLayout(5, 2, 10, 10));
        painelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelForm.add(txtNome);

        painelForm.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        painelForm.add(txtEmail);

        painelForm.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        painelForm.add(txtCargo);

        painelForm.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        painelForm.add(txtSalario);

        btnSalvar = new JButton("Salvar");
        painelForm.add(btnSalvar);

        btnRemover = new JButton("Remover selecionado");
        painelForm.add(btnRemover);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnEditar = new JButton("Editar selecionado");
        painelBotoes.add(btnEditar);

        add(painelBotoes, BorderLayout.SOUTH);


        // Tabela
        modeloTabela = new DefaultTableModel(new String[]{"ID", "Nome", "Email", "Cargo", "Salário"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false; // tabela somente leitura
            }
        };
        tabelaFuncionarios = new JTable(modeloTabela);
        JScrollPane scroll = new JScrollPane(tabelaFuncionarios);

        // Layout da janela
        setLayout(new BorderLayout());
        add(painelForm, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JTextField getTxtNome() { return txtNome; }
    public JTextField getTxtEmail() { return txtEmail; }
    public JTextField getTxtCargo() { return txtCargo; }
    public JTextField getTxtSalario() { return txtSalario; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnRemover() { return btnRemover; }
    public JTable getTabelaFuncionarios() { return tabelaFuncionarios; }
    public DefaultTableModel getModeloTabela() { return modeloTabela; }
    public JButton getBtnEditar() { return btnEditar; }


    public void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
    }
}
