package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Dept;

import dao.BaseDao;

//@Controller
public class MyAction {
	private List dList;
	private BaseDao baseDao;
	private Dept dept;
	
	public String getAllInfos(){
		String wherehql="from Dept where 1=1 ";
		
//		if(dept!=null&&!"".equals(dept.getDname())&&dept.getDname()!=null){
//			wherehql=wherehql+" and dname like '%"+dept.getDname()+"%' ";
//		}
		
		dList=baseDao.queryAllInfos(wherehql,null);
		System.out.println(123);
		return "GETALLINFOS";
	}
	
//	@RequestMapping("/queryDept")
//	public ModelAndView queryDept(){
//		List dList=baseDao.queryAllInfos("dept.queryDept",null);
//		
//		return  new ModelAndView("/html/jgwh.html","dList",dList);
//	}

	
	
	public List getdList() {
		return dList;
	}

	public void setdList(List dList) {
		this.dList = dList;
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
