package gabrielspassos.model.bind;

import gabrielspassos.model.PessoaModel;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@BindingAnnotation(PessoaBind.PessoaBinder.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface PessoaBind {

    class PessoaBinder implements BinderFactory<PessoaBind> {
        @Override
        public Binder build(PessoaBind annotation) {
            return (Binder<PessoaBind, PessoaModel>) (q, bind, arg) -> {
                q.bind("id", arg.getId())
                        .bind("nome", arg.getNome());
            };
        }
    }

}
