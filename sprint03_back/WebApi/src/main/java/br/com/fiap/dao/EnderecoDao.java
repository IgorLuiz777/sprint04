package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Endereco;

public class EnderecoDao {
	private Connection conexao;

    public void inserir(Endereco endereco) throws SQLException {
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into t_sdb_endereco_usuario (id_endereco_usuario, nm_logadouro," +
                "nr_logadouro, nr_cep, sigla_estado, nm_cidade, nm_bairro) values (?,?,?,?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, endereco.getId());
        comandoSql.setString(2, endereco.getLogradouro());
        comandoSql.setString(3, endereco.getNumero());
        comandoSql.setString(4, endereco.getCep());
        comandoSql.setString(5, endereco.getEstado());
        comandoSql.setString(6, endereco.getCidade());
        comandoSql.setString(7, endereco.getBairro());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public void alterar(Endereco endereco) throws SQLException {
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "update t_sdb_endereco_usuario set nm_logadouro = ?," +
              "nr_cep = ?, sigla_estado = ?, nm_cidade = ?, nm_bairro = ?, nr_logadouro = ? where id_endereco_usuario = ?";
        try{
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, endereco.getLogradouro());
            comandoSql.setString(2, endereco.getCep());
            comandoSql.setString(3, endereco.getEstado());
            comandoSql.setString(4, endereco.getCidade());
            comandoSql.setString(5, endereco.getBairro());
            comandoSql.setString(6, endereco.getNumero());
            comandoSql.setInt(7, endereco.getId());
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id){
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "delete from t_sdb_endereco_usuario where id_endereco_usuario = ?";
        try{
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Endereco buscarPorId(int id) throws SQLException {
        Endereco end = new Endereco();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();
        try{
            String sql = "Select * from t_sdb_endereco_usuario where id_endereco_usuario = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                end.setId(rs.getInt(1));
                end.setLogradouro(rs.getString(2));
                end.setNumero(rs.getString(3));
                end.setCep(rs.getString(5));
                end.setEstado(rs.getString(6));
                end.setCidade(rs.getString(7));
                end.setBairro(rs.getString(8));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return end;
    }

    public List<Endereco> buscarPorCep(String cep) {
        List<Endereco> ends = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();
        try{
            String sql = "Select * from t_sdb_endereco_usuario where nr_cep = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1,cep);
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Endereco end = new Endereco();
                end.setId(rs.getInt(1));
                end.setLogradouro(rs.getString(2));
                end.setNumero(rs.getString(3));
                end.setCep(rs.getString(5));
                end.setEstado(rs.getString(6));
                end.setCidade(rs.getString(7));
                end.setBairro(rs.getString(8));
                ends.add(end);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ends;
    }
    public List<Endereco> buscarEnderecos() {
        List<Endereco> ends = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();
        try {
            String sql = "Select * from t_sdb_endereco_usuario order by id_endereco_usuario";
            comandoSql = conexao.prepareStatement(sql);
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Endereco end = new Endereco();
                end.setId(rs.getInt(1));
                end.setLogradouro(rs.getString(2));
                end.setNumero(rs.getString(3));
                end.setCep(rs.getString(5));
                end.setEstado(rs.getString(6));
                end.setCidade(rs.getString(7));
                end.setBairro(rs.getString(8));
                ends.add(end);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ends;
    }
}
