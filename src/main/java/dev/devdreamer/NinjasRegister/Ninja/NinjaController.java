package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public NinjaDTO create(@RequestBody NinjaDTO ninja){return ninjaService.create(ninja);}
    @GetMapping() //rota
    @ResponseStatus(HttpStatus.OK)
    public List<NinjaDTO> getAll(){
        return ninjaService.getAll();
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NinjaDTO partilUpdate(@PathVariable Long id, @RequestBody NinjaDTO ninja){return ninjaService.partialUpdate(id, ninja);}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NinjaDTO update(@PathVariable Long id, @RequestBody NinjaDTO ninja){return ninjaService.update(id, ninja);};
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByid(@PathVariable Long id) {ninjaService.deleteById(id);}
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NinjaDTO findById(@PathVariable Long id){return  ninjaService.findById(id);}//a variavel que eu passei no paramentro vai fazer parte da rota através do PathVariable

}
