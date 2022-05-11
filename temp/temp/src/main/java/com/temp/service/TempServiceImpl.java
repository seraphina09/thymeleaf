package com.temp.service;

import com.temp.model.Temp;
import com.temp.repositories.Temprepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TempServiceImpl implements TempService {
    Temprepository tempRepository;

    public TempServiceImpl(Temprepository temprepository) {
        this.tempRepository = temprepository;
    }

    @Override
    public List<Temp> getTemps(){
        List<Temp> temps = new ArrayList<>();
        tempRepository.findAll().forEach(temps::add);

        return temps;
    }

    @Override
    public Temp getTempById(Long id) {
        Optional<Temp> temp = tempRepository.findById(id);

        return temp.orElse(null);
    }

    @Override
    public Temp insertTemp (Temp temp) {
        return tempRepository.save(temp);
    }

    @Override
    public void deleteTemp(Long id) {
        tempRepository.deleteById(id);
    }

}
