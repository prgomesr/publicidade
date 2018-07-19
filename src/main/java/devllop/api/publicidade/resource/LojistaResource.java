package devllop.api.publicidade.resource;

import devllop.api.publicidade.event.RecursoCriadoEvent;
import devllop.api.publicidade.model.Lojista;
import devllop.api.publicidade.repository.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("lojistas")
public class LojistaResource {

    @Autowired
    private LojistaRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Lojista> listar(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lojista> criar(@Valid @RequestBody Lojista lojista, HttpServletResponse response ) {
        Lojista lojistaSalvo = repository.save(lojista);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, lojistaSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lojistaSalvo);
    }
}
