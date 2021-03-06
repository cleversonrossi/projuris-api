package br.com.projuris.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.projuris.model.CustoCargo;
import br.com.projuris.model.CustoDepartamento;
import br.com.projuris.model.Funcionario;
import br.com.projuris.repository.Calculo;

public class TestaMyCalculo {
	
	public static void main(String[] args) {
		
		Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
		Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
		Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
		Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
		Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
		Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
		Funcionario funcionario7 = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
		Funcionario funcionario8 = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
		Funcionario funcionario9 = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
		Funcionario funcionario10 = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));
		
		List<Funcionario> listaFuncionario = new ArrayList<>();
		listaFuncionario.add(funcionario1);
		listaFuncionario.add(funcionario2);
		listaFuncionario.add(funcionario3);
		listaFuncionario.add(funcionario4);
		listaFuncionario.add(funcionario5);
		listaFuncionario.add(funcionario6);
		listaFuncionario.add(funcionario7);
		listaFuncionario.add(funcionario8);
		listaFuncionario.add(funcionario9);
		listaFuncionario.add(funcionario10);
		
		Calculo calculo = new MyCalculo();

		final List<CustoCargo> custoCargos = calculo.custoPorCargo(listaFuncionario);
		
		final List<CustoDepartamento> custoDepartamentos = calculo.custoPorDepartamento(listaFuncionario);

		for(CustoCargo custoCargo : custoCargos){
		    System.out.println("O custo total do cargo " +custoCargo.getCargo() +" é de R$ " +custoCargo.getCusto() );
		}
		
		System.out.println("=====================================================================================================================");
		
		for(CustoDepartamento custoDepartamento : custoDepartamentos){
		    System.out.println("O custo total do departamento " +custoDepartamento.getDepartamento() +" é de R$ " +custoDepartamento.getCusto() );
		} 
	}

}
