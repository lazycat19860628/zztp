package com.example.demo.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.sec.dao.SysRoleRepository;
import com.example.demo.sec.domain.SysRole;
import com.example.demo.sec.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	RoleService roleService;

	@Autowired
	SysRoleRepository sysRoleRepository;
	@RequestMapping("/sys/role/index")
	public String  userindex(Model model){
		model.addAttribute("index",roleService.findAll());
		return "sys/role/index";
		
	}
	@RequestMapping("/sys/role/create")
	public String  create(){
		return "sys/role/create";
		
	}
	

	
	@RequestMapping("/sys/role/search")
	public  String search(Model model,String name){
		model.addAttribute("search",roleService.findByNameLike(name));
		return "sys/role/search";
		
	}
	@RequestMapping("/sys/role/edit")
	public String  edit(Model model,Long id){
		model.addAttribute("edit",roleService.findById(id));

		return "sys/role/edit";
		
	}
	@RequestMapping("/sys/role/save")
	public  String rolesave(RedirectAttributes model,Long id,String name,String action){
		SysRole	sysRole=roleService.findByName(name);
			if(action.contains("create") && sysRole!=null) {
				model.addFlashAttribute("exist","此角色已存在");
				return "redirect:/sys/role/create";
			}
			roleService.save(id,name,action);
			return "redirect:/sys/role/index";
		
	
	}
}
