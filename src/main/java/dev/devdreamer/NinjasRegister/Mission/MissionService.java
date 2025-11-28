package dev.devdreamer.NinjasRegister.Mission;

import dev.devdreamer.NinjasRegister.Mission.dto.*;
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

    public MissionResponseDTO create(MissionCreateDTO missionCreateDTO){
        Mission mission = missionMapper.toEntity(missionCreateDTO);
        mission  = missionRepository.save(mission);
        return missionMapper.toDto(mission);
    }

    public List<MissionResponseDTO> getAll (){
        List<Mission> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::toDto)
                .toList();
    }

    public MissionResponseDTO findEntityById(Long id){
        return missionMapper.toDto(
                missionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mission not found"))
        );
    }

    public MissionResponseDTO update(MissionUpdateDTO missionDTO, Long id){
        Mission foundMission = missionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Missão não encontrada") );
        missionMapper.updatePut(missionDTO, foundMission);
        missionRepository.save(foundMission);
        return missionMapper.toDto(foundMission);
    }

    public MissionResponseDTO partialUpdate(MissionPatchDTO missionDTO, Long id){
        Mission foundMission = missionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Missão não encontrada"));
        missionMapper.updatePatch(missionDTO, foundMission);
        missionRepository.save(foundMission);
        return missionMapper.toDto(foundMission);
    }


    public void deleteById(Long id){
        missionRepository.deleteById(id);
    }
}
