package dev.devdreamer.NinjasRegister.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }
    //create ninja
    public Ninja create(Ninja ninja){
        return ninjaRepository.save(ninja);
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
