package acme.prueba.api.service;
import acme.prueba.api.XML.RespuestaXmlDTO;
import acme.prueba.api.dto.PedidoDTO;
import acme.prueba.api.XML.PedidoXML;
import acme.prueba.api.dto.RespuestaJsonDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.io.StringWriter;

@Service
public class TransformadorService {

    public String transformarJsonAXml(PedidoDTO jsonDTO) throws JAXBException {
        PedidoXML xmlDTO = new PedidoXML();
        xmlDTO.setPedido(jsonDTO.getNumPedido());
        xmlDTO.setCantidad(jsonDTO.getCantidadPedido());
        xmlDTO.setEan(jsonDTO.getCodeEAN());
        xmlDTO.setProducto(jsonDTO.getNombreProducto());
        xmlDTO.setCedula(jsonDTO.getNumDocument());
        xmlDTO.setDireccion(jsonDTO.getDirection());

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(PedidoXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(xmlDTO, writer);

        return writer.toString();
    }

    public RespuestaJsonDTO transformarXmlAJson(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(RespuestaXmlDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        RespuestaXmlDTO xmlDTO = (RespuestaXmlDTO) unmarshaller.unmarshal(reader);

        RespuestaJsonDTO jsonDTO = new RespuestaJsonDTO();
        jsonDTO.setCodigoEnvio(xmlDTO.getCodigo());
        jsonDTO.setEstado(xmlDTO.getMensaje());

        return jsonDTO;
    }

}
