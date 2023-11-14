package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.entity.Endereco;

public class EnderecoBo {
	
	private EnderecoDao enderecoDao;
	
	public void cadastrar(Endereco endereco) {
	    enderecoDao = new EnderecoDao();
	    try {
			enderecoDao.inserir(endereco);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Endereco> buscarEnderecos() {
		enderecoDao = new EnderecoDao();
		return enderecoDao.buscarEnderecos();
	}



}
