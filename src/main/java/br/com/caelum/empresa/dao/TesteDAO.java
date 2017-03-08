package br.com.caelum.empresa.dao;

import java.util.*;


public class TesteDAO {
	public static void main(String[] args) {
		GastoDAO gastoDAO = new GastoDAO();
		List<Gasto> todos = gastoDAO.buscaTodos();
		
		for (Gasto gasto :todos) {
			System.out.println(gasto);
			
		}
		
		
	}
}
