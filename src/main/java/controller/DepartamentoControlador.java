package controller;

import java.util.HashMap;
import java.util.Map;

import modelo.Departamento;


public class DepartamentoControlador {

	public void verTodosRegistros(HashMap<Integer, Departamento> listado) {
		for (Map.Entry<Integer, Departamento> entry : listado.entrySet()) {
			Departamento val = entry.getValue();
			System.out.println(val.getCodigo());
			System.out.println(val.toString());

		}
	}
}
