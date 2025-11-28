package dev.devdreamer.NinjasRegister.Mission.mapper;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import dev.devdreamer.NinjasRegister.Mission.dto.*;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface MissionMapper {
    // CREATE DTO → ENTITY
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ninjas", ignore = true)
    Mission toEntity(MissionCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ninjas", ignore = true)
    Mission toEntity(MissionResponseDTO dto);

    // ENTITY → RESPONSE DTO
    MissionResponseDTO toDto(Mission mission);

    // UPDATE DTO → ENTITY (PUT)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ninjas", ignore = true)
    void updatePut(MissionUpdateDTO dto, @MappingTarget Mission entity);

    // PATCH DTO → ENTITY
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ninjas", ignore = true)
    void updatePatch(MissionPatchDTO dto, @MappingTarget Mission entity);


}



//public Mission map(MissionDTO missionDTO){
//    var mission = new Mission();
//    mission.setId(missionDTO.getId());
//    mission.setName(missionDTO.getName());
//    mission.setLevel(missionDTO.getLevel());
//    return mission;
//}
//public MissionDTO map(Mission mission){
//    var missionDTO = new MissionDTO();
//    missionDTO.setId(mission.getId());
//    missionDTO.setName(mission.getName());
//    missionDTO.setLevel(mission.getLevel());
//    return missionDTO;
//}
//
//public void updateEntityFromDTO(MissionDTO dto, Mission entity){
//    if(dto.getName() != null)entity.setName(dto.getName());
//    if(dto.getLevel() != null)entity.setLevel(dto.getLevel());
//}


