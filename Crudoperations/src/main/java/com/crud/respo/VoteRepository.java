package com.crud.respo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.ent.Candidate;
import com.crud.ent.register;
import com.crud.ent.vote;

public interface VoteRepository extends JpaRepository<vote, Long>{
    boolean existsByUser( register user);

	Long countByCandidate(Candidate candidate);

}
