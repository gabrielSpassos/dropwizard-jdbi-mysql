package gabrielspassos.resource;

import com.google.inject.Inject;
import gabrielspassos.model.PessoaModel;
import gabrielspassos.repository.PessoaDAO;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/pessoas")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PessoaResource {

    PessoaDAO pessoaDAO;

    @Inject
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
        return pessoaModel;
    }

    @GET
    public List<PessoaModel> pegarTodas(){
        return pessoaDAO.encontrarPessoa();
    }

}
