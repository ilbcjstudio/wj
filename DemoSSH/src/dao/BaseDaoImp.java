package dao;

import java.util.List;

public interface BaseDaoImp {
	public List queryAllInfos(String hql);
	
	public void queryById(String hql,Object object);
	
	public void add(String hql,Object object);
	
	public void update(String hql,Object object);
	
	public void del(Object object);
}
