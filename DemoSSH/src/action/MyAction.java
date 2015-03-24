package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;


import bean.Dept;

import dao.BaseDao;

public class MyAction {
	private BaseDao baseDao;
	private Dept dept;
//	private PageBase pageBase;
//	 private String rows;// 每页显示的记录数
//	 private String page;// 当前第几页

	
//	public String getAllInfos(){  
//		String wherehql="from Dept";
//		
//		List dList=baseDao.queryAllInfos(wherehql);
//		
//		return "GETALLINFOS";
//	}
	
	public String getAllInfos() throws Exception{  
		String wherehql="from Dept where 1=1";
		
		List dList=baseDao.queryAllInfos(wherehql,null);
		this.toBeJson(dList);
		
		return null;
	}
	
	
//	 public void toBeJson(List list,int total) throws Exception{  
	 public void toBeJson(List list) throws Exception{ 
         HttpServletResponse response = ServletActionContext.getResponse();  
         HttpServletRequest request = ServletActionContext.getRequest();  
           
         JSONObject jobj = new JSONObject();//new一个JSON  
//         jobj.accumulate("total",total );//total代表一共有多少数据  
//         jobj.accumulate("rows", list);//row是代表显示的页的数据  

         response.setCharacterEncoding("utf-8");//指定为utf-8  
         response.getWriter().write(jobj.toString());//转化为JSOn格式  
           
         System.out.println(jobj.toString());  
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


//	public PageBase getPageBase() {
//		return pageBase;
//	}
//
//
//	public void setPageBase(PageBase pageBase) {
//		this.pageBase = pageBase;
//	}


//	public String getRows() {
//		return rows;
//	}
//
//
//	public void setRows(String rows) {
//		this.rows = rows;
//	}
//
//
//	public String getPage() {
//		return page;
//	}
//
//
//	public void setPage(String page) {
//		this.page = page;
//	}



}
