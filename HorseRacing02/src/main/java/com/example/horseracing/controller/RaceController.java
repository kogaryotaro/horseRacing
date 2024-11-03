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

import com.example.horseracing.form.RaceForm;
import com.example.horseracing.repository.RaceRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/races")
public class RaceController {

	private final RaceRepository repository;
	
	@GetMapping("/add")
	private String showAddRaceForm(
			@ModelAttribute RaceForm form,
			Model model) {
		model.addAttribute("race", form);
		return "add-race";
	}
	
	@PostMapping("/add")
	private String addRace(
			@Validated @ModelAttribute("race") RaceForm form,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("登録失敗");
			return "add-race";
		}
		
		try {
			repository.addRace(form);
			redirectAttributes.addFlashAttribute("message", "レース情報が登録されました！");
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "登録に失敗しました...");
			return "redirect:/races/add";
		}
			
		return "redirect:/races/add";
		
	}
	
	@GetMapping("/all")
	private String getAllRaces(Model model) {
		model.addAttribute("races", repository.getAllRaces());
		return "list";
	}
}
