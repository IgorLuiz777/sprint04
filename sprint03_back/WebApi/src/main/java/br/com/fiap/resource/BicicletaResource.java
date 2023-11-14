package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.BicicletaBo;
import br.com.fiap.bo.EnderecoBo;
import br.com.fiap.entity.Bicicleta;
import br.com.fiap.entity.Endereco;

@Path("/bicicletas")
public class BicicletaResource {
	
private BicicletaBo bicicletaBo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bicicleta bicicleta, @Context UriInfo uriInfo) throws SQLException {
		bicicletaBo = new BicicletaBo();
		bicicletaBo.cadastrar(bicicleta);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(bicicleta.getId()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicicleta> listarBicicletas(){
		bicicletaBo = new BicicletaBo();
		return bicicletaBo.buscarBicicletas();
	}

}
