package dao;

import entities.Divison;

public class DivisonDAO extends AbstractModel<Divison>{
	public DivisonDAO(){
		super(Divison.class);
	}
	public Divison findByName(String name){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive()){
				sessionFactory.getCurrentSession().getTransaction().begin();
		}
			
			return (Divison) sessionFactory.getCurrentSession().createQuery("select d from Divison d "
					+ "where d.staff.name = :name ")
					.setString("name", name)
					.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		
	}

}
