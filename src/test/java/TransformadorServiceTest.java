import acme.prueba.api.PruebaApplication;
import acme.prueba.api.dto.PedidoDTO;
import acme.prueba.api.dto.RespuestaJsonDTO;
import acme.prueba.api.service.TransformadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = PruebaApplication.class)
public class TransformadorServiceTest {

    @Autowired
    private TransformadorService transformador;

    @Test
    void transformaJsonAXmlCorrectamente() throws Exception {
        PedidoDTO pedido = new PedidoDTO();
        pedido.setNumPedido("75630275");
        pedido.setCantidadPedido(1);
        pedido.setCodeEAN("00110000765191002104587");
        pedido.setNombreProducto("Armario INVAL");
        pedido.setNumDocument("1113987400");
        pedido.setDirection("CR 72B 45 12 APT 301");

        String xml = transformador.transformarJsonAXml(pedido);

        assertTrue(xml.contains("<Cantidad>1</Cantidad>"));
        assertTrue(xml.contains("<Producto>Armario INVAL</Producto>"));
    }

    @Test
    void transformaXmlAJson_correctamente() throws Exception {
        String xml = """
            <respuestaSOAP>
              <Codigo>80375472</Codigo>
              <Mensaje>Entregado exitosamente al cliente</Mensaje>
            </respuestaSOAP>
            """;

        RespuestaJsonDTO json = transformador.transformarXmlAJson(xml);

        assertEquals("80375472", json.getCodigoEnvio());
        assertEquals("Entregado exitosamente al cliente", json.getEstado());
    }
}
