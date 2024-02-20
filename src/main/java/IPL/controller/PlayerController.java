package IPL.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.PlayerDao;
import IPL.dto.Player;

@RestController
public class PlayerController 
{
	@Autowired
	PlayerDao playerDao;
	
	@PostMapping("playersignup")
	public ModelAndView playerSignup(@ModelAttribute Player player)
	{
		player.setStatus("pending");
		playerDao.playerSignup(player);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg",player.getName()+" "+"Your account has been created successfully");
		modelAndView.setViewName("LoginArea.jsp");
		return modelAndView;
	}
	
	@PostMapping("playerlogin")
	public ModelAndView playerLogin(@RequestParam String username, @RequestParam String password,HttpSession httpSession)
	{
		Player player = playerDao.playerLogin(username);
		ModelAndView modelAndView = new ModelAndView();
		if(player==null)
		{
			modelAndView.addObject("msg","Invalid Username");
			modelAndView.setViewName("LoginArea.jsp");
		}
		else
		{
			if(player.getPassword().equals(password))
			{
				httpSession.setAttribute("player",player);//for future use i am setting the information of
				modelAndView.addObject("msg","Login Success");
				modelAndView.setViewName("playerhome.jsp");
			}
			else
			{
				modelAndView.addObject("msg","Invalid Password");
				modelAndView.setViewName("LoginArea.jsp");
			}
		}
		return modelAndView;
		
	}
	
	@RequestMapping("editplayerDetails")
	public ModelAndView editPlayer(HttpSession httpSession)
	{
		Player player =(Player) httpSession.getAttribute("player");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("player",player);
		modelAndView.setViewName("editplayer.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping("updateplayer")
	public ModelAndView updatePlayer(@ModelAttribute Player player)
	{
		playerDao.updatePlayer(player);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","player data has been updated successfully");
		modelAndView.setViewName("playerhome.jsp");
		return modelAndView;
		
	}
	
	@RequestMapping("viewallplayers")
	public ModelAndView view_All_Players_Coming_for_Auction()
	{
		List<Player> players = playerDao.fetchAllPlayers();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("players",players);
		modelAndView.setViewName("viewAllPlayers.jsp");
		
		return modelAndView;
	}
	@RequestMapping("changeplayerstatus")
	public ModelAndView change_player_status(@RequestParam int id)
	{
		Player player =	playerDao.find(id);
		
		if(player.getStatus().equals("pending"))
		{
			player.setStatus("Available");
		}
		else
		{
			player.setStatus("pending");
		}
		playerDao.updatePlayer(player);
		List<Player> players=playerDao.fetchAllPlayers();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("players",players);
		
		modelAndView.addObject("msg","Player status got updated");
		modelAndView.setViewName("viewAllPlayers.jsp");
		
		
		return modelAndView;
		
	}
	@RequestMapping("viewAvailablePlayer")
	public ModelAndView viewAvailablePlayers()
	{
		List<Player> players=playerDao.viewAvailablePlayer();
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(players.isEmpty())
		{
			modelAndView.addObject("msg","NO players are available");
			modelAndView.setViewName("teamHome.jsp");
			
		}
		else
		{
			modelAndView.addObject("players",players);
			modelAndView.setViewName("buyplayers.jsp");
		}
		return modelAndView;
		
	}
}
