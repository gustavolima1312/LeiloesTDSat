package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
import beans.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexao.conectaDAO;
import java.sql.SQLException;

public class ProdutosDAO {

    private conectaDAO conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new conectaDAO();
        this.conn = this.conexao.connectDB();
    }

    public void Salvar(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                + "(?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, "A Venda");
            stmt.execute();
            javax.swing.JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            // Esse catch vai pegar especificamente o erro de digitação de números
            JOptionPane.showMessageDialog(null, "No campo Valor, digite apenas números inteiros.");
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produtos"; // Certifique-se que o nome da tabela está correto
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        try {
            conn = new conectaDAO().connectDB(); // Usando sua classe de conexão
            PreparedStatement prep = conn.prepareStatement(sql);
            ResultSet resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));

                listagem.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return listagem;
    }

}
