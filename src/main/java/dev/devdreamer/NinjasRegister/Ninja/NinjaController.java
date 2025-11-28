package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaCreateDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaPatchDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaResponseDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja")
    public NinjaResponseDTO create(@Valid @RequestBody NinjaCreateDTO ninja){return ninjaService.create(ninja);}
    @GetMapping() //rota
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todos os ninjas", description = "Essa rota lista todos os ninjas do banco")
    public List<NinjaResponseDTO> getAll(){
        return ninjaService.getAll();
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza um ninja existente", description = "Essa rota atuliza campos especificos de um ninja")
    public NinjaResponseDTO partialUpdate(@PathVariable Long id, @RequestBody NinjaPatchDTO ninja){return ninjaService.partialUpdate(id, ninja);}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza um ninja existente", description = "Essa rota atualiza o ninja por inteiro")
    public NinjaResponseDTO update(@PathVariable Long id, @RequestBody NinjaUpdateDTO ninja){return ninjaService.update(id, ninja);};
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta o ninja por id", description = "Essa rota deleta um ninja")
    public void deleteByid(@PathVariable Long id) {ninjaService.deleteById(id);}
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista o ninja por id", description = "Essa rota lista um ninja especifico")
    public NinjaResponseDTO findById(@PathVariable Long id){return  ninjaService.findById(id);}//a variavel que eu passei no paramentro vai fazer parte da rota através do PathVariable

}
