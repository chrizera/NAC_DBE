package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.FuncionarioBO;
import br.com.fiap.entity.Funcionario;

@Path("/funcionario")
public class FuncionarioResource {

	private FuncionarioBO bo = new FuncionarioBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Funcionario funcionario, @Context UriInfo uriInfo) {
		try {
			bo.cadastrar(funcionario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		UriBuilder uri = UriBuilder.fromPath(uriInfo.getPath());
		uri.path(String.valueOf(funcionario.getCodigo()));
		return Response.created(uri.build()).build();
	}
	
	@GET
	@Path("/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Funcionario buscar(@PathParam("codigo") int codigo) {
		return bo.buscar(codigo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listar() {
		return bo.listar();
	}
	
	@PUT
	@Path("/{codigo}")
	public Response atualizar(Funcionario funcionario, @PathParam("codigo") int codigo) {
		try {
			funcionario.setCodigo(codigo);
			bo.atualizar(funcionario);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{codigo}")
	public void remover(@PathParam("codigo") int codigo) {
		try {
			bo.remover(codigo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
