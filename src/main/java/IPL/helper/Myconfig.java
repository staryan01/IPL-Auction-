package IPL.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "IPL")
public class Myconfig
{
	@Bean	//	bean in advanced java means object//it will helpful to create reference variable of interface type mainly it is used to return the reference variable
	public EntityManager getEM()
	{
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("dev");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	
}
