package br.com.fiap.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ClienteBo;
import br.com.fiap.entity.Cliente;

@Path("/clientes")
public class ClienteResource {
	
	private ClienteBo clienteBo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente, @Context UriInfo uriInfo) throws SQLException {
	    clienteBo = new ClienteBo();
	    clienteBo.cadastrar(cliente);
	    UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	    builder.path(Integer.toString(cliente.getId()));
	    return Response.created(builder.build()).build();
	}

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(@PathParam("id") int id) throws SQLException {
		clienteBo = new ClienteBo();
		return clienteBo.buscarPorId(id);
		
	}

}
