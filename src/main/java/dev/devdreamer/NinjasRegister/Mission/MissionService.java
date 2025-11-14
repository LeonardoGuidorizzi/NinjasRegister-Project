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

    public MissionDTO create(MissionDTO missionDTO){
        Mission mission = missionMapper.map(missionDTO);
        mission  = missionRepository.save(mission);
        return missionMapper.map(mission);
    }

    public List<MissionDTO> getAll (){
        List<Mission> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .toList();
    }

    public MissionDTO findById (Long id){
        Optional<Mission> mission = missionRepository.findById(id);
        return mission.map(missionMapper::map).orElseThrow(()-> new RuntimeException("Missao não encontrada"));
    }

    public void deleteById(Long id){
        missionRepository.deleteById(id);
    }
}
