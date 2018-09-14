package br.com.aula9.controle;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula9.DAO.ClienteDao;
import br.com.aula9.entidade.Cliente;

@WebServlet("/ControleCliente")
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControleCliente() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executar(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		executar(request, response);
	}
	//construir o método que chama o formulário HTML ou JSP
	private void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/adicionacliente.jsp").forward(request, response);
		cadastrar(request,response);
	}
	public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//pegar os dados do formulário
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String telefone=request.getParameter("telefone");
		String login=request.getParameter("login");
		String senha=request.getParameter("senha");
		String cpf=request.getParameter("cpf");
		
		//instanciar o objeto
		Cliente cliente=new Cliente();
		
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setLogin(login);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);		
		//instanciar o DAO
		try{
		ClienteDao dao=new ClienteDao();
		dao.adicionar(cliente);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
