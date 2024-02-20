package IPL.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import IPL.dto.Management;
import antlr.collections.List;

@Component //object got created
public class ManagementDao 
{
	@Autowired
	EntityManager entityManager;
	
	public void Management_save(Management management)
	{
//		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin(); //used to make data ready
		entityManager.persist(management);  //make data move to database
		entityTransaction.commit();       // save the data
		
	}

	public Management management_login(String name) {
		java.util.List<Management> list=entityManager.createQuery("select x from Management x where name=?1").setParameter(1, name).getResultList();
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
