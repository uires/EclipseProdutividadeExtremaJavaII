package br.com.caelum.empresa.leitor;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import br.com.caelum.empresa.dao.Gasto;

public class ImportadorDeGastosTest {

	@Test
	public void deveRetornarListaVaziaSeOArquivoForVazio() throws ParseException {
		String conteudo = "CARTAOx1012011000010000123jbjasbd jbjbbb                22071983\r\n";
		ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
		
		ImportadorDeGastos gastos = new ImportadorDeGastos();
		Collection<Gasto> lista = new ArrayList<Gasto>();
		
		assertTrue("A lista não está vazia",lista.isEmpty());
		
	}
	
	@Test
	public void deveRetonarUmGastoDeUmArquivo() throws ParseException {
		String conteudo = "CARTAOx1012011000010000123jbjasbd jbjbbb                22071983\r\n";

		ByteArrayInputStream input = new ByteArrayInputStream(conteudo.getBytes());
		
		ImportadorDeGastos gastos = new ImportadorDeGastos();
		Collection<Gasto> lista = (Collection<Gasto>) gastos;
		
		assertTrue("A lista não está vazia",lista.isEmpty());
		
	}
}