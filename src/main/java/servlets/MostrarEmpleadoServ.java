package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DepartamentoControlador;
import modelo.Departamento;
import modelo.DepartamentoDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;

/**
 * Servlet implementation class MostrarEmpleadoServ
 */
@WebServlet("/MostrarEmpleadoServ")
public class MostrarEmpleadoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarEmpleadoServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Map<String, String[]> parameterMap = request.getParameterMap();
		printResponse(out, parameterMap);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
private PrintWriter printResponse(PrintWriter out, Map<String, String[]> parameterMap) {
		
		PrintWriter res = out;

		EmpleadoDAO depdao = new EmpleadoDAO();
		HashMap<Integer, Empleado> listado;
		listado = depdao.getTodosEmpleadosQuery();
		
		
		res.print("<html><body>");
		
		res.print("<table border='1'");
		res.print("<tr><th>Codigo</TH><TH>nombre</TH><TH>apellido1</TH></TR>");
		for (Map.Entry<Integer, Empleado> entry : listado.entrySet())
	        {
			Empleado val = entry.getValue();
	        	res.print("<tr><td>"+val.getCodigo()+"</td><td>"+val.getNombre()+"</td><td>"+val.getApellido1()+"</td>");  
	        }
	    
	        res.print("</table>");
	        res.print("</body></html>");
		
		return res;
	}

}
