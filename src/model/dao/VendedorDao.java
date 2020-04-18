package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {

	void insert(Vendedor obj);
	void update(Vendedor obj);
	void delete(Integer id);
	Vendedor consultaId(Integer id);
	List<Vendedor> consultaTudo();
	List<Vendedor> buscaPorDepartamento(Departamento departamento);

}
