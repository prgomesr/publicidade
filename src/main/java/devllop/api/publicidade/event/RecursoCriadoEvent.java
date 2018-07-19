package devllop.api.publicidade.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private String codigo;

    public RecursoCriadoEvent(Object source, HttpServletResponse response, String codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public String getCodigo() {
        return codigo;
    }
}
