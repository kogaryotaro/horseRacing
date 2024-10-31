package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.horseracing.form.RaceForm;
import com.example.horseracing.repository.RaceRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/races")
public class RaceController {

	private final RaceRepository raceRepository;
	
	@GetMapping("/add")
	private String showAddRaceForm(
			@ModelAttribute RaceForm form,
			Model model) {
		model.addAttribute("race", form);
		return "add-race";
	}
	
	@PostMapping("/add")
	private String addRace(
			@ModelAttribute RaceForm form,
			Model model,
			RedirectAttributes redirectAttributes) {
		int result = raceRepository.addRace(form);
		
		if (result == 1) {
			redirectAttributes.addFlashAttribute("message", "レース情報が登録されました！");
		} else {
			redirectAttributes.addFlashAttribute("message", "登録に失敗しました...");
		}
		
		return "redirect:/races/add";
		
	}
	
	@GetMapping("/all")
	private String getAllRaces(Model model) {
		model.addAttribute("races", raceRepository.getAllRaces());
		return "list";
	}
}
