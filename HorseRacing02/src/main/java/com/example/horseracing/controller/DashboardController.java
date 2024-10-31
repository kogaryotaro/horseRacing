package com.example.horseracing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/top")
	public String showDashboard() {
		return "dashboard";
	}
}
