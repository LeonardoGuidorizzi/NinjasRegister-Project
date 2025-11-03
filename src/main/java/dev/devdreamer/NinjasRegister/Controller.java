package dev.devdreamer.NinjasRegister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //eu mapeio pra esse arquivo para ser um controller
@RequestMapping // dizendo que esse arquivo é o mapa de todas as rotas
public class Controller {
    @GetMapping("/helloWorld")
    public String helloWord(){
        return "Hello World";
    }
}
