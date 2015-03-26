package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hibernate.SessionFactory;


import bean.Dept;

import dao.BaseDao;

public class MyAction {
	private BaseDao baseDao;
	private Dept dept;
	private String num;
	private String dids;
	private String rows;//每页显示的记录数 
    private String page;//当前第几页
    private int total;//总信息数


	
	public String getAllInfos() throws Exception{
		String wherehql="from Dept where 1=1 ";
		
		HttpServletResponse response = ServletActionContext.getResponse();  
		HttpServletRequest request = ServletActionContext.getRequest();  
         
	  	String query_did=request.getParameter("query_did");
	  	String query_dname=request.getParameter("query_dname");
	   
//	  	System.out.println("query_did:"+query_did+"  query_dname:"+query_dname);

	  	if(query_did!=null&&!query_did.equals("")){
	  		wherehql=wherehql+" and did like '%"+query_did+"%'" ;
//			System.out.println(wherehql);
		}
	  	if(query_dname!=null&&!query_dname.equals("")){
	  		wherehql=wherehql+" and dname like '%"+query_dname+"%'" ;
//			System.out.println(wherehql);
		}
		
        int intPage = Integer.parseInt((page == null || page == "0") ? "1":page); //当前页,page由分页工具负责传过来     
        int number = Integer.parseInt((rows == null || rows == "0") ? "10":rows);  //每页显示条数    
        int start = (intPage-1)*number;  //每页的开始记录  第一页为1  第二页为number +1  
        List dList=baseDao.queryAllInfos(wherehql);
        total=dList.size();//查询数据库总记录数，得到分页的页数

		this.toBeJson(dList,total);
	
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
	
	
	 public void toBeJson(List list,int total) throws Exception{  
         HttpServletResponse response = ServletActionContext.getResponse();  
         HttpServletRequest request = ServletActionContext.getRequest();  
           
         JSONObject jobj = new JSONObject();//new一个JSON  
         jobj.accumulate("rows", list);//row是代表显示的页的数据  
         jobj.accumulate("total",total );//total代表一共有多少数据  

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
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}




}
