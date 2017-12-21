package gabrielspassos;

import gabrielspassos.model.PessoaModel;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import gabrielspassos.repository.PessoaDAO;
import gabrielspassos.resource.PessoaResource;

public class DataBaseApplication extends Application<DataBaseConfig> {

    public static void main(String[] args) throws Exception{
        new DataBaseApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<DataBaseConfig> bootstrap) {
    }

    @Override
    public void run(DataBaseConfig configuration, Environment environment) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabase(), "mysql");

        final PessoaDAO pessoaDAO = jdbi.onDemand(PessoaDAO.class);
        final PessoaResource pessoaResource = new PessoaResource(pessoaDAO);

        environment.jersey().register(pessoaResource);

    }
}
