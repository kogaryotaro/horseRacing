package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.horseracing.form.HorseForm;
import com.example.horseracing.repository.HorseRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/horses")
public class HorseController {

	private final HorseRepository repository;
	
	@GetMapping("/add")
	public String showAddHorseForm(
			@ModelAttribute HorseForm form,
			Model model) {
		
		model.addAttribute("horse", form);
		return "add-horse";
		
	}
	
	@PostMapping("/add")
	public String addHorse(
			@ModelAttribute HorseForm form,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		repository.addHourse(form);
		redirectAttributes.addFlashAttribute("message", "競走馬情報が登録されました");
		
		return "redirect:/horses/add";
		
	}
	
	@GetMapping("/all")
	public String getAllHorses(Model model) {
		model.addAttribute("horses", repository.getAllHorse());
		return "list";
	}
}
