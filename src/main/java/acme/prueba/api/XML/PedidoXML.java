package acme.prueba.api.XML;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pedido")
@XmlAccessorType(XmlAccessType.FIELD)
public class PedidoXML {

    @XmlElement(name = "pedido")
    private String pedido;

    @XmlElement(name = "Cantidad")
    private int cantidad;

    @XmlElement(name = "EAN")
    private String ean;

    @XmlElement(name = "Producto")
    private String producto;

    @XmlElement(name = "Cedula")
    private String cedula;

    @XmlElement(name = "Direccion")
    private String direccion;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
