package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.Team;

@Component
public class TeamDao 
{
	@Autowired
	EntityManager entityManager;
	

	public void teamSave(Team team) 
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(team);
		entityTransaction.commit();	
		
	}
	public Team team_login(String username)
	{
		List<Team> list = entityManager.createQuery("select x from Team x where username=?1").setParameter(1, username).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	public List<Team> view_all_teams() {
		List<Team> teams = entityManager.createQuery("select x from Team x").getResultList();
		return teams;
	}
	public Team changeStatus(int tid)
	{
		Team team=entityManager.find(Team.class, tid);
		return team;
	}
	public void update(Team team)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.merge(team);
		entityTransaction.commit();	
	}
	public Team addAmount(int tid)
	{
		Team team = entityManager.find(Team.class, tid);
		return team;
	}
	public Team fetchAllTeamByUsingName(String name)
	{
		List<Team> list = entityManager.createQuery("select x from Team x where name=?1").setParameter(1, name).getResultList();
		
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
}
