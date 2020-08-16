package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.CommentResult;
import com.example.demo.service.ResultService;
import org.springframework.ui.Model;

@Controller
public class ResultController {
	@Autowired
	ResultService resultService;

	@RequestMapping("/comment/result/index")
	public String result(Model model) {
		model.addAttribute("index",resultService.result());
		return "comment/result/index";

	}
}
