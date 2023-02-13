package Dao.porder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DbConnection;
import Model.porder;

public class implPorder  implements porderDao{

	public static void main(String[] args) {
		porder p=new porder("B桌",4,4,4);
		new implPorder().add(p);
		//System.out.println(new implPorder().queryAll());
		//System.out.println(new implPorder().querySum(500, 1000));
		//System.out.println(new implPorder().queryId(9));
		/*porder p=new implPorder().queryId(5);
		p.setDesk("E桌");
		p.setA(8);
		
		new implPorder().update(p);*/
		//new implPorder().delete(5);
	}

	@Override
	public void add(porder p) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into porder(desk,A,B,C,sum) "
				+ "values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<porder> queryAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from porder";
		List<porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				porder p=new porder();
				
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<porder> querySum(int start, int end) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from porder where sum>=? and sum<=?";
		List<porder> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				porder p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
				
				l.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public porder queryId(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select *from porder where id=?";
		
		porder p=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
				p.setSum(rs.getInt("sum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void update(porder p) {
		Connection conn=DbConnection.getDb();
		String SQL="update porder set desk=?,A=?,B=?,C=?,sum=? "
				+ "where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getSum());
			ps.setInt(6, p.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
