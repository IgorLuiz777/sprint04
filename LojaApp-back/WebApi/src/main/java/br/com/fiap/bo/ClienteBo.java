package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.EnderecoDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;

public class ClienteBo {
	
	private ClienteDao clienteDao;
	
	
	public void cadastrar(Cliente cliente) throws SQLException {
		clienteDao = new ClienteDao();
		clienteDao.inserir(cliente);
	}
	
	public Cliente buscarPorId(int id) throws SQLException {
		clienteDao = new ClienteDao();
		return clienteDao.buscarPorId(id);
	}
	
}
