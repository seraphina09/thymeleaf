package com.temp.service;

import com.temp.model.Temp;

import java.util.List;

public interface TempService {
    List<Temp> getTemps();

    Temp getTempById(Long id);

    Temp insertTemp(Temp temp);

    void deleteTemp(Long id);

}
