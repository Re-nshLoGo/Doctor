package com.geekster.doctor.dao;

import com.geekster.doctor.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends CrudRepository<Doctor,Integer> {
}
