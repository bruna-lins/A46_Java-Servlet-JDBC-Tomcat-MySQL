package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans destino = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		/* navegação */
		if (action.equals("/main")) {
			listarDestinos(request, response);
		} else if (action.equals("/insert")) {
			adicionarDestino(request, response);
		} else if (action.equals("/select")) {
			listarDestino(request, response);
		} else if (action.equals("/update")) {
			editarDestino(request, response);
		} else if (action.equals("/delete")) {
			removerDestino(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// Listar Destinos
	protected void listarDestinos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		ArrayList<JavaBeans> lista = dao.listarDestinos();


		request.setAttribute("destinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("destinos.jsp");
		rd.forward(request, response);
	}

	// Adicionar Destino

	protected void adicionarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		destino.setNome(request.getParameter("name"));
		destino.setDescricao(request.getParameter("description"));
		destino.setValor(Integer.parseInt(request.getParameter("price")));
		destino.setImage(request.getParameter("image"));


		dao.inserirDestino(destino);

		response.sendRedirect("main");

	}

	// Editar Destino

	// método para selecionar o contato exato a ser editado
	protected void listarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		destino.setId_dest(Integer.parseInt(request.getParameter("Id_dest")));

		dao.selecionarDestino(destino);


		request.setAttribute("id_dest", destino.getId_dest());
		request.setAttribute("name", destino.getNome());
		request.setAttribute("description", destino.getDescricao());
		request.setAttribute("valor", destino.getDescricao());
		request.setAttribute("image", destino.getImage());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	// método para edição efetiva do contato
	protected void editarDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		destino.setId_dest(Integer.parseInt(request.getParameter("id_dest")));
		destino.setNome(request.getParameter("name"));
		destino.setDescricao(request.getParameter("description"));
		destino.setValor(Integer.parseInt(request.getParameter("price")));
		destino.setImage(request.getParameter("image"));

		dao.alterarDestino(destino);

		response.sendRedirect("main");

	}

	// Remover Destino

	protected void removerDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		destino.setId_dest(Integer.parseInt(request.getParameter("Id_dest")));

		dao.deletarDestino(destino);

		response.sendRedirect("main");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
