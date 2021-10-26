package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import conexion.Conexion;


public class DepartamentoDAO {

	private Connection conexion;
	 public HashMap<Integer, Departamento> getTodosDepartamentosQuery() {

	        conexion = Conexion.getConexion();
	        Departamento departamento;
	        HashMap<Integer, Departamento> listaDepartamentos = null;
	        if (conexion != null) {
	        	listaDepartamentos = new HashMap<>();
	            try {
	                PreparedStatement ps = conexion.prepareStatement("select * from departamento");

	                ResultSet resultado = ps.executeQuery();

	                while (resultado.next()) {
	                	departamento = new Departamento();
	                	departamento.setCodigo(resultado.getInt("codigo"));
	                	departamento.setNombre(resultado.getString("nombre"));
	                	departamento.setCodResponsable(resultado.getInt("cod_responsable"));
	                	listaDepartamentos.put(departamento.getCodigo(), departamento);
	                }
	                
	                resultado.close();
	                ps.close();

	            } catch (SQLException ex) {
	                System.out.println("Error en SQL en el metodo devolver todos los usuario");
	            } 

	        }
	        return listaDepartamentos;

	    }
}
