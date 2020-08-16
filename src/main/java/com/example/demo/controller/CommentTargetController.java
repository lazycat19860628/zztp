package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.CommentTargetService;

@Controller
public class CommentTargetController {
	@Autowired
	CommentTargetService commentTargetService;
	@RequestMapping("/comment/commentTarget/index")
	public String edit(Model model) {
		
		model.addAttribute("index",commentTargetService.index());
		return "comment/commentTarget/index";
	}
}
