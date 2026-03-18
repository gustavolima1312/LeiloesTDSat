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
                
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
                System.out.println("Erro ao inserir produto: " + e.getMessage());
            }
        }
        
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

