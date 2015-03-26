package dao;

import java.util.List;

import bean.Dept;

public interface BaseDaoImp {
	public List queryAllInfos(String hql);
	
	public void queryById(String hql,Object object);
	
	public void add(String hql,Object object);
	
	public void update(String hql,Object object);
	
	public void del(Object object);
	
	public List queryByHqlTop(String hql,int curr,int rowNum);
	
}
