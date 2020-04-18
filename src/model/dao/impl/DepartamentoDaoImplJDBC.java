package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoImplJDBC implements DepartamentoDao{
	
	private Connection connection;

	public DepartamentoDaoImplJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("INSERT INTO department(Id, Name) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getId());
			st.setString(2, obj.getNomeDep());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Departamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento consultaId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> consultaTudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
