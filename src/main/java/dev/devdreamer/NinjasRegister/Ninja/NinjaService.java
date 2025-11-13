package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import dev.devdreamer.NinjasRegister.Ninja.mapper.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //create ninja
    public NinjaDTO create(NinjaDTO ninjaDTO){
        Ninja ninja = new NinjaMapper().map(ninjaDTO);
        ninja  = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja); // aqui ele transforma em um dto novamente

    }

    //list all ninjas
    public List<NinjaDTO> getAll (){

        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }
    //find ninja by id
    public NinjaDTO findById(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id); //Optional porque o ninja pode n existir
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO update(Long id, NinjaDTO ninjaDTO){
        Optional<Ninja> foundNinja = ninjaRepository.findById(id);
        if(foundNinja.isPresent()){
            Ninja updatedNinja = ninjaMapper.map(ninjaDTO);
            updatedNinja.setId(id);
            Ninja savedNinja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.map(savedNinja);

        }
        return null;
    }


    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }

}
