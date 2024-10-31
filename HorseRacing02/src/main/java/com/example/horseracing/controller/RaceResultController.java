package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.horseracing.form.RaceResultForm;
import com.example.horseracing.repository.RaceResultRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/race-results")
public class RaceResultController {

	private final RaceResultRepository repository;
	
	@GetMapping("/add")
	public String showAddRaceResultForm(
			@ModelAttribute RaceResultForm form,
			Model model) {
		
		model.addAttribute("raceResult", form);
		return "add-race-result";
		
	}
	
	@PostMapping("/add")
	public String addRaceResult(
			@ModelAttribute RaceResultForm form,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		repository.addRaceResult(form);
		redirectAttributes.addFlashAttribute("message", "レース結果が登録されました");
		
		return "redirect:/ｒace-results/add";
		
	}
	
	@GetMapping("/all")
	public String getAllRaceResults(Model model) {
		model.addAttribute("raceResults", repository.getAllRaceResults());
		return "list";
	}
}
