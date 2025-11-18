package acme.prueba.api.dto;

public class PedidoDTO {

    private String numPedido;
    private int cantidadPedido;
    private String codeEAN;
    private String nombreProducto;
    private String numDocument;
    private String direction;


    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public String getCodeEAN() {
        return codeEAN;
    }

    public void setCodeEAN(String codeEAN) {
        this.codeEAN = codeEAN;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }


}
