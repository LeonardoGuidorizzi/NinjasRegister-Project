package dev.devdreamer.NinjasRegister.Mission;

import org.springframework.web.bind.annotation.*;

@RequestMapping("api/mission")
public class MissionController {

    @PostMapping()
    public String create(){
        return "createNinja";
    }

    @GetMapping() //rota
    public String getAll(){
        return "All missions";
    }

    @PutMapping
    public String update(){
        return "updateNinja";
    }
    @DeleteMapping
    public String deleteById() {
        return "deleteNinja";
    }

}
