package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Topic;
import com.example.demo.service.TopicService;

@RestController
public class TopicRestController {
	@Autowired
	TopicService topicService;
	@RequestMapping("/rest/topic/save")
	public void save(Model model,Topic topic) {
		topicService.save(topic);
		return ;
	}
	@RequestMapping("/rest/topic/commit")
	public void commit(Model model,Topic topic) {
		topicService.commit(topic);
		return ;
	}
}
