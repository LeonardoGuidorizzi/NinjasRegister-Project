package dev.devdreamer.NinjasRegister.Mission;


import dev.devdreamer.NinjasRegister.Mission.dto.MissionDTO;
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
    public MissionDTO create(@RequestBody MissionDTO missionDTO){
        return missionService.create(missionDTO);
    }

    @GetMapping() //rota
    public List<MissionDTO> getAll(){
        return missionService.getAll();
    }

    @PutMapping("/{id}")
    public MissionDTO update( @PathVariable Long id, @RequestBody MissionDTO missionDTO){
        return missionService.update(missionDTO, id);
    }

    @PatchMapping("/{id}")
    public MissionDTO partialUpdate(@PathVariable Long id, @RequestBody MissionDTO missionDTO){
        return missionService.partialUpdate(missionDTO, id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id ) {
        missionService.deleteById(id);
    }

}
