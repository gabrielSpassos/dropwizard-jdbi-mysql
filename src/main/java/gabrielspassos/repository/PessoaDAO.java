package gabrielspassos.repository;

import gabrielspassos.mapper.PessoaMapper;
import gabrielspassos.model.PessoaModel;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(PessoaMapper.class)
public interface PessoaDAO {

    @SqlUpdate("insert into pessoas (id,nome) value (:id, :nome)")
    int inserir(@BindBean PessoaModel pessoaModel);

    @SqlQuery("select * from pessoas where id = :id")
    PessoaModel encontrarPessoaPeloId(@Bind("id") int id);

    @SqlQuery("select * from pessoas")
    List<PessoaModel> encontrarPessoa();

    @SqlUpdate("delete from pessoas where id = :id")
    int deletePorId(@Bind("id") int id);

    @SqlUpdate("update pessoas set nome = :nome where id = :id")
    int alterar(@BindBean PessoaModel pessoaModel);
}
