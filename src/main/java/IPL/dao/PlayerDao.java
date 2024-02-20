package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.Player;
import IPL.dto.Team;

@Component
public class PlayerDao 
{
	@Autowired
	EntityManager entityManager;
	
	public void playerSignup(Player player)
	{

		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();	
	}
	public Player playerLogin(String username)
	{
		List<Player> list = entityManager.createQuery("select z from Player z where username=?1").setParameter(1, username).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	public void updatePlayer(Player player)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(player);
		entityTransaction.commit();	
	}
	
	public List<Player> fetchAllPlayers()
	{
		List<Player> players = entityManager.createQuery("select z from Player z ").getResultList();
		if(players.isEmpty())
		{
			return null;
		}
		else 
		{
			return players;
		}
	}
	public Player find(int id)
	{
		Player player = entityManager.find(Player.class, id);
		if(player==null)
		{
			return null;
		}
		else
		{
			return player;
		}
	}
	public List<Player> viewAvailablePlayer()
	{
		List<Player> players = entityManager.createQuery("select x from Player x where status='Available' ").getResultList();
		return players; //i am returning the 

	}
}
