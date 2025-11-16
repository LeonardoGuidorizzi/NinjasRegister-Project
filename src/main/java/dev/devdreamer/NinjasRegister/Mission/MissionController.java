package dev.devdreamer.NinjasRegister.Mission;


import dev.devdreamer.NinjasRegister.Mission.dto.MissionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mission")
public class MissionController {
    private MissionService missionService;

    public MissionController(MissionService missionService ){
        this.missionService = missionService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public MissionDTO create(@RequestBody MissionDTO missionDTO){
        return missionService.create(missionDTO);
    }

    @GetMapping() //rota
    @ResponseStatus(HttpStatus.OK)
    public List<MissionDTO> getAll(){
        return missionService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MissionDTO update( @PathVariable Long id, @RequestBody MissionDTO missionDTO){
        return missionService.update(missionDTO, id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MissionDTO partialUpdate(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        return missionService.partialUpdate(missionDTO, id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id ) {
        missionService.deleteById(id);
    }

}
