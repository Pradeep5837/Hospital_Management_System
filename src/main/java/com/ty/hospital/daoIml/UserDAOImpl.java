package com.ty.hospital.daoIml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dao.UserDAO;
import com.ty.hospital.dto.User;

public class UserDAOImpl implements UserDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pradeep");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public User saveUser(User user) {

		if (user != null) {
			et.begin();
			em.persist(user);
			et.commit();
			return user;
		}

		return null;
	}

	public User getUserById(int u_id) {

		User u = em.find(User.class, u_id);
		if (u != null) {
			return u;
		}
		return null;
	}

	public boolean deletUserById(int u_id) {

		User u = em.find(User.class, u_id);

		if (u != null) {
			et.begin();
			em.remove(u);
			et.commit();
			return true;
		}
		return false;
	}

	public User updateUserById(int u_id, User user) {

		User u = em.find(User.class, u_id);
		if (u != null) {
			if (user.getEmail() != null)
				u.setEmail(user.getEmail());
			if (user.getName() != null)
				u.setName(user.getName());
			if (user.getPassword() > 0)
				u.setPassword(user.getPassword());
			if (user.getPhno() > 0)
				u.setPhno(user.getPhno());
			if (user.getRole() != null)
				u.setRole(user.getRole());
			et.begin();
			em.merge(u);
			et.commit();
			return u;
		}
		return null;
	}

	public List<User> getAllUser() {

		Query q = em.createQuery("select u from User u");
		List<User> users = q.getResultList();

		return users;
	}

	public List<User> getUserByRole(String role) {
		Query q = em.createQuery("select u from User u where u.role=?1");
		q.setParameter(1, role);
		List<User> users = q.getResultList();

		return users;
	}

}
