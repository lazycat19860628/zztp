package com.example.demo.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.sec.dao.SysRoleRepository;
import com.example.demo.sec.dao.SysUserRepository;
import com.example.demo.sec.domain.SysUser;
import com.example.demo.sec.service.RoleService;
import com.example.demo.sec.service.UserService;

@Controller
public class UserController {
	@Autowired
	SysUserRepository sysUserRepository;
	@Autowired
	SysRoleRepository sysRoleRepository;
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;
	@RequestMapping("/sys/user/index")
	public String  userindex(Model model){
		model.addAttribute("index",userService.findAll());
		return "sys/user/index";
		
	}
	@RequestMapping("/sys/user/create")
	public String  userform(Model model){
		model.addAttribute("create",roleService.findAll());
		return "sys/user/create";
		
	}
	
	@RequestMapping("/sys/user/search")
	public  String cx(Model model,String username){
		model.addAttribute("search",userService.findByUsername(username));
		return "sys/user/search";
		
	}
	
	@RequestMapping("/sys/user/edit")
	public String  edit(Model model,String username,Long id){
	
		model.addAttribute("editrole",roleService.roles(id));
		model.addAttribute("edit",sysUserRepository.findById(id).get());
		return "sys/user/edit";
		
	}
	@RequestMapping("/sys/user/resetPass")
	public String  resetPass(Model model,Long id){
		SysUser sysUser = sysUserRepository.findById(id).get();
		sysUser.setPassword("000000");
		sysUserRepository.save(sysUser);
		return "sys/user/resetPass";
	}
	@RequestMapping("/sys/user/save")
	public  String save(RedirectAttributes model,Long id,String action,String username,String password, final String [] roles){
    SysUser sysUser=sysUserRepository.findByUsername(username);
		if(action.contains("create") && sysUser!=null) {
			model.addFlashAttribute("exist","此用户已存在");
			return "redirect:/sys/user/create";
		}
		userService.save(model, id, action, username, password, roles);
		return "redirect:/sys/user/index";
		 
	}

	@RequestMapping("/sys/user/gmmform")
	public String gmmform(Model model){
		
		return "sys/user/gmmform";
	}
	@RequestMapping("/sys/user/gmm")
	public String gmm(RedirectAttributes model,String oldpw,String newpw,String renewpw){
		if(newpw.equals(renewpw)) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				    .getAuthentication()
				    .getPrincipal();
			String username =userDetails.getUsername();
			SysUser sysUser=sysUserRepository.findByUsername(username);			
			if(oldpw.equals(sysUser.getPassword())) {
				sysUser.setPassword(newpw);
				sysUserRepository.save(sysUser);
				return "redirect:/login";
			}
			else {
				model.addFlashAttribute("pwe","密码不正确");
				return "redirect:/sys/user/gmmform";
			}
		}
		else {
			model.addFlashAttribute("repwe","两次输入的密码不一致");
			return "redirect:/sys/user/gmmform";
			}
	
		
		
	}
	
	
}
