package br.com.aula15.entidade;

public class Produto {
	//declara as visibilidades e os tipos das vari�veis
private int idproduto;
private String nome;
private double valor;
private int quantidade;
private String fornecedor;

//constr�i o m�todo construtor

public Produto() {
	
}
//constr�i o m�todo construtor com seus objetos encapsulados = this
public Produto(int idproduto,String nome,double valor, int quantidade,
		String fornecedor) {
	super(); //herdar as informa��es da Servlet
	this.idproduto=idproduto;
	this.nome=nome;
	this.valor=valor;
	this.quantidade=quantidade;
	this.fornecedor=fornecedor;	
}
 // criar os m�todos set e get

public int getIdproduto() {
	return idproduto;
}
public void setIdproduto(int idproduto) {
	this.idproduto = idproduto;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public String getFornecedor() {
	return fornecedor;
}
public void setFornecedor(String fornecedor) {
	this.fornecedor = fornecedor;
}
}





