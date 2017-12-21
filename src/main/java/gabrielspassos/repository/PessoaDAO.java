package gabrielspassos.repository;

import gabrielspassos.model.PessoaModel;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface PessoaDAO {

    @SqlUpdate("insert into pessoas(id,nome) values (:id, :nome)")
    int inserir(@BindBean PessoaModel pessoaModel);

    @SqlQuery("select * from pessoas where id = :id")
    PessoaModel encontrarPessoaPeloId(@Bind("id") int id);
}
