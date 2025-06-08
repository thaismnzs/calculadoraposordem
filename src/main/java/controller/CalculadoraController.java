package controller;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import service.CalculadoraPosOrdem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*")
public class CalculadoraController {

    @PostMapping("/calcular")
    public ResponseEntity<String> calcular(@RequestBody Map<String, String> request) {
        String expressao = request.get("expressao");
        System.out.println("Expressão recebida: " + expressao);
        try {
            double resultado = CalculadoraPosOrdem.calcularExpressao(expressao);
            return ResponseEntity.ok(String.valueOf(resultado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
    }
}

