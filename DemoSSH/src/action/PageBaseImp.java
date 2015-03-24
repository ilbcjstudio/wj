package action;

import java.util.List;

public interface PageBaseImp {
	 public List getList(String page,String rows) throws Exception;//根据第几页获取，每页几行获取数据    
     public int getTotal() throws Exception;//统计一共有多少数据  
}
