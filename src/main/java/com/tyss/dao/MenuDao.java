package com.tyss.dao;
	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;

import com.tyss.dto.FoodItems;
import com.tyss.dto.Menu;

	public class MenuDao {
		Scanner sc=new Scanner(System.in);

		public Menu saveMenu(Menu menu) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction= entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(menu);
			entityTransaction.commit();

			return menu;
		}

		public void updateMenu(int id) {
			
			Menu menu1 = new Menu();
			menu1.setId(id);
			System.out.println("Enter the Menu name");
			menu1.setName(sc.next());
			boolean menub1 = true;
			List<FoodItems> updatedlist = new ArrayList<FoodItems>();
			while (menub1) {
				FoodItems items = new FoodItems();
				System.out.println("Enter the item name");
				items.setName(sc.next());
				System.out.println("Enter thr price ");
				items.setPrice(sc.nextDouble());
				System.out.println("Enter the desc");
				items.setDesc(sc.next());
				updatedlist.add(items);
				System.out.println("Enter 1 to add another item");
				if (sc.nextInt() == 1) {
					menub1 = true;
				} else {
					menub1 = false;
				}
			}
			menu1.setItems(updatedlist);
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(menu1);
			entityTransaction.commit();
		}

		public boolean deleteMenu(int id) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Menu menu = entityManager.find(Menu.class, id);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();

			return true;
		}
		
		public Menu getMenuById(int id) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("foodapp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager.find(Menu.class, id);
		}
	}

