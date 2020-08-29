package com.zomentum.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.zomentum.hsql.HsqlDatabase;

@Service
public class LoginService {
	public boolean validateUser(String email, String password) throws SQLException, ClassNotFoundException {
		HsqlDatabase db = new HsqlDatabase();
		Statement st = db.conn.createStatement();
		String query = "SELECT * FROM Data WHERE EMAIL = '" + email +"' ";
		System.out.println("Executing the Query now");
		ResultSet rs = st.executeQuery(query);
		System.out.println("Query Executed");
		if(rs.next() == false) {
			return false;
		}
		else {
			if(rs.getString(3).equalsIgnoreCase(password)) {
				return true;
			}
			else {
				return false;
			}
		}
	}

}