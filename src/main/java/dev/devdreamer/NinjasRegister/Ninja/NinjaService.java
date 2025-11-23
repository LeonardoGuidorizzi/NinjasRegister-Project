package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import dev.devdreamer.NinjasRegister.Mission.MissionService;
import dev.devdreamer.NinjasRegister.Mission.dto.MissionResponseDTO;
import dev.devdreamer.NinjasRegister.Mission.mapper.MissionMapper;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import dev.devdreamer.NinjasRegister.Ninja.mapper.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;
    private MissionService missionService;
    private MissionMapper missionMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissionService missionService, MissionMapper missionMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missionService = missionService;
        this.missionMapper = missionMapper;
    }

    //create ninja
    public NinjaDTO create(NinjaDTO ninjaDTO){
        Ninja ninja = new NinjaMapper().map(ninjaDTO);//ele tranforma um dto em um entity


        Mission mission = missionService.findById(ninjaDTO.getMissionId());
        ninja.setMission(mission);//ele coloca a missão encontrada na missão relacionada com o ninja

        ninja  = ninjaRepository.save(ninja);// insere o entity
        return ninjaMapper.map(ninja); // aqui ele transforma em um dto novamente
    }

    //list all ninjas
    public List<NinjaDTO> getAll (){

        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)//.map() aplica função no valor, se existir
                .toList();//agora que todos foram processados me devolva uma lista
    }
    //find ninja by id
    public NinjaDTO findById(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id); //Optional porque o ninja pode n existir
        return ninja.map(ninjaMapper::map).orElseThrow(()-> new RuntimeException("Ninja não encontrado"));
    }

    public NinjaDTO update(Long id, NinjaDTO ninjaDTO){
        Ninja foundNinja = ninjaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ninja não encontrado"));
        foundNinja.setName(ninjaDTO.getName());
        foundNinja.setAge(ninjaDTO.getAge());
        foundNinja.setRank(ninjaDTO.getRank());
        foundNinja.setEmail(ninjaDTO.getEmail());
        foundNinja.setImgUrl(ninjaDTO.getImgUrl());
        Ninja ninja = ninjaRepository.save(foundNinja);
        return ninjaMapper.map(ninja);

    }

    public NinjaDTO partialUpdate(Long id, NinjaDTO ninjaDTO){
        Ninja foundNinja = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado") );
        // Atualiza os campos do ninja que já existe
       ninjaMapper.updateEntityFromDTO(ninjaDTO, foundNinja);
        Ninja ninja = ninjaRepository.save(foundNinja);
        return ninjaMapper.map(ninja);//tranforma em Ninja DTO
    }



    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }

}
