package dao;

import java.util.List;

import javax.management.Query;

import entities.ClassStudent;

public class ClassStudentDAO extends AbstractModel<ClassStudent>{
	public ClassStudentDAO(){
		super(ClassStudent.class);
	}
	public List<ClassStudent> search(String keyword) {
		try {
			if (!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = (Query) sessionFactory.getCurrentSession()
					.createQuery("select c " + "from ClassStudent c " + "where c.nameOfClass like :keyword");
			((org.hibernate.Query) query).setString("keyword", "%" + keyword + "%");
			return ((org.hibernate.Query) query).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
