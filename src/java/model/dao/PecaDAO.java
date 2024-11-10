/** **************************************************
 * @author Miguel Henrique dos Santos Correa        *
 * RGM: 11231101499                                 *
 * Turma: B                                         *
 * Período: 04                                      *
 ************************************************** */
package model.dao;

import model.Peca;
import util.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PecaDAO {
//----------------metodos------------------------------------------------------------------------------------------------------
    public boolean insPeca(Peca p_peca) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            String sql = "INSERT INTO peca (nome, descricao, quantidade) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p_peca.getNome());
            stmt.setString(2, p_peca.getDescricao());
            stmt.setInt(3, p_peca.getQuantidade());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;  
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        }
    }
    public void alterPeca(int p_id, String p_nome, String p_descricao, int p_quant) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            String sql = "UPDATE peca SET nome = ?, descricao = ?, quantidade = ? WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, p_nome);
            stmt.setString(2, p_descricao);
            stmt.setInt(3, p_quant);
            stmt.setInt(4, p_id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Peça atualizada com sucesso.");
            } else {
                System.out.println("Peça não encontrada.");
            }
        } catch (SQLException ex) {
            mensagemErroBanco();
            System.out.println(ex);
        }
    }
    public void dellPeca(int p_id) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            String sql = "DELETE FROM peca WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p_id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Peça deletada com sucesso.");
            } else {
                System.out.println("Peça não encontrada.");
            }
        } catch (SQLException ex) {
            mensagemErroBanco();
            System.out.println(ex);
        }
    }
    public Peca pesqPeca(int p_id) throws ClassNotFoundException {
        Connection conexao = null;
        Peca peca = null;
        try {
            conexao = ConectaDB.conectar();
            String sql = "SELECT * FROM peca WHERE id = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, p_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                peca = new Peca();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getInt("quantidade"));
            } else {
                System.out.println("Peça não encontrada.");
            }
        } catch (SQLException ex) {
            mensagemErroBanco();
            System.out.println(ex);
        }
        return peca;
    }
    public List<Peca> pesqPecaAll() throws ClassNotFoundException {
        Connection conexao = null;
        List<Peca> pecas = new ArrayList<>();
        try {
            conexao = ConectaDB.conectar();
            String sql = "SELECT * FROM peca";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Peca peca = new Peca();
                peca.setId(rs.getInt("id"));
                peca.setNome(rs.getString("nome"));
                peca.setDescricao(rs.getString("descricao"));
                peca.setQuantidade(rs.getInt("quantidade"));
                pecas.add(peca);
            }
            if (pecas.isEmpty()) {
                System.out.println("Nenhuma peça encontrada.");
            }
        } catch (SQLException ex) {
            mensagemErroBanco();
            System.out.println(ex);
        }
        return pecas;
    }
//----------------metodos genericos--------------------------------------------------------------------------------------------
    public void mensagemErroBanco(){
        System.out.println("Erro de Acesso ao Banco de Dados!!!");
    }
    public void usuarioNaoEncontrado(){
        System.out.println("Usuário não encontrado");
    }
}
