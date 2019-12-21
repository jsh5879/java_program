import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.core.compiler.InvalidInputException;

/**
 * Servlet implementation class WebCalculator
 */
@WebServlet("/WebCalculator")
public class WebCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebCalculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet (
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head><title>WebCalculator</title></head>");
		out.println(
				"<body><h2>HW13_201524561_WebCalculator</h2>"
						+ "<form method=\"get\">"
						+ "<p></p>"
						+ "Operand 1: "
						+ "<input type=\"text\" name=\"operand1\" size=\"10\">"
						+ "<br>"
						+ "Operand 2: "
						+ "<input type=\"text\" name=\"operand2\" size=\"10\">"
						+ "<p></p>"
						+ "<input type=\"submit\" name=\"action\" value=\"Add\">"
						+ "<br>"
						+ "<input type=\"submit\" name=\"action\" value=\"Subtract\">"
						+ "<br>"
						+ "<input type=\"submit\" name=\"action\" value=\"Multiply\">"
						+ "<br>"
						+ "<p></p>"
						+ "<input type=\"submit\" name=\"action\" value=\"Reset\">" 
						+ "</form>");
		String str1 = request.getParameter("operand1");
		String str2 = request.getParameter("operand2");
		String flag = request.getParameter("action");

		try {
			double num1 = Integer.parseInt(str1);
			double num2 = Integer.parseInt(str2);
			double sum = num1 + num2;
			double sub = num1 - num2;
			double mul = num1 * num2;


			if((flag != null) && (flag.equals("Add"))) {
				out.println("<H2> <B>Outcome: " + sum + "</B> </H2>");
			}
			else if((flag != null) && (flag.equals("Subtract"))) {
				out.println("<H2> <B>Outcome: " + sub + "</B> </H2>");
			}
			else if((flag != null) && (flag.equals("Multiply"))) {
				out.println("<H2> <B>Outcome: " + mul + "</B> </H2>");
			}
		}catch(NumberFormatException e) {
			try {
				throw new InvalidInputException();
			} catch (InvalidInputException e1) {
				e1.printStackTrace();
			}
		}
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
