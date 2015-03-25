package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;


import bean.Dept;

import dao.BaseDao;

public class MyAction {
	private BaseDao baseDao;
	private Dept dept;
	
	private String num;
	private String dids;

	
//	public String getAllInfos(){  
//		String wherehql="from Dept";
//		
//		List dList=baseDao.queryAllInfos(wherehql);
//		
//		return "GETALLINFOS";
//	}
	
	public String getAllInfos() throws Exception{  
		String wherehql="from Dept where 1=1";
		
		 HttpServletResponse response = ServletActionContext.getResponse();  
         HttpServletRequest request = ServletActionContext.getRequest();  
         
		   String did=request.getParameter("query_did");
		   String danme=request.getParameter("query_dname");
		   
		   System.out.println(did+"  "+danme);
		   
//		   if(query_did!=null&&!query_did.equals("")){
				dept.setDid(Integer.parseInt(did));	
//				wherehql=wherehql+" and did like '%"+dept.getDid()+"%'" ;
//				System.out.println(wherehql);
//			}
//		   if(query_dname!=null&&!query_dname.equals("")){
				dept.setDname(danme);		
//				wherehql=wherehql+" and dname like '%"+dept.getDname()+"%'" ;
//			}
		if(dept!=null&&!"".equals(dept.getDid())&&dept.getDid()!=null){
			wherehql=wherehql+" and did like '%"+dept.getDid()+"%'" ;
		}
		if(dept!=null&&!"".equals(dept.getDname())&&dept.getDname()!=null){
			wherehql=wherehql+" and dname like '%"+dept.getDname()+"%'" ;
		}
		
		List dList=baseDao.queryAllInfos(wherehql);
		this.toBeJson(dList);
		
		return null;
	}
	public String delInfos()throws Exception{
		System.out.println("dfff");
//		String wherehql="delete * from Dept where did in ("+dids+")";

//		 List list=new ArrayList();
//		 Boolean b=false;
//	        int temp=Integer.parseInt(num);//循环次数
//	        int j=0;
//	        for (int i = 0; i < temp; i++) {
//		      list.add(dids.substring(j, j+3));//将一个字符串打散成多个字符串
//		      j=j+4;		
//		      System.out.println("==========="+list.get(i));
//		      baseDao.del(list.get(i));//根据ID主键进行删除操作
//		    }
		
//		String[] array = request.getParameterValues("array[]");  
//		List<Dept> list = new ArrayList<Dept>();  
//		for (int i = 0; i < array.length; i++) {   
//			dept.setDid(Integer.valueOf(array[i]));  
//			list.add(dept);  
//		}  
//		baseDao.del(list); 
		  

	    return null;
	}
	
	
	 public void toBeJson(List list) throws Exception{  
         HttpServletResponse response = ServletActionContext.getResponse();  
         HttpServletRequest request = ServletActionContext.getRequest();  
           
         JSONObject jobj = new JSONObject();//new一个JSON  
//         jobj.accumulate("total",total );//total代表一共有多少数据  
         jobj.accumulate("rows", list);//row是代表显示的页的数据  

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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDids() {
		return dids;
	}
	public void setDids(String dids) {
		this.dids = dids;
	}



}
