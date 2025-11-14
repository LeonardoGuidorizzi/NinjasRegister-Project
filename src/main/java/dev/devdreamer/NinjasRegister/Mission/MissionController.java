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

    @PutMapping
    public String update(){
        return "updateNinja";
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id ) {
        missionService.deleteById(id);
    }

}
