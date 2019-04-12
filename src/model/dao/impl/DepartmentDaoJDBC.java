package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn)
	{
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?;");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next())
			{
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				return dep;
			}else 
			{
				return null;
			}
		}
		catch(SQLException e)
		{
			throw new DbException(e.getMessage());
		}
		finally
		{
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department obj = new Department();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		return obj;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			st = conn.prepareStatement("SELECT * FROM department;");
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			
			while(rs.next())
			{
				Department dep = map.get(rs.getInt("Id"));
				
				if(dep == null)
				{
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("Id"), dep);
				}
				
				list.add(dep);
				
			}
			return list;
		}
		catch(SQLException e)
		{
			throw new DbException(e.getMessage());
		}
		finally
		{
			DB.closeResultSet(rs);
			DB.closeStatment(st);
		}
	}
}
