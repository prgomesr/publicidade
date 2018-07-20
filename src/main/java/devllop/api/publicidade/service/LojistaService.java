package devllop.api.publicidade.service;

import devllop.api.publicidade.model.Lojista;

import java.util.List;

public interface LojistaService {

    List<Lojista> listar();
    Lojista listarPorId(String id);
    Lojista cadastrar(Lojista lojista);
    Lojista atualizar(String id, Lojista lojista);
    void remover(String id);

}
