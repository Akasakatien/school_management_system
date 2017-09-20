package dao;


import entities.Marks;

public class MarksDAO extends AbstractModel<Marks>{
	public MarksDAO(){
		super(Marks.class);
	}
	public Marks findByName(String name){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
		}
			
			return (Marks) sessionFactory.getCurrentSession().createQuery("select m from Marks m "
					+ "where m.student.name = :name ")
					.setString("name", name)
					.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		
	}

}
