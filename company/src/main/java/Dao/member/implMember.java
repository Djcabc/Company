package Dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		member m=new member("dc","4567","dddc","台北","000","123");
		new implMember().add(m);
		
		//System.out.println(new implMember().selectAll());

		//System.out.println(new implMember().selectUser("ac", "1234"));
		
		//System.out.println(new implMember().selectUser("abc"));
	}

	@Override
	public void add(member m) {
		/*
		 * 1.先連線-->database
		 * 2.撰寫 SQL-->insert into-->?
		 * 3.PreparedStatement-->executeUpdate
		 */
		Connection conn=DbConnection.getDb();
		String SQL="insert into member(username,password,name,address,phone,mobile) "
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getMobile());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<member> selectAll() {
		/*
		 * 1.先連線
		 * 2.SQL-->select 全部
		 * 3.PreparedStatement-->ResultSet
		 * 4.打包成-->list陣列
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select *from member";
		List<member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				member m=new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setMobile(rs.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public member selectUser(String username, String password) {
		/*
		 * 1.先連線
		 * 2.SQL-->select-->where username 與 password
		 * 3.member-->預設-->null
		 * 4.preparedStatement--->ResultSet-->rs
		 * 5.rs.next()-->true--->rs-->new member
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where username=? and password=?";
		member m=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setMobile(rs.getString("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public boolean selectUser(String username) {
		/*
		 * 1.先連線
		 * 2.SQL-->select--->where username=?
		 * 3.Preparedstatement--->ReusltSet--->rs.next()
		 * 4.boolean x=false
		 * 5.rs.next()-->true-->x=true
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from member where username=?";
		boolean x=false;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) x=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}

	
	}


