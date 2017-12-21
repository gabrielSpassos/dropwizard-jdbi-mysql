package gabrielspassos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class PessoaModel {

    @NotNull
    @JsonProperty
    private int id;

    @NotNull
    @JsonProperty
    private String nome;

    public PessoaModel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PessoaModel() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
