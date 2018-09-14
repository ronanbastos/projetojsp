package br.com.aula15.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import br.com.aula15.dao.ClienteDao;
import br.com.aula15.entidade.Cliente;
import br.com.aula15.dao.AdminDao;
import br.com.aula15.entidade.Admin;
import java.util.*;
import java.sql.*;

@WebServlet(name="/ControleCliente",urlPatterns= {"/cadastrarcliente.html",
		"/buscarcliente.html","/clienteconsultado.html","/editarcliente.html",
		"/confirmarcliente.html","/excluircliente.html","/logarcliente.html"})
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarcliente(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarcliente(request,response);
	}
	protected void executarcliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/cadastrarcliente.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarcliente.html")) {
				editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarcliente.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/clienteconsut.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarcliente.html")) {
				confirmar(request, response);
			}else if (url.equalsIgnoreCase("/excluircliente.html")) {
				excluir(request, response);
			}else if (url.equalsIgnoreCase("/logarcliente.html")) {
				logar(request, response);
			}else {
			throw new Exception("URL Inválida!!!");
		}
	} catch (Exception e) {
		response.sendRedirect("index.jsp");
		e.printStackTrace();
	}
	
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Pegando os parâmetros passados pelo formulário
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");

		// Instanciando um Objeto do tipo Cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);// Instanciando um Objeto do tipo ClienteDao
		
		try {
			ClienteDao dao = new ClienteDao();
			dao.adicionar(cliente);
			request.getRequestDispatcher("adicionarcliente.jsp").forward(request, response);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
	
	public void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String cpf = request.getParameter("cpf");
			ClienteDao pd = new ClienteDao();
			//Cliente cliente=new Cliente();

			List<Cliente> lista = pd.listarCliente(cpf);
			
			request.setAttribute("cpf", cpf); //Aqui é variável. Isso
			request.setAttribute("listaCliente", lista);
			request.getRequestDispatcher("consultarcliente.jsp").forward(request, response);
			//Vai passar os dados da lista para o editaCliente.jsp ok
			//Peraí...
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Capturando o Id do Cliente vindo do formulário
			
			String cpf = request.getParameter("cpf");
			Cliente cliente = new ClienteDao().buscarCliente(cpf);		
				request.setAttribute("cliente", cliente);
				//request.getSession().setAttribute("cliente", cliente);
				request.getRequestDispatcher("editaCliente.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getRequestDispatcher("buscarcliente.jsp").forward(request, response);
		}
	}
	
public void confirmar(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	try {

		// Pegando os parâmetros passados pelo formulário
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");
		//long idCliente = Long.parseLong(request.getParameter("idcliente"));
		

		// Instanciando um Objeto do tipo Cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);// Instanciando um Objeto do tipo ClienteDao
		//cliente.setIdCliente(new Integer(idCliente));

		// Gravando os dados no Banco de Dados

		ClienteDao pd = new ClienteDao();
		pd.editar(cliente);
		request.getSession().setAttribute("cliente", cliente);
		//HttpSession sessao=request.getSession();
		//sessao.setAttribute("nome",nome);
		
		request.getRequestDispatcher("editarcliente.jsp").forward(request, response);
		

	} catch (Exception e) {
		e.printStackTrace();
		
	} finally {
		request.getRequestDispatcher("buscarcliente.jsp").forward(request, response);
	}

}

protected void excluir(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// Pegando os parâmetros passados pelo formulário
	String cpf = request.getParameter("cpf");

	// Instanciando um Objeto do tipo Cliente
	Cliente cliente = new Cliente();
	cliente.setCpf(cpf);

	// Instanciando um Objeto do tipo ClienteDao
	try {
		ClienteDao dao = new ClienteDao();
		dao.excluir(cliente);
		
		request.getRequestDispatcher("buscarcliente.jsp").forward(request, response);


	} catch (Exception e) {
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

	} 
}
protected void logar(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, ClassNotFoundException, SQLException {
	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	int nivel=Integer.parseInt(request.getParameter("nivel"));
	//String admin = "admin";
	Cliente cliente = new ClienteDao().login(login, senha, nivel);
	Admin admin = new AdminDao().consultarLoginSenha(login, senha,nivel);

	if (admin != null) {

		request.getSession().setAttribute("admin", admin);
		request.getSession().setAttribute("login", login);
		request.getRequestDispatcher("sessaoadmin.jsp").forward(request, response);
	} else {

		try {

			if (cliente != null) {					
				
				request.getSession().setAttribute("cliente", cliente);
				request.getSession().setAttribute("login", login);					
				response.sendRedirect("sessaocliente.jsp");
			} else {
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			//request.setAttribute("msg", "Erro" + e.getMessage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
}
