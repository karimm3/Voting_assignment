package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.ent.Candidate;
import com.crud.respo.CandidateRepository;
import com.crud.respo.VoteRepository;

@Controller
public class ResultController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;
    
    @GetMapping("/results")
    public String results(Model model) {
    	
        List<Candidate> candidates = new ArrayList<>();
        List<Long> votesCount = new ArrayList<>();

        List<Candidate> allCandidates = null;
		try {
			allCandidates = candidateRepository.findAll();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
        for (Candidate candidate : allCandidates) {
        	
            candidates.add(candidate);
            
            votesCount.add(voteRepository.countByCandidate(candidate));
        }

        model.addAttribute("candidates", candidates);
        model.addAttribute("votesCount", votesCount);

        return "results";
    }

}
