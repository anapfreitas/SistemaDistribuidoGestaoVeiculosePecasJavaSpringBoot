package com.sd.apsf_prova_2_serv_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPeca;
import com.sd.apsf_prova_2_serv_2.models.ApsfVeiculoPecaId;

public interface ApsfVeiculoPecaRepository extends JpaRepository<ApsfVeiculoPeca, ApsfVeiculoPecaId> {
}