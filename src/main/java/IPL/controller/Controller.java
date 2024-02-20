package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dto.Management;
import IPL.dto.Player;
import IPL.dto.Team;

@org.springframework.stereotype.Controller
public class Controller 
{
	@Autowired  
	Management management;//fresh object of the management dto class
	
	@Autowired
	Team team;
	
	@Autowired
	Player player;
	
	@RequestMapping("/signup")
	@ResponseBody
	public ModelAndView signup(@RequestParam String role) //@RequestParam:-it will work as req.getParameter() and
														  //here it will be used to receive the values ,one by one from the frontened
	{
		ModelAndView modelAndView = new ModelAndView();
		if(role.equals("Management"))
		{
			modelAndView.addObject("management", management);  //key value pair
			modelAndView.setViewName("management.jsp");
		}
		else if(role.equals("Team"))
		{
			modelAndView.addObject("team",team);
			modelAndView.setViewName("teamsignup.jsp");
		}
		else
		{
			modelAndView.addObject("player",player);
			modelAndView.setViewName("playersignup.jsp");
		}
		return modelAndView;
	}
}
