package model;

import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void adicionar(Funcionario f) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, email, cargo, salario) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getNome());
            ps.setString(2, f.getEmail());
            ps.setString(3, f.getCargo());
            ps.setDouble(4, f.getSalario());
            ps.executeUpdate();
        }
    }

    public List<Funcionario> listarTodos() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection con = Conexao.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(rs.getDouble("salario"));
                lista.add(f);
            }
        }
        return lista;
    }

    public void removerPorId(int id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void atualizar(Funcionario f) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, email = ?, cargo = ?, salario = ? WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getNome());
            ps.setString(2, f.getEmail());
            ps.setString(3, f.getCargo());
            ps.setDouble(4, f.getSalario());
            ps.setInt(5, f.getId());
            ps.executeUpdate();
        }
    }

}
