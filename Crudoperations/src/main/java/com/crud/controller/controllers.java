package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.ent.Candidate;
import com.crud.ent.register;
import com.crud.ent.vote;
import com.crud.respo.CandidateRepository;
import com.crud.respo.VoteRepository;
import com.crud.respo.resgisterRespo;
import com.crud.service.serve;

import jakarta.servlet.http.HttpSession;

@Controller
public class controllers {

	@Autowired
	private serve serve;

	@Autowired
	private resgisterRespo respo;

	@Autowired
	private resgisterRespo userRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private VoteRepository voteRepository;

	@RequestMapping("/home")
	public String views() {

		return "index";

	}

	@RequestMapping("/Login")
	public String Logins() {

		return "Login";

	}

	@RequestMapping("/fake")
	public String Loginss() {

		return "fake";

	}

	@RequestMapping("/result")
	public String result() {

		return "results";

	}

	@RequestMapping("addAdmin")
	public String addadmin() {

		return "addAdmin";

	}

	@PostMapping("party")
	public String addparys(@ModelAttribute Candidate m) {

		candidateRepository.save(m);
		return "redirect:/results";

	}

	@RequestMapping("/vots")
	public String votingPage(Model model) {
		List<Candidate> ve = (List<Candidate>) candidateRepository.findAll();
		model.addAttribute("ve", ve);

		return "voting";
	}

	@RequestMapping("/insert")
	public String inserts(@RequestParam("userName") String userNAme, @RequestParam("password") String password,
			@RequestParam("EmailId") String email, @RequestParam("phone") Long Mob, RedirectAttributes attributes) {

		try {
			register req = respo.findByUserName(userNAme);
			if (req.getUserName().equals(userNAme)) {

				return "redirect:/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Boolean s = false;

		register regis = new register();

		regis.setUserName(userNAme);
		regis.setPassword(password);
		regis.setEmailId(email);
		regis.setPhone(Mob);
		regis.setHasVoted(false);
		regis.setAdmin(false);

		/* respo.save(regis); */

		serve.saver(regis);

		attributes.addFlashAttribute("message", "register successfully");
		return "redirect:/home";

	}

	@RequestMapping("LoginHere")
	public String Loginss(@RequestParam("user") String userName, @RequestParam("pass") String password,
			HttpSession session) {

		if (userName.equals("admin") && password.equals("admin@123")) {
			return "redirect:/results";
		}

		register s = this.respo.findByUserName(userName);

		if (s.isHasVoted() == true) {
			return "redirect:/fake";
		}

		if (s.getUserName().equals(userName) && s.getPassword().equals(password) && s.isAdmin() == true) {
			/* session.setAttribute("admin", s); */
			return "redirect:/results";
		}

		if (s.getUserName().equals(userName) && s.getPassword().equals(password)) {
			session.setAttribute("user", s);
			return "redirect:/vots";
		}

		return "redirect:/";
	}

	@RequestMapping("/vote")
	public String vote(@RequestParam Long candidateId, HttpSession session) {

		register user = (register) session.getAttribute("user");

		if (user != null && !user.isHasVoted()) {

			System.out.println("this is working");

			Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
			if (candidate != null) {

				vote vote = new vote();

				vote.setUser(user);
				vote.setCandidate(candidate);
				voteRepository.save(vote);

				user.setHasVoted(true);
				userRepository.save(user);
				return "redirect:/";
			}
		}

		return "redirect:/error";
	}

	@PostMapping("/removeSession")
	public String removeSession(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@PostMapping("/removeSessions")
	public String removeSessions(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}

	@RequestMapping("adminAdd")
	public String Admin(@RequestParam("userName") String userNAme, @RequestParam("password") String password,
			@RequestParam("EmailId") String email, @RequestParam("phone") Long Mob, RedirectAttributes attributes) {

		try {
			register req = respo.findByUserName(userNAme);
			if (req.getUserName().equals(userNAme)) {

				return "redirect:/error";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Boolean s = false;

		register regis = new register();

		regis.setUserName(userNAme);
		regis.setPassword(password);
		regis.setEmailId(email);
		regis.setPhone(Mob);
		regis.setHasVoted(false);
		regis.setAdmin(true);

		/* respo.save(regis); */

		serve.saver(regis);

		attributes.addFlashAttribute("message", "register successfully");
		return "redirect:/home";

	}

}
