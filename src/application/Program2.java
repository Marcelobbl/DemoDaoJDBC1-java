package application;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = FabricaDao.createDepartmentDao();
		
		System.out.println("===Test 1: departamento");
		
		Departamento departamento = new Departamento(5, "Celular");
		departamentoDao.insert(departamento);
		System.out.println("Inserido! Novo id = " + departamento.getId());
		
		
		

	}

}
