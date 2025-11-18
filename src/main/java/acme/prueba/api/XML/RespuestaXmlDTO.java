package acme.prueba.api.XML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "respuestaSOAP")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespuestaXmlDTO {

    @XmlElement(name = "Codigo")
    private String codigo;

    @XmlElement(name = "Mensaje")
    private String mensaje;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
