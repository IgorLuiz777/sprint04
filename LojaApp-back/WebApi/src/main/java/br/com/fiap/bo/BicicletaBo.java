package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.BicicletaDao;
import br.com.fiap.entity.Bicicleta;

public class BicicletaBo {
	
private BicicletaDao bicicletaDao;
	
	public void cadastrar(Bicicleta bicicleta) throws SQLException {
		bicicletaDao = new BicicletaDao();
		bicicletaDao.inserir(bicicleta);
	}
	
	public List<Bicicleta> buscarBicicletas(){
		bicicletaDao = new BicicletaDao();
		return bicicletaDao.buscarBicicletas();
	}

}
