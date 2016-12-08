package com.quadcore.chat.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			//loads configs and mappings
			Configuration config = new Configuration();
			ServiceRegistry servReg = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties()).build();
			
			//builds a session factory from the service registry
			sessionFactory = config.buildSessionFactory(servReg);
		}
		return sessionFactory;
	}
}
