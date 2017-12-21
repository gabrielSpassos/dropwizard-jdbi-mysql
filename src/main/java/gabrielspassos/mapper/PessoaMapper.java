package gabrielspassos.mapper;

import gabrielspassos.model.PessoaModel;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaMapper implements ResultSetMapper<PessoaModel>{
    @Override
    public PessoaModel map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new PessoaModel(resultSet.getInt("id"),resultSet.getString("nome"));
    }
}
