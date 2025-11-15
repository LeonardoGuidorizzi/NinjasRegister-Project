package dev.devdreamer.NinjasRegister.Mission.mapper;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import dev.devdreamer.NinjasRegister.Mission.dto.MissionDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public Mission map(MissionDTO missionDTO){
        var mission = new Mission();
        mission.setId(missionDTO.getId());
        mission.setName(missionDTO.getName());
        mission.setLevel(missionDTO.getLevel());
        return mission;
    }
    public MissionDTO map(Mission mission){
        var missionDTO = new MissionDTO();
        missionDTO.setId(mission.getId());
        missionDTO.setName(mission.getName());
        missionDTO.setLevel(mission.getLevel());
        return missionDTO;
    }

    public void updateEntityFromDTO(MissionDTO dto, Mission entity){
        if(dto.getName() != null)entity.setName(dto.getName());
        if(dto.getLevel() != null)entity.setLevel(dto.getLevel());
    }

}
