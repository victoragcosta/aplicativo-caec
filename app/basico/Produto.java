package basico;


public class Produto {
	

	String nome;
	double preco;
	int quantidade;
	public TipoProduto tipo;
	
	public Produto(){
		this.preco = 0;
		this.quantidade = 0;
		this.tipo = null;
	}
	
	public Produto(String nome, double preco, int quant, TipoProduto tipo){
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quant;
		this.tipo = tipo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public void addQuantidade(int valor){
		this.quantidade += valor;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public void vendeProduto(int quant){
		if(this.quantidade > 0){
			this.quantidade -= quant;
		}
	}
	
}
