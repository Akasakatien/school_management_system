package dao;

import org.hibernate.Query;

import entities.Account;

public class AccountDAO extends AbstractModel<Account> {
	public AccountDAO() {
		super(Account.class);
	}

	public Account Login(String username, String password) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select a from Account a " + "where a.username = :username and a.password = :password");
			query.setString("username", username);
			query.setString("password", password);
			return (Account) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}

	}
}
