package gabrielspassos.resource;

import gabrielspassos.model.PessoaModel;
import gabrielspassos.repository.PessoaDAO;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/pessoas")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PessoaResource {

    PessoaDAO pessoaDAO;


    public PessoaResource(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    @POST
    public PessoaModel add(@Valid PessoaModel pessoaModel) {
        pessoaDAO.inserir(pessoaModel);

        return pessoaModel;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        pessoaDAO.deletePorId(id);
    }

    @GET
    @Path("/{id}")
    public PessoaModel pegar(@PathParam("id") Integer id){
        PessoaModel pessoaModel = pessoaDAO.encontrarPessoaPeloId(id);
        System.out.println("AQUI!!!!!!!!!!!!"+pessoaModel.getNome() + pessoaModel.getId()+"\n\n\n");
        return pessoaModel;
    }

    /*
    @PUT
    @PathParam("/{id}")
    public PessoaModel update(@PathParam("id") Integer id, @Valid PessoaModel pessoaModel){
        PessoaModel pessoaAlterada = new PessoaModel(id,pessoaModel.getNome());

        pessoaDAO.alterar(pessoaAlterada);

        return pessoaAlterada;
    }
    */
}
