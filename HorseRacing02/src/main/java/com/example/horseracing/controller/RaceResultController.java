package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
			@Validated @ModelAttribute("raceResult") RaceResultForm form,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			System.out.println("登録失敗");
			return "add-race-result";
		}
		
		try {
			repository.addRaceResult(form);
			redirectAttributes.addFlashAttribute("message", "レース結果が登録されました");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "登録に失敗");
			return "redirect:/ｒace-results/add";
		}
		
		return "redirect:/ｒace-results/add";
		
	}
	
	@GetMapping("/all")
	public String getAllRaceResults(Model model) {
		model.addAttribute("raceResults", repository.getAllRaceResults());
		return "list";
	}
}
