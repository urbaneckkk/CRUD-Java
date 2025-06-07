package controller;

import model.Funcionario;
import model.FuncionarioDAO;
import view.FuncionarioView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    private FuncionarioView view;
    private FuncionarioDAO dao;

    public FuncionarioController(FuncionarioView view, FuncionarioDAO dao) {
        this.view = view;
        this.dao = dao;
        carregarFuncionarios();

        view.getBtnSalvar().addActionListener(e -> salvarFuncionario());
        view.getBtnRemover().addActionListener(e -> removerFuncionarioSelecionado());
        view.getBtnEditar().addActionListener(e -> editarFuncionarioSelecionado());
    }

    private void salvarFuncionario() {
        try {
            String nome = view.getTxtNome().getText();
            String email = view.getTxtEmail().getText();
            String cargo = view.getTxtCargo().getText();
            double salario = Double.parseDouble(view.getTxtSalario().getText());

            if (nome.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nome e Email são obrigatórios.");
                return;
            }

            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setEmail(email);
            f.setCargo(cargo);
            f.setSalario(salario);

            dao.adicionar(f);
            JOptionPane.showMessageDialog(view, "Funcionário salvo com sucesso!");
            view.limparCampos();
            carregarFuncionarios();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Salário inválido.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao salvar funcionário: " + ex.getMessage());
        }
    }

    private void carregarFuncionarios() {
        try {
            List<Funcionario> lista = dao.listarTodos();
            DefaultTableModel modelo = view.getModeloTabela();
            modelo.setRowCount(0);

            for (Funcionario f : lista) {
                modelo.addRow(new Object[]{
                        f.getId(),
                        f.getNome(),
                        f.getEmail(),
                        f.getCargo(),
                        f.getSalario()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar funcionários: " + ex.getMessage());
        }
    }

    private void removerFuncionarioSelecionado() {
        int linhaSelecionada = view.getTabelaFuncionarios().getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Selecione um funcionário para remover.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view,
                "Confirma a remoção do funcionário selecionado?",
                "Confirmar remoção",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = (int) view.getModeloTabela().getValueAt(linhaSelecionada, 0);
                dao.removerPorId(id);
                JOptionPane.showMessageDialog(view, "Funcionário removido com sucesso.");
                carregarFuncionarios();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Erro ao remover funcionário: " + ex.getMessage());
            }
        }
    }

    private void editarFuncionarioSelecionado() {
        int linhaSelecionada = view.getTabelaFuncionarios().getSelectedRow();
        if (linhaSelecionada >= 0) {
            try {
                // Pegando dados atuais da tabela
                int id = (int) view.getTabelaFuncionarios().getValueAt(linhaSelecionada, 0);
                String nomeAtual = (String) view.getTabelaFuncionarios().getValueAt(linhaSelecionada, 1);
                String emailAtual = (String) view.getTabelaFuncionarios().getValueAt(linhaSelecionada, 2);
                String cargoAtual = (String) view.getTabelaFuncionarios().getValueAt(linhaSelecionada, 3);
                double salarioAtual = (double) view.getTabelaFuncionarios().getValueAt(linhaSelecionada, 4);

                // Diálogos de edição
                String novoNome = JOptionPane.showInputDialog(view, "Novo nome:", nomeAtual);
                String novoEmail = JOptionPane.showInputDialog(view, "Novo email:", emailAtual);
                String novoCargo = JOptionPane.showInputDialog(view, "Novo cargo:", cargoAtual);
                String novoSalarioStr = JOptionPane.showInputDialog(view, "Novo salário:", String.valueOf(salarioAtual));

                if (novoNome == null || novoNome.isEmpty() || novoEmail == null || novoEmail.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nome e Email são obrigatórios.");
                    return;
                }

                double novoSalario = Double.parseDouble(novoSalarioStr);

                Funcionario f = new Funcionario();
                f.setId(id);
                f.setNome(novoNome);
                f.setEmail(novoEmail);
                f.setCargo(novoCargo);
                f.setSalario(novoSalario);

                dao.atualizar(f);
                JOptionPane.showMessageDialog(view, "Funcionário atualizado com sucesso!");
                carregarFuncionarios();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Salário inválido.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(view, "Erro ao atualizar funcionário: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione um funcionário para editar.");
        }
    }


}
