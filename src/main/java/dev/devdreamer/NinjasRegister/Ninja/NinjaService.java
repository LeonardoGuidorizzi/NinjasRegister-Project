package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Mission.Mission;
import dev.devdreamer.NinjasRegister.Mission.MissionRepository;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaCreateDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaPatchDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaResponseDTO;
import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaUpdateDTO;
import dev.devdreamer.NinjasRegister.Ninja.mapper.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    MissionRepository missionRepository;
    private NinjaMapper ninjaMapper;




    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper, MissionRepository missionRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
        this.missionRepository = missionRepository;

    }

    //create ninja
    public NinjaResponseDTO create(NinjaCreateDTO ninjaDTO){
        Ninja ninja = ninjaMapper.toEntity(ninjaDTO);//ele tranforma um dto em um entity


        Mission mission = missionRepository.findById(ninjaDTO.missionId())
                .orElseThrow(() -> new RuntimeException("Missão não encontrada"));;
        ninja.setMission(mission);//ele coloca a missão encontrada na missão relacionada com o ninja

        ninja  = ninjaRepository.save(ninja);// insere o entity
        return ninjaMapper.toDto(ninja); // aqui ele transforma em um dto novamente
    }

    //list all ninjas
    public List<NinjaResponseDTO> getAll (){

        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDto)//.map() aplica função no valor, se existir
                .toList();//agora que todos foram processados me devolva uma lista
    }
    //find ninja by id
    public NinjaResponseDTO findById(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id); //Optional porque o ninja pode n existir
        return ninja.map(ninjaMapper::toDto).orElseThrow(()-> new RuntimeException("Ninja não encontrado"));
    }

    public NinjaResponseDTO update(Long id, NinjaUpdateDTO ninjaDTO){
        Ninja foundNinja = ninjaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Ninja não encontrado"));
        ninjaMapper.updatePut(ninjaDTO, foundNinja);
        Ninja ninja = ninjaRepository.save(foundNinja);
        return ninjaMapper.toDto(ninja);

    }

    public NinjaResponseDTO partialUpdate(Long id, NinjaPatchDTO ninjaDTO){
        Ninja foundNinja = ninjaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado") );
        // Atualiza os campos do ninja que já existe
        ninjaMapper.updatePatch(ninjaDTO, foundNinja);
        Ninja ninja = ninjaRepository.save(foundNinja);
        return ninjaMapper.toDto(ninja);//tranforma em Ninja DTO
    }



    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }

}
