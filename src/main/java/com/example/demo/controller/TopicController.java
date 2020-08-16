package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Topic;
import com.example.demo.service.TopicService;

@Controller
public class TopicController {
	@Autowired
	TopicService topicService;
	@RequestMapping("/comment/topic/index")
	public String index(Model model) {
		model.addAttribute("index",topicService.index());
		return "comment/topic/index";
	}
	
	@RequestMapping("/comment/topic/edit")
	public String edit(Model model,Long id) {
		model.addAttribute("edit",topicService.instance(id));
	
		return "comment/topic/edit";
	}
	@RequestMapping("/comment/topic/docomment")
	public String docomment(Model model,Long id,String commentRule) {
		model.addAttribute("edit",topicService.instance(id));
	
		return "comment/topic/docomment/"+topicService.instance(id).getCommentRule();
	}

	@RequestMapping("/comment/topic/save")
	public String save(Model model,Topic topic) {
		System.out.print(topic.getName());
		System.out.print(topic.getCommentTargets().get(0).getId());
		topicService.save(topic);
		return "comment/topic/index";
	}
	@RequestMapping("/comment/topic/commit")
	public String commit(Model model,Topic topic) {
		topicService.save(topic);
		return "comment/topic/index";
	}

}
