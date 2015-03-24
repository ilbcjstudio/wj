package action;

import java.util.List;

import org.hibernate.SessionFactory;

public class PageBase implements PageBaseImp {
	 private SessionFactory sessionFactory;  
     
	    // 根据第几页获取，每页几行获取数据   
	    public List getList(String page, String rows) {  
	          
	        //当为缺省值的时候进行赋值   
	        int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//第几页   
	        int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10": rows);//每页多少行   
	          
	        List list = this.sessionFactory.getCurrentSession().createQuery("from Dept")  
	                       .setFirstResult((currentpage - 1) * pagesize).setMaxResults(pagesize).list();  
	  
	        return list;  
	    }  
	  
	    // 统计一共有多少数据   
	    public int getTotal() throws Exception {  
	        return this.sessionFactory.getCurrentSession().find("from Dept").size();  
	    }  
	      
	    public SessionFactory getSessionFactory() {  
	        return sessionFactory;  
	    }  
	  
	    public void setSessionFactory(SessionFactory sessionFactory) {  
	        this.sessionFactory = sessionFactory;  
	    }  

}
