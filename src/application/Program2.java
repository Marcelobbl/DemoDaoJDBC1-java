package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentoDao departamentoDao = FabricaDao.createDepartmentDao();
		
		System.out.println("===Test 1: departamento");
		
		Departamento departamento = new Departamento(5, "Celular");
		departamentoDao.insert(departamento);
		System.out.println("Inserido! Novo id = " + departamento.getId());
		
		System.out.println("===Test 2: Upadate id:");
		Departamento dep = departamentoDao.consultaId(1);
		dep.setNomeDep("Anel");
		departamentoDao.update(dep);
		System.out.println(dep);
		
		System.out.println("===Test 3: Delete id:");
		System.out.println("Digite o numero do id para deletar");
		int numeroId = sc.nextInt();
		departamentoDao.delete(numeroId);
		System.out.println("Departamento deletado");
		
		System.out.println("===Test 4: consulta id:");
		dep = departamentoDao.consultaId(2);
		System.out.println(dep);
		
		System.out.println("===Test 5: consulta tudo:");
		List<Departamento> list = new ArrayList<>();
		list = departamentoDao.consultaTudo();
		for(Departamento depList : list) {
			System.out.println(depList);
		}
		
			
		
				
		
		
		
		
		
		

		
		sc.close();
	}

}
