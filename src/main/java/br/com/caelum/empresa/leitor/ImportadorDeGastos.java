package br.com.caelum.empresa.leitor;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

public class ImportadorDeGastos {

	private SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");

	public Set<Gasto> importa(InputStream entrada) throws ParseException {
		Scanner leitor = new Scanner(entrada);
		Set<Gasto> gastos = new LinkedHashSet<Gasto>();

		while (leitor.hasNextLine()) {
			String line = leitor.nextLine();
			String tipoDeGasto = line.substring(0, 6);
			String dataGastoTxt = line.substring(6, 14);
			String valorTxt = line.substring(14, 23);
			String matriculaTxt = line.substring(23, 26);
			String nome = line.substring(26, 56);
			String dataNascTxt = line.substring(56);
			
			double valor = Double.parseDouble(valorTxt);
			int matricula = Integer.parseInt(matriculaTxt);
			
			Calendar dataNascimento = converteDataTxtParaCalendar(dataNascTxt);

			Calendar dataDespesa = converteDataTxtParaCalendar(dataGastoTxt);
			
			Funcionario funcionario = new Funcionario(nome, matricula,
					dataNascimento);
			gastos.add(new Gasto(valor, tipoDeGasto, funcionario, dataDespesa));
		}
		return gastos;
	}

	private Calendar converteDataTxtParaCalendar(String dataNascTxt)
			throws ParseException {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(df.parse(dataNascTxt));
		return dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((df == null) ? 0 : df.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportadorDeGastos other = (ImportadorDeGastos) obj;
		if (df == null) {
			if (other.df != null)
				return false;
		} else if (!df.equals(other.df))
			return false;
		return true;
	}
}
