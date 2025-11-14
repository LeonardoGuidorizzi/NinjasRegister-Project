package dev.devdreamer.NinjasRegister.Mission;

import dev.devdreamer.NinjasRegister.Mission.dto.MissionDTO;
import dev.devdreamer.NinjasRegister.Mission.mapper.MissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MissionService {
    MissionRepository missionRepository;
    MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public MissionDTO findById (Long id){
        Optional<Mission> mission = missionRepository.findById(id);
        return mission.map(missionMapper::map).orElseThrow(()-> new RuntimeException("Missão não encontrada"));
    }
    public List<MissionDTO> getAll(){
         List<Mission> missions = missionRepository.findAll();
         return missions.stream().map(missionMapper::map).toList();
    }
}
