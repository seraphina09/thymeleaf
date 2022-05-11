package com.temp.repositories;

import com.temp.model.Temp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Temprepository extends CrudRepository<Temp, Long> {
}
