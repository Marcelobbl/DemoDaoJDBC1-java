package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoImplJDBC implements DepartamentoDao {

	private Connection connection;

	public DepartamentoDaoImplJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNomeDep());

			int linhasGravadas = st.executeUpdate();
			if (linhasGravadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);

			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Departamento obj) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE Id = ?");
			st.setString(1, obj.getNomeDep());
			st.setInt(2, obj.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("DELETE FROM department WHERE Id = ?");
			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Departamento consultaId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("SELECT * FROM department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("Id"));
				dep.setNomeDep(rs.getString("Name"));
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Departamento> consultaTudo() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = connection.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();
			List<Departamento> list = new ArrayList<>();
			while (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("Id"));
				dep.setNomeDep(rs.getString("Name"));
				list.add(dep);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

}
