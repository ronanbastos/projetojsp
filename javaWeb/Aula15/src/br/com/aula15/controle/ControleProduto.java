package br.com.aula15.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula15.dao.ProdutoDao;
import br.com.aula15.entidade.Produto;


@WebServlet(name="/ControleProduto",urlPatterns = { "/cadastrarproduto.html","/buscarproduto.html",
		"/produtoconsultado.html","/confirmarproduto.html","/editarproduto.html","/excluirproduto.html"})

public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ControleProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarproduto(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarproduto(request,response);
	}
	protected void executarproduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/cadastrarproduto.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarproduto.html")) {
				editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarproduto.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/produtoconsultado.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarproduto.html")) {
				confirmar(request, response);
			}else if (url.equalsIgnoreCase("/excluirproduto.html")) {
				excluir(request, response);
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
		
		String nome = request.getParameter("nome");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		String fornecedor = request.getParameter("fornecedor");
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setQuantidade(quantidade);
		produto.setFornecedor(fornecedor);
		
		try {
			ProdutoDao dao = new ProdutoDao();
			dao.cadastrarproduto(produto);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
	
	public void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			ProdutoDao pd = new ProdutoDao();

			List<Produto> lista = pd.buscarproduto(nome);
            /*
			if (lista.size() == 0) {
				request.setAttribute("msg", "<div class='alert alert-info'>Nenhum Produto na lista!!!</div>");
			}*/
			request.setAttribute("nome", nome);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("produtoconsultado.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
					
					int idproduto = Integer.parseInt(request.getParameter("idproduto"));
					ProdutoDao pd = new ProdutoDao();
					Produto produto =  pd.buscarprodutoporid(new Integer(idproduto));
					
					
						request.setAttribute("produto", produto);
						request.getRequestDispatcher("editarproduto.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
					
					request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
				}
			}
		

public void confirmar(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	String nome = request.getParameter("nome");
	double valor = Double.parseDouble(request.getParameter("valor"));
	int quantidade = Integer.parseInt(request.getParameter("quantidade"));
	String fornecedor = request.getParameter("fornecedor");
	int idproduto = Integer.parseInt(request.getParameter("idproduto"));

	Produto produto = new Produto();
	
	produto.setNome(nome);
	produto.setValor(new Double(valor));
	produto.setQuantidade(new Integer(quantidade));		
	produto.setFornecedor(fornecedor);
	produto.setIdproduto(new Integer(idproduto));

	ProdutoDao pd = new ProdutoDao();
	try {
		pd.atualizarproduto(produto);
		
		request.getRequestDispatcher("editarproduto.jsp").forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
	}
}


public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String idproduto = request.getParameter("idproduto");
			ProdutoDao pd = new ProdutoDao();
			pd.excluirproduto(new Integer(idproduto));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
		}	
		
	}

}
