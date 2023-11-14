package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Bicicleta;

public class BicicletaDao {
	private Connection conexao;
    public void inserir(Bicicleta bicicleta) throws SQLException {
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into t_sdb_bike (id_bike, nm_modelo, nm_marca," +
                "nr_serie, vl_atual) values(?,?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setInt(1, bicicleta.getId());
        comandoSql.setString(2, bicicleta.getModelo());
        comandoSql.setString(3, bicicleta.getMarca());
        comandoSql.setString(4, bicicleta.getNumeroSerie());
        comandoSql.setDouble(5, bicicleta.getValorMercado());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public void alterar(Bicicleta bicicleta) throws SQLException {
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "update t_sdb_bike set nm_modelo = ?, nm_marca = ?, " +
                "nr_serie = ?, vl_atual = ? where id_bike = ?";
        try{
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, bicicleta.getModelo());
            comandoSql.setString(2, bicicleta.getMarca());
            comandoSql.setString(3, bicicleta.getNumeroSerie());
            comandoSql.setDouble(4, bicicleta.getValorMercado());
            comandoSql.setInt(5, bicicleta.getId());
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) throws SQLException {
        conexao = GerenciadorBd.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "delete from t_sdb_bike where id_bike = ?";
        try {
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Bicicleta buscarPorId(int id) {
        Bicicleta bicicleta = new Bicicleta();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();
        try{
            String sql = "Select * from t_sdb_bike where id_bike = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                bicicleta.setId(rs.getInt(1));
                bicicleta.setMarca(rs.getString(3));
                bicicleta.setModelo(rs.getString(4));
                bicicleta.setNumeroSerie(rs.getString(6));
                bicicleta.setValorMercado(rs.getDouble(7));
                comandoSql.close();
                conexao.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bicicleta;
    }

    public Bicicleta buscarPorModelo(String modelo){
        Bicicleta bicicleta = new Bicicleta();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();
        try{
            String sql = "Select * from t_sdb_bike where nm_modelo = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, modelo);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                bicicleta.setId(rs.getInt(1));
                bicicleta.setModelo(rs.getString(3));
                bicicleta.setMarca(rs.getString(4));
                bicicleta.setNumeroSerie(rs.getString(6));
                bicicleta.setValorMercado(rs.getDouble(7));
                comandoSql.close();
                conexao.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bicicleta;
    }

    public List<Bicicleta> buscarBicicletas(){
        List<Bicicleta> bicicletas = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBd.obterConexao();

        try{
            String sql = "Select * from t_sdb_bike order by id_bike";
            comandoSql = conexao.prepareStatement(sql);
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()) {
                Bicicleta bicicleta = new Bicicleta();
                bicicleta.setId(rs.getInt(1));
                bicicleta.setModelo(rs.getString(3));
                bicicleta.setMarca(rs.getString(4));
                bicicleta.setNumeroSerie(rs.getString(6));
                bicicleta.setValorMercado(rs.getDouble(7));
                bicicletas.add(bicicleta);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bicicletas;
    }

}
