package action;

import java.util.List;


import bean.Dept;

import dao.BaseDao;

public class MyAction {
	private BaseDao baseDao;
	private Dept dept;

	
	public String getAllInfos() throws Exception{
		String wherehql="from Dept";
		
		List dList=baseDao.queryAllInfos(wherehql);

		return "GETALLINFOS";
	}
	
	



	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}



}
