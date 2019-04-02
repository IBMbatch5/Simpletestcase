package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.CustomerDBBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class CustomerDAO {
	
	Properties properties; 
	
	public CustomerDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CustomerDBBean> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection gc  = new GetConnection(); 
		List<CustomerDBBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<CustomerDBBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				CustomerDBBean temp = new CustomerDBBean(); 
				temp.setgroupname(gc.rs1.getString(1));
				temp.setdescription(gc.rs1.getString(2));
				temp.setfirstname(gc.rs1.getString(3));
				temp.setlastname(gc.rs1.getString(4));
				temp.setemail(gc.rs1.getString(5));
				temp.setpassword(gc.rs1.getString(6));
				temp.setconfirmpassword(gc.rs1.getString(7));
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new CustomerDAO().getLogins().forEach(System.out :: println);
	}
	
	
}
