package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.ItemDAO;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class ItemDAOimpl implements ItemDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Item saveItem(int m_id, Item item) {

		MedOrder m = em.find(MedOrder.class, m_id);
		if (m != null) {
			
			List<Item> li=m.getItems();
			li.add(item);
			m.setItems(li);
			item.setOrders(m);
			et.begin();
			em.persist(item);
			et.commit();
			return item;
		}

		return null;
	}

	public Item getItemById(int i_id) {

		Item i = em.find(Item.class, i_id);
		if (i != null) {
			return i;
		}
		return null;
	}

	public boolean deletItemById(int i_id) {

		Item i = em.find(Item.class, i_id);
		if (i != null) {
			et.begin();
			em.remove(i);
			et.commit();
			return true;
		}
		return false;
	}

	public Item updateItemById(int i_id, Item item) {

		Item i = em.find(Item.class, i_id);
		if (i != null) {
			if (item.getCost() > 0)
				i.setCost(item.getCost());
			if (item.getI_name() != null)
				i.setI_name(item.getI_name());
			if (item.getQuantity() > 0)
				i.setQuantity(item.getQuantity());
			if (item.getOrders() != null)
				i.setOrders(item.getOrders());

			et.begin();
			em.merge(i);
			et.begin();
			return i;
		}
		return null;
	}

	public List<Item> getAllItems() {

		Query q = em.createQuery("select i from Item i");
		List<Item> items = q.getResultList();
		return items;
	}

}
