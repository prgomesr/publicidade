package devllop.api.publicidade.resource;

import devllop.api.publicidade.event.RecursoCriadoEvent;
import devllop.api.publicidade.model.Lojista;
import devllop.api.publicidade.service.LojistaService;
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
@CrossOrigin("http://localhost:8100")
public class LojistaResource {

    @Autowired
    private LojistaService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Lojista> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lojista> buscarPorId(@PathVariable String id) {
        Lojista lojista = service.listarPorId(id);
        return lojista != null ? ResponseEntity.ok(lojista) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Lojista> criar(@Valid @RequestBody Lojista lojista, HttpServletResponse response ) {
        Lojista lojistaSalvo = service.cadastrar(lojista);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, lojistaSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lojistaSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lojista> atualizar(@PathVariable String id, @Valid @RequestBody Lojista lojista) {
        Lojista lojistaSalvo = service.atualizar(id, lojista);
        return ResponseEntity.ok(lojistaSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String id) {
        service.remover(id);
    }
}
