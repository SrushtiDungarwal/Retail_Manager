package com.jbk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Product;

public class HibernateConfig {
	
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		return sessionFactory;
	}

}
