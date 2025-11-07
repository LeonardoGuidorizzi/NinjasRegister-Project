package dev.devdreamer.NinjasRegister.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    //list all ninjas
    public List<Ninja> getAll (){
        return ninjaRepository.findAll();
    }

}
