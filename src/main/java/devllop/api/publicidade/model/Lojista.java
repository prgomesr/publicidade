package devllop.api.publicidade.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "lojistas")
public class Lojista {

    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private List<Produto> produtos;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
