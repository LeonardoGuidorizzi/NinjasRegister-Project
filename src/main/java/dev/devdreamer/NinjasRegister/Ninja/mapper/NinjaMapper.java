package dev.devdreamer.NinjasRegister.Ninja.mapper;

import dev.devdreamer.NinjasRegister.Ninja.Ninja;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public Ninja map (NinjaDTO ninjaDTO) {
        Ninja ninja = new Ninja();
        ninja.setId(ninjaDTO.getId());
        ninja.setName(ninjaDTO.getName());
        ninja.setAge(ninjaDTO.getAge());
        ninja.setRank(ninjaDTO.getRank());
        ninja.setEmail(ninjaDTO.getEmail());
        ninja.setImgUrl(ninjaDTO.getImgUrl());
        ninja.setMission(ninjaDTO.getMission());
        return ninja;
    }

    public NinjaDTO map (Ninja ninja){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninja.getId());
        ninjaDTO.setName(ninja.getName());
        ninjaDTO.setAge(ninja.getAge());
        ninjaDTO.setRank(ninja.getRank());
        ninjaDTO.setEmail(ninja.getEmail());
        ninjaDTO.setImgUrl(ninja.getImgUrl());
        ninjaDTO.setMission(ninja.getMission());
        return ninjaDTO;
    }
}
