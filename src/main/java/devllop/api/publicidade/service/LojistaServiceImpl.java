package devllop.api.publicidade.service;

import devllop.api.publicidade.model.Lojista;
import devllop.api.publicidade.repository.LojistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojistaServiceImpl implements LojistaService{

    @Autowired
    private LojistaRepository repository;

    @Override
    public List<Lojista> listar() {
        return repository.findAll();
    }

    @Override
    public Lojista listarPorId(String id) {
        return repository.findOne(id);
    }

    @Override
    public Lojista cadastrar(Lojista lojista) {
        return repository.save(lojista);
    }

    @Override
    public Lojista atualizar(String id, Lojista lojista) {
        Lojista lojistaSalvo = repository.findOne(id);
        if (lojistaSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(lojista, lojistaSalvo, "id");
        return repository.save(lojistaSalvo);
    }

    @Override
    public void remover(String id) {
        this.repository.delete(id);
    }

}
