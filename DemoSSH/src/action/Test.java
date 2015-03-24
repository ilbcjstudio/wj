package action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import dao.BaseDaoImp;



public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		BaseDaoImp ibd=(BaseDaoImp) ac.getBean("baseDao");
		ibd.queryAllInfos("from Dept",null);
	}
	
}
