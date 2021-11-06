package com.example.calculator.dao;

import com.example.supportmodule.entities.MathResultInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathOperationRepository extends CrudRepository<MathResultInfo, Integer> {
}
