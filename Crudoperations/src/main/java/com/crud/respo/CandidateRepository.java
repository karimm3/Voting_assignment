package com.crud.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.ent.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>  {

}
