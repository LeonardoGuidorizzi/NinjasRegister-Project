package dev.devdreamer.NinjasRegister.Ninja;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //eu mapeio pra esse arquivo para ser um controller
@RequestMapping("api/ninja") // dizendo que esse arquivo é o mapa de todas as rotas
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping()
    public String create(){
        return "createNinja";
    }

    @GetMapping("/getAll") //rota
    public List<Ninja> getAll(){
        return ninjaService.getAll();
    }

    @PutMapping
    public String update(){
        return "updateNinja";
    }
    @DeleteMapping
    public String delete() {
        return "deleteNinja";
    }
    @GetMapping("{id}")
    public Ninja findById(@PathVariable Long id){
        return  ninjaService.findById(id);
    }//a variavel que eu passei no paramentro vai fazer parte da rota através do PathVariable
}
