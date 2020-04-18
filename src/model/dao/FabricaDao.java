package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDaoImplJDBC;
import model.dao.impl.VendedorDaoImplJDBC;

public class FabricaDao {
	
	public static VendedorDao criaVendedorDao() {
		return new VendedorDaoImplJDBC(DB.getConnection());
	}
	
	public static DepartamentoDao createDepartmentDao() {
		return new DepartamentoDaoImplJDBC(DB.getConnection());
	}

}
