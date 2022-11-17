package com.tyss.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.dto.FoodOrder;
import com.tyss.dto.Menu;

public class FoodOrderDao {

	public FoodOrder saveMenu(FoodOrder foodOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}
	public FoodOrder updateMenu(FoodOrder foodOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();

		return foodOrder;
	}
	public boolean cancelfoodOrder(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		FoodOrder foodOrder=entityManager.find(FoodOrder.class, id);
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return true;
	}
	public FoodOrder getFoodorderById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	return entityManager.find(FoodOrder.class, id);
	}
}
