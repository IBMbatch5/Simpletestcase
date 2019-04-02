package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.CustomerDBBean;
import com.training.bean.LoginBean;
import com.training.dao.CustomerDAO;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	//added for TC87 using db table
	@DataProvider(name = "db-inputs2")
	public Object [][] getcustDBData() {

		List<CustomerDBBean> list = new CustomerDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(CustomerDBBean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getgroupname(); 
			obj[1] = temp.getdescription(); 
			obj[2] = temp.getfirstname();
			obj[3] = temp.getlastname();
			obj[4] = temp.getemail();
			obj[5] = temp.getpassword();
			obj[6] = temp.getconfirmpassword();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Selenium\\TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	//added data provider for TC58 excel scenario
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelDatas(){
		String fileName ="C:\\Selenium\\TestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Selenium\\TestData.xlsx", "Sheet1"); 
	}
}
