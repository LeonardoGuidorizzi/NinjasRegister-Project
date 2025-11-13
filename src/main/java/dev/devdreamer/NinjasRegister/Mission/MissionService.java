package dev.devdreamer.NinjasRegister.Mission;

import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MissionService {
    MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Mission findById (Long id){
        Optional<Mission> mission = missionRepository.findById(id);
        if(mission.isPresent()){
            return mission.get();
        }else{
            throw new RuntimeException("Missão não encontrada");
        }
    }
}
