package acme.prueba.api.controller;

import acme.prueba.api.dto.RespuestaJsonDTO;
import acme.prueba.api.service.TransformadorService;
import acme.prueba.api.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private TransformadorService transformadorService;

    @PostMapping
    public ResponseEntity<String> recibirPedido(@RequestBody PedidoDTO pedidoDTO) {
        try {
            String xml = transformadorService.transformarJsonAXml(pedidoDTO);
            return ResponseEntity.ok(xml);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al transformar JSON a XML");
        }
    }

    @PostMapping(value = "/xml-json", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaJsonDTO> convertirXmlAJson(@RequestBody String xml) {
        try {
            RespuestaJsonDTO json = transformadorService.transformarXmlAJson(xml);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
