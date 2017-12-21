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

    @GET
    @Path("/{id}")
    public PessoaModel get(@PathParam("id") int id){
        return pessoaDAO.encontrarPessoaPeloId(id);
    }

    @POST
    public PessoaModel add(@Valid PessoaModel pessoaModel) {
        pessoaDAO.inserir(pessoaModel);

        return pessoaModel;
    }
}
