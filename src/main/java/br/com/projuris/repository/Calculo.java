package br.com.projuris.repository;

import java.util.List;

import br.com.projuris.model.CustoCargo;
import br.com.projuris.model.CustoDepartamento;
import br.com.projuris.model.Funcionario;

public interface Calculo {

	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios);
	
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios);
	
}
