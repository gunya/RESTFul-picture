package com.hepexta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PicController {

	@GetMapping(value = "/", produces = "text/html")
	public String welcome(Model model) {
		return "index";
	}

}
