  package IPL.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dao.TeamDao;
import IPL.dto.Player;
import IPL.dto.Team;

@Controller
public class Team_controller 
{
	@Autowired
	TeamDao teamDao;
	@Autowired
	PlayerDao playerDao;
	
	@RequestMapping("teamsignup")
	@ResponseBody
	public ModelAndView team_signup(@ModelAttribute Team team)
	{
		teamDao.teamSave(team);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("msg","Team account got created");
		modelAndView.setViewName("LoginArea.jsp");
		return modelAndView;
	}
	
	
	
	
	@ResponseBody
	@PostMapping("teamlogin")
	public ModelAndView teamlogin(@RequestParam String username,@RequestParam String  password,HttpSession httpSession)
	{
		Team team=teamDao.team_login(username);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(team == null)
		{
			modelAndView.addObject("msg","Invalid Username");
			modelAndView.setViewName("LoginArea.jsp");
		}
		else
		{
			if(team.getPassword().equals(password))
			{
				if(team.isStatus()==true)
				{
					httpSession.setAttribute("team", team);//if i want the information of the team in future, i can get that information using set attribute
					modelAndView.addObject("msg","Login success");
					modelAndView.addObject("img",team.getImagelink());
					modelAndView.setViewName("teamHome.jsp");
				}
				else
				{
					modelAndView.addObject("msg","management approval need to done");
					modelAndView.setViewName("LoginArea.jsp");
				}
				
			}
			else
			{
				modelAndView.addObject("msg","Invalid Password");
				modelAndView.setViewName("LoginArea.jsp");
			}
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("viewallteams")
	public ModelAndView viewAllteam()
	{
		List<Team> teams = teamDao.view_all_teams();
		ModelAndView modelAndView = new ModelAndView();
		
		if(teams.isEmpty())
		{
			modelAndView.addObject("msg","There are no teams presented inside database");
			modelAndView.setViewName("managementHome.jsp");
		}
		else
		{
			modelAndView.addObject("teams",teams);
			modelAndView.setViewName("viewallteams.jsp");
		}
		return modelAndView;
	}
	@RequestMapping("changestatus")
	public ModelAndView changestatus(@RequestParam int tid)
	{
		Team team=teamDao.changeStatus(tid);
		ModelAndView modelAndView=new ModelAndView();
		if(team.isStatus())
		{
			team.setStatus(false);
		}
		else
		{
			team.setStatus(true);
		}
		teamDao.update(team);
		List<Team> teams =teamDao.view_all_teams();
		
		modelAndView.addObject("teams",teams);
		modelAndView.addObject("msg","team status got updated");
		modelAndView.setViewName("viewallteams.jsp");
		
		return modelAndView;
		
	}
	
	@PostMapping("addamount")
	public ModelAndView addAmount(@RequestParam double wallet, @RequestParam int tid)
	{
		Team team = teamDao.addAmount(tid);
		team.setWallet(team.getWallet()+ wallet);
		teamDao.update(team);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "Amount has been added for "+""+team.getName()+" account successfully");
		modelAndView.setViewName("teamHome.jsp");
		return modelAndView;
	}
	
	@RequestMapping("buyplayer")
	public ModelAndView buyPlayer(@RequestParam int id,HttpSession httpSession)
	{
		Team team=(Team) httpSession.getAttribute("team");
		Player player=playerDao.find(id);
		ModelAndView modelAndView = new ModelAndView();
		
		if(team.getWallet()< player.getPrice())
		{
			modelAndView.addObject("msg","Insufficient Balance");
			modelAndView.setViewName("buyplayers.jsp");
		}
		else
		{
			team.setWallet(team.getWallet()-player.getPrice());
			
			player.setStatus("Sold");
			
			player.setTeam(team); //inside players reference variable i have taken team information
			
			playerDao.updatePlayer(player);
			
			List<Player> players1= team.getPlayers();
			
			if(players1==null)
			{
				List<Player> players2=new ArrayList<Player>();
				players2.add(player);
				team.setPlayers(players2);
				teamDao.update(team);
			}
			else
			{
				
			
			
			List<Player> players3= team.getPlayers(); //it is fresh copy 
			
			players3.add(player); //here one user information is coming and sitting
			
			team.setPlayers(players3); //inside team reference variable i have taken player information
			
			teamDao.update(team);
			}
			
			

			modelAndView.addObject("msg","player has been successfully sold out for team"+" "+team.getName());
			modelAndView.setViewName("teamHome.jsp");
		}
		return modelAndView;
		
	}
	@RequestMapping("viewteam")
	public ModelAndView viewTeam(HttpSession httpSession)
	{
		Team team=(Team) httpSession.getAttribute("team");
		List<Player> players=team.getPlayers();
		
		ModelAndView modelAndView = new ModelAndView();
		if(players.isEmpty())
		{
			modelAndView.addObject("msg","No players has been sold out for team: "+team.getName());
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("viewmyteam.jsp");
		}
		else
		{
			modelAndView.addObject("players",players);
			modelAndView.addObject("teamname",team.getName());
			modelAndView.setViewName("viewmyteam.jsp");
		}
		return modelAndView;
		
	}
	
	@RequestMapping("viewteambyname")
	public ModelAndView viewTeamByName()
	{
		List<Team> teams=teamDao.view_all_teams();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("teams",teams);
		modelAndView.setViewName("viewTeamByName.jsp");
		return modelAndView;
	}
	@PostMapping("fetchbyusingteamname")
	public ModelAndView name(@RequestParam String name)
	{
		Team team=teamDao.fetchAllTeamByUsingName(name);
		List<Player> players=team.getPlayers(); //virat + yuvi + chahal 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("players",players);
		modelAndView.setViewName("viewmyteam.jsp");
		
		return modelAndView;
	}
}
	




	