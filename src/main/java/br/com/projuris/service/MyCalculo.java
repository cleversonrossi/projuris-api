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

		List<CustoCargo> listCargoAux = new ArrayList<CustoCargo>();
		List<CustoCargo> listCargos = new ArrayList<CustoCargo>();

		List<Funcionario> listCargoAssistente = new ArrayList<>();
		List<Funcionario> listCargoGerente = new ArrayList<>();
		List<Funcionario> listCargoDiretor = new ArrayList<>();
		List<Funcionario> listCargoEstagiario = new ArrayList<>();

		double valorCargoAssistenteAux = 0.00;
		BigDecimal valorCargoAssistente = new BigDecimal(0.00);

		double valorCargoGerenteAux = 0.00;
		BigDecimal valorCargoGerente = new BigDecimal(0.00);

		double valorCargoDiretorAux = 0.00;
		BigDecimal valorCargoDiretor = new BigDecimal(0.00);

		double valorCargEstagiarioAux = 0.00;
		BigDecimal valorCargooEstagiario = new BigDecimal(0.00);

		int contAssistente = 0;
		int contGerente = 0;
		int contDiretor = 0;
		int contEstagiario = 0;

		// Agrupa por cargo
		for (Funcionario assistente : funcionarios) {
			if (assistente.getCargo().equals("Assistente")) {
				listCargoAssistente.add(assistente);
				listCargoAux.add(new CustoCargo(assistente.getCargo(), assistente.getSalario()));
			}
		}
		for (Funcionario gerente : funcionarios) {
			if (gerente.getCargo().equals("Gerente")) {
				listCargoGerente.add(gerente);
				listCargoAux.add(new CustoCargo(gerente.getCargo(), gerente.getSalario()));
			}
		}
		for (Funcionario diretor : funcionarios) {
			if (diretor.getCargo().equals("Diretor")) {
				listCargoDiretor.add(diretor);
				listCargoAux.add(new CustoCargo(diretor.getCargo(), diretor.getSalario()));
			}
		}
		for (Funcionario estagiario : funcionarios) {
			if (estagiario.getCargo().equals("Estagiário")) {
				listCargoEstagiario.add(estagiario);
				listCargoAux.add(new CustoCargo(estagiario.getCargo(), estagiario.getSalario()));
			}
		}

		// Soma os salarios da cada cargo
		for (Funcionario cargoAssistente : listCargoAssistente) {
			valorCargoAssistenteAux = valorCargoAssistenteAux + cargoAssistente.getSalario().doubleValue();
			valorCargoAssistente = new BigDecimal(valorCargoAssistenteAux);
			valorCargoAssistente = valorCargoAssistente.setScale(2, RoundingMode.HALF_UP);
		}
		for (Funcionario cargoGerente : listCargoGerente) {
			valorCargoGerenteAux = valorCargoGerenteAux + cargoGerente.getSalario().doubleValue();
			valorCargoGerente = new BigDecimal(valorCargoGerenteAux);
			valorCargoGerente = valorCargoGerente.setScale(2, RoundingMode.HALF_UP);
		}
		for (Funcionario cargoDiretor : listCargoDiretor) {
			valorCargoDiretorAux = valorCargoDiretorAux + cargoDiretor.getSalario().doubleValue();
			valorCargoDiretor = new BigDecimal(valorCargoDiretorAux);
			valorCargoDiretor = valorCargoDiretor.setScale(2, RoundingMode.HALF_UP);
		}
		for (Funcionario cargoEstagiario : listCargoEstagiario) {
			valorCargEstagiarioAux = valorCargEstagiarioAux + cargoEstagiario.getSalario().doubleValue();
			valorCargooEstagiario = new BigDecimal(valorCargEstagiarioAux);
			valorCargooEstagiario = valorCargooEstagiario.setScale(2, RoundingMode.HALF_UP);
		}

		// Adicionaar na lista
		for (CustoCargo listCargo : listCargoAux) {
			if (listCargo.getCargo().equals("Assistente") && contAssistente == 0) {
				listCargo.setCusto(valorCargoAssistente);

				listCargos.add(listCargo);
				contAssistente++;
			}
			if (listCargo.getCargo().equals("Gerente") && contGerente == 0) {
				listCargo.setCusto(valorCargoGerente);

				listCargos.add(listCargo);
				contGerente++;
			}
			if (listCargo.getCargo().equals("Diretor") && contDiretor == 0) {
				listCargo.setCusto(valorCargoDiretor);

				listCargos.add(listCargo);
				contDiretor++;
			}
			if (listCargo.getCargo().equals("Estagiário") && contEstagiario == 0) {
				listCargo.setCusto(valorCargooEstagiario);

				listCargos.add(listCargo);
				contEstagiario++;
			}
		}

		return listCargos;
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {

		List<CustoDepartamento> listDepartamentosAux = new ArrayList<CustoDepartamento>();
		List<CustoDepartamento> listDepartamentos = new ArrayList<CustoDepartamento>();

		List<Funcionario> listDepartamentoAdministrativo = new ArrayList<>();
		List<Funcionario> listDepartamentoFinanceiro = new ArrayList<>();
		List<Funcionario> listDepartaentoJuridico = new ArrayList<>();

		double valorDepartamentoAdministrativoAux = 0.00;
		BigDecimal valorDepartamentoAdministrativo = new BigDecimal(0.00);

		double valorDepartamentoFinanceiroAux = 0.00;
		BigDecimal valorDepartamentoFinanceiro = new BigDecimal(0.00);

		double valorDepartaentoJurídicoAux = 0.00;
		BigDecimal valorDepartaentoJuridico = new BigDecimal(0.00);

		int contAdministrativo = 0;
		int contFinanceiro = 0;
		int contJuridico = 0;

		// Agrupa por departamento
		for (Funcionario administrativo : funcionarios) {
			if (administrativo.getDepartamento().equals("Administrativo")) {
				listDepartamentoAdministrativo.add(administrativo);
				listDepartamentosAux.add(new CustoDepartamento(administrativo.getDepartamento(), administrativo.getSalario()));
			}
		}
		for (Funcionario financeiro : funcionarios) {
			if (financeiro.getDepartamento().equals("Financeiro")) {
				listDepartamentoFinanceiro.add(financeiro);
				listDepartamentosAux.add(new CustoDepartamento(financeiro.getDepartamento(), financeiro.getSalario()));
			}
		}
		for (Funcionario juridico : funcionarios) {
			if (juridico.getDepartamento().equals("Jurídico")) {
				listDepartaentoJuridico.add(juridico);
				listDepartamentosAux.add(new CustoDepartamento(juridico.getDepartamento(), juridico.getSalario()));
			}
		}

		// Soma os salarios da cada departamento
		for (Funcionario departamentoAdministrativo : listDepartamentoAdministrativo) {
			valorDepartamentoAdministrativoAux = valorDepartamentoAdministrativoAux + departamentoAdministrativo.getSalario().doubleValue();
			valorDepartamentoAdministrativo = new BigDecimal(valorDepartamentoAdministrativoAux);
			valorDepartamentoAdministrativo = valorDepartamentoAdministrativo.setScale(2, RoundingMode.HALF_UP);
		}
		for (Funcionario departamentoFinanceiro : listDepartamentoFinanceiro) {
			valorDepartamentoFinanceiroAux = valorDepartamentoFinanceiroAux + departamentoFinanceiro.getSalario().doubleValue();
			valorDepartamentoFinanceiro = new BigDecimal(valorDepartamentoFinanceiroAux);
			valorDepartamentoFinanceiro = valorDepartamentoFinanceiro.setScale(2, RoundingMode.HALF_UP);
		}
		for (Funcionario dpartaentoJuridico : listDepartaentoJuridico) {
			valorDepartaentoJurídicoAux = valorDepartaentoJurídicoAux + dpartaentoJuridico.getSalario().doubleValue();
			valorDepartaentoJuridico = new BigDecimal(valorDepartaentoJurídicoAux);
			valorDepartaentoJuridico = valorDepartaentoJuridico.setScale(2, RoundingMode.HALF_UP);
		}

		// Adicionaar na lista
		for (CustoDepartamento listDepartamento : listDepartamentosAux) {
			if (listDepartamento.getDepartamento().equals("Administrativo") && contAdministrativo == 0) {
				listDepartamento.setCusto(valorDepartamentoAdministrativo);

				listDepartamentos.add(listDepartamento);
				contAdministrativo++;
			}
			if (listDepartamento.getDepartamento().equals("Financeiro") && contFinanceiro == 0) {
				listDepartamento.setCusto(valorDepartamentoFinanceiro);

				listDepartamentos.add(listDepartamento);
				contFinanceiro++;
			}
			if (listDepartamento.getDepartamento().equals("Jurídico") && contJuridico == 0) {
				listDepartamento.setCusto(valorDepartaentoJuridico);

				listDepartamentos.add(listDepartamento);
				contJuridico++;
			}
		}

		return listDepartamentos;
	}

}
