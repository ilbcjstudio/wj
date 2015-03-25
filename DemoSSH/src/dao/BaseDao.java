package dao;

import java.util.List;

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
	
}
 