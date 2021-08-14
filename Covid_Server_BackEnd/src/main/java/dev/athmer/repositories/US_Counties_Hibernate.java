package dev.athmer.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.athmer.models.US_County;
import dev.athmer.utilities.HibernateUtil;

public class US_Counties_Hibernate implements I_Root_Repository<US_County> {

	@Override
	public US_County add(US_County usc) {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(usc);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			s.close();
		}
		return usc;
	}

	@Override
	public US_County getById(int id) {
		Session s = HibernateUtil.getSession();
		US_County usc = s.get(US_County.class, id); 
		s.close();
		return usc;
	}

	@Override
	public US_County getByName(String county) {
		
		Session s = HibernateUtil.getSession();
		US_County usc = null;
		
		try {
			
//			Criteria crit = s.createCriteria(US_County.class);
//			crit.add(Restrictions.eq("county", county));
//			usc = (US_County) crit.uniqueResult();
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<US_County> cr = cb.createQuery(US_County.class);
			Root<US_County> root = cr.from(US_County.class);
			cr.select(root).where(cb.equal(root.get("county"), county));
			usc = s.createQuery(cr).getSingleResult();
//			
//			
//			Predicate p1 = cb.equal(root.get("county"), county);		
//			cr.select(root).where(cb.and(p1));
//

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return usc;
	}

	@Override
	public List getAll() {
		Session s = HibernateUtil.getSession();
		List<US_County> us_counties = null;
		try {
			us_counties = s.createQuery("FROM us_counties").list();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			s.close();
		}
		
		return us_counties;
	}

	@Override
	public void update(US_County usc) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(usc);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			s.close();
		}
		
	}

	@Override
	public void delete(US_County usc) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = s.beginTransaction();
			s.delete(usc);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

}
