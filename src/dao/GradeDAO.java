package dao;

import java.util.List;

import org.hibernate.Query;

import entities.Grade;

public class GradeDAO extends AbstractModel<Grade>{
	public GradeDAO(){
		super(Grade.class);
	}
	public List<Grade> search(String keyword) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("select g " + "from Grade g " + "where g.gradeName like :keyword");
			query.setString("keyword", "%" + keyword + "%");
			return query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
