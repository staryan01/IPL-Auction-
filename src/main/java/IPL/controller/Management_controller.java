package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.ManagementDao;
import IPL.dto.Management;

@Controller
public class Management_controller 
{
	@Autowired
	ManagementDao managementDao;
	
//	@PostMapping("managementsignup")
	@RequestMapping("managementsignup")
	@ResponseBody
	public ModelAndView management_signup(@ModelAttribute Management management) 
	{
		managementDao.Management_save(management);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","management account got created");//used to print msg
		modelAndView.setViewName("LoginArea.jsp"); //alternative of request dispatcher
		
		return modelAndView;
	}
	
	@PostMapping("managementlogin")
	@ResponseBody
	public ModelAndView management_login(@RequestParam String name, @RequestParam String password)
	{
		Management management= managementDao.management_login(name);
		ModelAndView modelAndView=new ModelAndView();
		if(management==null)
		{
			modelAndView.addObject("msg", "Invalid Username");
			modelAndView.setViewName("LoginArea.jsp");
		}
		else
		{
			if(management.getPassword().equals(password))
			{
				modelAndView.addObject("msg","Management Login Success");
				modelAndView.setViewName("managementHome.jsp");
			}
			else
			{
				modelAndView.addObject("msg", "Invalid Password");
				modelAndView.setViewName("LoginArea.jsp");
			}
		}
		return modelAndView;
	}
}

