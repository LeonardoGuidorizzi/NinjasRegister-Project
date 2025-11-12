package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //eu mapeio pra esse arquivo para ser um controller
@RequestMapping("api/ninja") // dizendo que esse arquivo é o mapa de todas as rotas
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping
    public NinjaDTO create(@RequestBody NinjaDTO ninja){return ninjaService.create(ninja);}
    @GetMapping() //rota
    public List<Ninja> getAll(){
        return ninjaService.getAll();
    }
    @PutMapping("{id}")
    public Ninja update(@PathVariable Long id, @RequestBody Ninja ninja){
        return ninjaService.update(id, ninja);
    }
    @DeleteMapping("/{id}")
    public void deleteByid(Long id) {ninjaService.deleteById(id);}
    @GetMapping("/{id}")
    public Ninja findById(@PathVariable Long id){return  ninjaService.findById(id);}//a variavel que eu passei no paramentro vai fazer parte da rota através do PathVariable

}
