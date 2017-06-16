package com.choa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	public static void disConnect(PreparedStatement ps, Connection con){
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement ps, Connection con){
		try {
			rs.close();
			DBConnect.disConnect(ps, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
