package dev.devdreamer.NinjasRegister.Mission;


import dev.devdreamer.NinjasRegister.Mission.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mission")
public class MissionController {
    private MissionService missionService;

    public MissionController(MissionService missionService){
        this.missionService = missionService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um nova missão", description = "Essa rota cria um nova missão")
    public MissionResponseDTO create(@RequestBody MissionCreateDTO missionDTO){
        return  missionService.create(missionDTO);
    }

    @GetMapping() //rota
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista todas as missões", description = "Essa rota lista todas as missões do banco")
    public List<MissionResponseDTO> getAll(){
        return missionService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza uma missão existente", description = "Essa rota atualiza a missão por inteiro")
    public MissionResponseDTO update( @PathVariable Long id, @RequestBody MissionUpdateDTO missionDTO){
        return missionService.update(missionDTO, id);
    }
    @Operation(summary = "Atualiza uma missão existente", description = "Essa rota atuliza campos especificos de uma missão")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MissionResponseDTO partialUpdate(@PathVariable Long id, @RequestBody MissionPatchDTO missionDTO){
        return missionService.partialUpdate(missionDTO, id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta a missão por id", description = "Essa rota deleta uma missão")
    public void deleteById(@PathVariable Long id ) {
        missionService.deleteById(id);
    }

}
