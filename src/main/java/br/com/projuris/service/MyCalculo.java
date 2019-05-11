package br.com.projuris.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.projuris.model.CustoCargo;
import br.com.projuris.model.CustoDepartamento;
import br.com.projuris.model.Funcionario;
import br.com.projuris.repository.Calculo;

@Service
public class MyCalculo implements Calculo {

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		
		List<CustoCargo> listCargos = new ArrayList<CustoCargo>();
		
		List<Funcionario> listCargoAssistente = new ArrayList<>();
		List<Funcionario> listCargoGerente = new ArrayList<>();
		List<Funcionario> listCargoDiretor = new ArrayList<>();
		
		double valorCargoAssistenteAux = 0.00;
		BigDecimal valorCargoAssistente = new BigDecimal(0.00); 
		double valorCargoGerente = 0.00;
		double valorCargoDiretor = 0.00;
		
		double custoTotalCargoAux = 0.00;
		BigDecimal custoTotalCargo = new BigDecimal(0.00); 

		//Agrupa por cargo
		for(Funcionario assistente : funcionarios){ 
            if(assistente.getCargo().equals("Assistente")) {
            	listCargoAssistente.add(assistente);
            	listCargos.add(new CustoCargo( assistente.getCargo(), assistente.getSalario() ));
            }
		}
		for(Funcionario gerente : funcionarios){ 
            if(gerente.getCargo().equals("Gerente")) {
            	listCargoGerente.add(gerente);
            	listCargos.add(new CustoCargo( gerente.getCargo(), gerente.getSalario() ));
            }
		}
		for(Funcionario diretor : funcionarios){ 
            if(diretor.getCargo().equals("Diretor")) {
            	listCargoDiretor.add(diretor);
            	listCargos.add(new CustoCargo( diretor.getCargo(), diretor.getSalario() ));
            }
		}
    	
		//Soma os salarios da cada cargo
		for (Funcionario cargoAssistente: listCargoAssistente) {
			valorCargoAssistenteAux = valorCargoAssistenteAux + cargoAssistente.getSalario().doubleValue();
			valorCargoAssistente = new BigDecimal(valorCargoAssistenteAux);
		}		
		System.out.println(valorCargoAssistenteAux);
		for (Funcionario cargoGerente: listCargoGerente) {
			valorCargoGerente = valorCargoGerente + cargoGerente.getSalario().doubleValue();
		}
		System.out.println(valorCargoGerente);
		for (Funcionario cargoDiretor: listCargoDiretor) {
			valorCargoDiretor = valorCargoDiretor + cargoDiretor.getSalario().doubleValue();
		}
		System.out.println(valorCargoDiretor);
		
		custoTotalCargoAux = valorCargoAssistenteAux + valorCargoGerente + valorCargoDiretor;
		custoTotalCargo = new BigDecimal(custoTotalCargoAux);
		System.out.println("Custo total por cargo: " + custoTotalCargo);
		
		for(CustoCargo listCargo: listCargos) {
			if( listCargo.getCargo().equals("Assistente") ) {
				listCargo.setCusto(valorCargoAssistente);
			}
			listCargos.add(listCargo);
		}
			
		System.out.println("Custo total por cargo: " + listCargos);
		
		return listCargos;
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		// TODO Auto-generated method stub
		return null;
	}

}
