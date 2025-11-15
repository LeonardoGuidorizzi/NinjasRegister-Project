package dev.devdreamer.NinjasRegister.Mission;

import dev.devdreamer.NinjasRegister.Mission.dto.MissionDTO;
import dev.devdreamer.NinjasRegister.Mission.mapper.MissionMapper;
import dev.devdreamer.NinjasRegister.Ninja.mapper.NinjaMapper;
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
        return mission.map(missionMapper::map)
                .orElseThrow(()-> new RuntimeException("Missao não encontrada"));
    }

    public MissionDTO update(MissionDTO missionDTO, Long id){
        Mission foundMission = missionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Missão não encontrada") );
        foundMission.setName(missionDTO.getName());
        foundMission.setLevel(missionDTO.getLevel());
        Mission mission = missionRepository.save(foundMission);
        return missionMapper.map(mission);
    }

    public MissionDTO partialUpdate(MissionDTO missionDTO, Long id){
        Mission foundMission = missionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Missão não encontrada"));
        missionMapper.updateEntityFromDTO(missionDTO, foundMission);
        Mission mission = missionRepository.save(foundMission);
        return missionMapper.map(mission);
    }


    public void deleteById(Long id){
        missionRepository.deleteById(id);
    }
}
