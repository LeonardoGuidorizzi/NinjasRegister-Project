package dev.devdreamer.NinjasRegister.Ninja;

import org.springframework.web.bind.annotation.*;

@RestController //eu mapeio pra esse arquivo para ser um controller
@RequestMapping // dizendo que esse arquivo é o mapa de todas as rotas
public class NinjaController {


    @PostMapping()
    public String create(){
        return "createNinja";
    }

    @GetMapping("/helloWorld") //rota
    public String helloWord(){
        return "Hello World";
    }

    @PutMapping
    public String update(){
        return "updateNinja";
    }
    @DeleteMapping
    public String deleteById() {
        return "deleteNinja";
    }
    @GetMapping()
    public String allById(){
        return  "allById";
    }
}
