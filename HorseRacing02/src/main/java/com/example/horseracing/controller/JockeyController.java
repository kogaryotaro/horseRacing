package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.horseracing.form.JockeyForm;
import com.example.horseracing.repository.JockeyRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/jockeys")
public class JockeyController {

	private final JockeyRepository repository;
	
	@GetMapping("/add")
	public String showAddJockeyForm(
			@ModelAttribute JockeyForm form,
			Model model) {
		
		model.addAttribute("jockey", form);
		return "add-jockey";
		
	}
	
	@PostMapping("/add")
	public String addJockey(
			@ModelAttribute JockeyForm form,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		repository.addJockey(form);
		redirectAttributes.addFlashAttribute("message", "ジョッキー情報が登録されました");
		
		return "redirect:/jockeys/add";
		
	}
	
	@GetMapping("/all")
	public String getAllJockeys(Model model) {
		model.addAttribute("jockeys", repository.getAllJockeys());
		return "list";
	}
}
