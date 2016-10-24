package basico;

import java.io.*;
import java.util.ArrayList;

import basico.Produto;
import basico.TipoProduto;

public class AcessoBDProdutos {
	private ArrayList<Produto> bebidas = new ArrayList<Produto>();
	private ArrayList<Produto> snacks = new ArrayList<Produto>();
	private ArrayList<Produto> outros = new ArrayList<Produto>();
	
	private String nomeArquivo = "texto.txt";
	private BufferedReader leitor;
	private BufferedWriter escritor;
	
	public void readProdutos(){
		File listaProdutos = new File(nomeArquivo);
		try{
			leitor = new BufferedReader(new FileReader(listaProdutos));
			
			bebidas.clear();
			snacks.clear();
			outros.clear();
			
			String informacaoProduto = leitor.readLine();
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				String nome = produtoTemp[0];
				double preco = Double.parseDouble(produtoTemp[1]);
				int quant = Integer.parseInt(produtoTemp[2]);
				if(produtoTemp[3].equals("bebida")){
					bebidas.add(new Produto(nome, preco, quant, TipoProduto.bebida));
				}
				else if(produtoTemp[3].equals("snack")){
					snacks.add(new Produto(nome, preco, quant, TipoProduto.snack));
				}
				
				else if(produtoTemp[3].equals("outro")){
					outros.add(new Produto(nome, preco, quant, TipoProduto.outro));
				}
				informacaoProduto = leitor.readLine();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Couldn't Find File");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("IO Error");
			System.exit(0);
		}
		finally{
			//limpa recursos
			if(leitor != null){
				try{
					leitor.close();
				}
				catch(IOException e){
					System.out.println("IO Error");
					System.exit(0);
				}
			}
		}
	}
	
	public void writeProdutos(){
		int nBebidas = 0, 
			nSnacks = 0,
			nOutros = 0;
		File listaProdutos = new File(nomeArquivo);
		try{
			escritor = new BufferedWriter(new FileWriter(listaProdutos));
			String nome, preco, quant, tipo;
			Produto produto;
			
			tipo = "bebida";
			while(nBebidas < bebidas.size()){
				produto = bebidas.get(nBebidas);
				nome = produto.getNome();
				preco = Double.toString(produto.getPreco());
				quant = Integer.toString(produto.getQuantidade());
				escritor.write(nome+", "+preco+", "+quant+", "+tipo);
				escritor.newLine();
				nBebidas++;
			}
			tipo = "snack";
			while(nSnacks < snacks.size()){
				produto = snacks.get(nSnacks);
				nome = produto.getNome();
				preco = Double.toString(produto.getPreco());
				quant = Integer.toString(produto.getQuantidade());
				escritor.write(nome+", "+preco+", "+quant+", "+tipo);
				escritor.newLine();
				nSnacks++;
			}
			tipo = "outro";
			while(nOutros < outros.size()){
				produto = outros.get(nOutros);
				nome = produto.getNome();
				preco = Double.toString(produto.getPreco());
				quant = Integer.toString(produto.getQuantidade());
				escritor.write(nome+", "+preco+", "+quant+", "+tipo);
				escritor.newLine();
				nOutros++;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Couldn't Find File");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("IO Error");
			System.exit(0);
		}
		finally{
			//limpa recursos
			if(escritor != null){
				try{
					escritor.close();
				}
				catch(IOException e){
					System.out.println("IO Error");
					System.exit(0);
				}
			}
		}
	}
	
	//Getters & Setters
	public ArrayList<Produto> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<Produto> bebidas) {
		this.bebidas.clear();
		for(int i = 0; i < bebidas.size(); i++){
			this.bebidas.add(bebidas.get(i));
		}
	}

	public ArrayList<Produto> getSnacks() {
		return snacks;
	}

	public void setSnacks(ArrayList<Produto> snacks) {
		this.snacks.clear();
		for(int i = 0; i < snacks.size(); i++){
			this.snacks.add(snacks.get(i));
		}
	}

	public ArrayList<Produto> getOutros() {
		return outros;
	}

	public void setOutros(ArrayList<Produto> outros) {
		this.outros.clear();
		for(int i = 0; i < outros.size(); i++){
			this.outros.add(outros.get(i));
		}
	}

}
