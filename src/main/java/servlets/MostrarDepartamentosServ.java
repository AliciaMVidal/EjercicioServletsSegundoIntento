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

/**
 * Servlet implementation class MostrarDepartamentosServ
 */
@WebServlet("/MostrarDepartamentosServ")
public class MostrarDepartamentosServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarDepartamentosServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// response.getWriter().append("asdasd");
		PrintWriter out = response.getWriter();
		Map<String, String[]> parameterMap = request.getParameterMap();
		printResponse(out, parameterMap);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

private PrintWriter printResponse(PrintWriter out, Map<String, String[]> parameterMap) {
		
		PrintWriter res = out;
		
//		res.println("<html>");
//		res.println("<title>Servlet de pruebas :)</title>");
//		res.println("<body>");
//		res.println("<div>Hola Mundo (desde " + this.getClass().getSimpleName() +")</div>");
//		parameterMap.keySet().forEach(x -> res.println("<div>Parámetro " + x + " = " + String.join(",", parameterMap.get(x)) +"</div>"));
//		res.println("</body>");
//		res.println("</html>");
		DepartamentoDAO depdao = new DepartamentoDAO();
		//DepartamentoControlador depcont = new DepartamentoControlador();
		HashMap<Integer, Departamento> listado;
		listado= depdao.getTodosDepartamentosQuery();
		
		
		res.print("<html><body>");
		
		res.print("<table border='1'");
		res.print("<tr><th>Codigo</TH><TH>nombre</TH><TH>cod_responsable</TH></TR>");
		for (Map.Entry<Integer, Departamento> entry : listado.entrySet())
	        {
			Departamento val = entry.getValue();
	        	res.print("<tr><td>"+val.getCodigo()+"</td><td>"+val.getNombre()+"</td><td>"+val.getCodResponsable()+"</td>");  
	        }
	    
	        res.print("</table>");
	        res.print("</body></html>");
		
		return res;
	}

}
