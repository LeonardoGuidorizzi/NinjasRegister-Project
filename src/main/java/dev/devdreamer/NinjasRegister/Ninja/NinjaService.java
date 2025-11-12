package dev.devdreamer.NinjasRegister.Ninja;

import dev.devdreamer.NinjasRegister.Ninja.dto.NinjaDTO;
import dev.devdreamer.NinjasRegister.Ninja.mapper.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Ninja> getAll (){
        return ninjaRepository.findAll();
    }
    //find ninja by id
    public Ninja findById(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id); //Optional porque o ninja pode n existir
        return ninja.orElse(null);
    }

    public Ninja update(Long id, Ninja ninja){
        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }


    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }

}
