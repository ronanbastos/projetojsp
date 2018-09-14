package br.com.aula15.entidade;

public class Cliente {

	private int idcliente;
		private String nome;
		private String email;
		private String telefone;
		private String login;
		private String senha;
		private String cpf; 

		public Cliente() {

		}
		
		public Cliente(String login, String senha) {
			this.login = login;
			this.senha = senha;
		}

		public Cliente(int idcliente, String nome, String email, String telefone,String login, String senha, String cpf) {
			super();
			this.idcliente = idcliente;
			this.nome = nome;
			this.email = email;
			this.telefone = telefone;
			this.login = login;
			this.senha = senha;
			this.cpf = cpf;
		}

		

		public int getIdcliente() {
			return idcliente;
		}

		public void setIdcliente(int idcliente) {
			this.idcliente = idcliente;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
}
