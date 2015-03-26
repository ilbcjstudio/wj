package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.Dept;

public class BaseDao extends HibernateDaoSupport implements BaseDaoImp {

	public void add(String hql, Object object) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(hql,object);
	}

	public void del(Object object) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().delete(object);
	} 

	public List queryAllInfos(String hql) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().find(hql);
	}

	public void queryById(String hql, Object object) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().find(hql, object);
	}

	public void update(String hql, Object object) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().update(object);
	}
	
	public List queryByHqlTop(String hql,int curr,int rowNum) {
		Session session=super.getHibernateTemplate().getSessionFactory().openSession();
		Query qu=session.createQuery(hql);
		qu.setFirstResult(curr);  //起始行数
		qu.setMaxResults(rowNum); //查询条数
		List list=qu.list();
		session.close();
		return list;
	}
	
}
 