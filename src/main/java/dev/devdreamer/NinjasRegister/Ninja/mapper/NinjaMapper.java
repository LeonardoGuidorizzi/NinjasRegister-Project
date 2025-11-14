package dev.devdreamer.NinjasRegister.Ninja.mapper;

import dev.devdreamer.NinjasRegister.Ninja.Ninja;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public Ninja map (NinjaDTO ninjaDTO) { // transforma em entity
        var ninja = new Ninja();
        ninja.setId(ninjaDTO.getId());
        ninja.setName(ninjaDTO.getName());
        ninja.setAge(ninjaDTO.getAge());
        ninja.setRank(ninjaDTO.getRank());
        ninja.setEmail(ninjaDTO.getEmail());
        ninja.setImgUrl(ninjaDTO.getImgUrl());
        return ninja;
    }

    public NinjaDTO map (Ninja ninja){ //transforma em dto
        var ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninja.getId());
        ninjaDTO.setName(ninja.getName());
        ninjaDTO.setAge(ninja.getAge());
        ninjaDTO.setRank(ninja.getRank());
        ninjaDTO.setEmail(ninja.getEmail());
        ninjaDTO.setImgUrl(ninja.getImgUrl());
        ninjaDTO.setMissionId(ninja.getMission() != null ? ninja.getMission().getId() : null);
        /*Imagine que o Ninja pode ou não ter uma missão.
        Se ele tem missão, você quer pegar o ID da missão.
        Se ele não tem missão, você quer devolver null.
        */
        return ninjaDTO;
    }
    public void updateEntityFromDTO(NinjaDTO dto, Ninja entity) {
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getAge() != 0) entity.setAge(dto.getAge());
        if (dto.getRank() != null) entity.setRank(dto.getRank());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getImgUrl() != null) entity.setImgUrl(dto.getImgUrl());
    }
    /**
     * Isso significa:
     *“Se o nome veio preenchido no DTO, atualize o nome do Ninja.”
     * Se o nome não vier, ele mantém o nome antigo (não muda nada).
     *
     * if (null != null) // falso!
     * então ele pula e não atualiza
     * if(valor != null)// verdadeiro!
     * então ele atualiza o campo
     */

}
