package dev.devdreamer.NinjasRegister.Ninja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //eu mapeio pra esse arquivo para ser um controller
@RequestMapping // dizendo que esse arquivo é o mapa de todas as rotas
public class NinjaController {
    @GetMapping("/helloWorld") //rota
    public String helloWord(){
        return "Hello World";
    }
}
