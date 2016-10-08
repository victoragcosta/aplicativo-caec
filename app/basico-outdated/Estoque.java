package basico;

import java.io.*;

import basico.Produto;

public class Estoque {
	//7 Bebidas, 12 Snacks, 8 Outros
	public int quantBebidas = 0,
			quantSnacks = 0,
			quantOutros = 0;
	public Produto[] bebidas = new Produto[9];
	public Produto[] snacks = new Produto[18];
	public Produto[] outros = new Produto[9];
	BufferedReader leitor;
	BufferedWriter escritor;
	
	public Estoque(){
		
		File listaProdutos = new File("texto.txt");
		try{
			leitor = new BufferedReader(new FileReader(listaProdutos));
			String informacaoProduto = leitor.readLine();
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				double preco = Double.parseDouble(produtoTemp[1]);
				int quantidade = Integer.parseInt(produtoTemp[2]);
				if(produtoTemp[3].equals("bebida")){
					quantBebidas++;
					bebidas[quantBebidas-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.bebida);
				}
				
				if(produtoTemp[3].equals("snack")){
					quantSnacks++;
					snacks[quantSnacks-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.snack);
				}
				
				if(produtoTemp[3].equals("outro")){
					quantOutros++;
					outros[quantOutros-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.outro);
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
	}
	
	public void atualizarProdutos(){
		int qBebidas1 = 0,
		qSnacks1 = 0,
		qOutros1 = 0;
		File listaProdutos = new File("texto.txt");
		try{
			leitor = new BufferedReader(new FileReader(listaProdutos));
			String informacaoProduto = leitor.readLine();
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				double preco = Double.parseDouble(produtoTemp[1]);
				int quantidade = Integer.parseInt(produtoTemp[2]);
				if(produtoTemp[3].equals("bebida")){
					qBebidas1++;
					bebidas[qBebidas1-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.bebida);
				}
				
				if(produtoTemp[3].equals("snack")){
					qSnacks1++;
					snacks[qSnacks1-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.snack);
				}
				
				if(produtoTemp[3].equals("outro")){
					qOutros1++;
					outros[qOutros1-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.outro);
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
	}
	
	public void atualizarValores(){
		int qBebidas = 0,
				qSnacks = 0, 
				qOutros = 0;
		File listaProdutos = new File("texto.txt");
		try{
			leitor = new BufferedReader(new FileReader(listaProdutos));
			String informacaoProduto = leitor.readLine();
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				double preco = Double.parseDouble(produtoTemp[1]);
				int quantidade = Integer.parseInt(produtoTemp[2]);
				if(produtoTemp[3].equals("bebida")){
					qBebidas++;
					bebidas[qBebidas-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.bebida);
				}
				
				if(produtoTemp[3].equals("snack")){
					qSnacks++;
					snacks[qSnacks-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.snack);
				}
				
				if(produtoTemp[3].equals("outro")){
					qOutros++;
					outros[qOutros-1] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.outro);
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
	}
	
	public void vendeEstoque(){
		
		String listaTemp = new String();
		//String listaRel = new String();
		
		try{
			File arquivoProdutos = new File("texto.txt");
			//File arquivoTemp = new File("textoTemp.txt");
			//File arquivoRel = new File("Relatorio.txt");
			
			leitor = new BufferedReader(new FileReader(arquivoProdutos));
			
			int percorre = 0;
			String informacaoProduto = leitor.readLine();
			String informacaoAtualizada;
			String preco;
			String quantidade;
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				
				if(produtoTemp[3].equals("bebida")){
					preco = String.valueOf(bebidas[percorre].getPreco());
					quantidade = String.valueOf(bebidas[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", bebida");
					listaTemp += (informacaoAtualizada + "\n");

					percorre++;
					if(percorre == quantBebidas-1){
						percorre = 0;
					}
				}
				
				else if(produtoTemp[3].equals("snack")){
					preco = String.valueOf(snacks[percorre].getPreco());
					quantidade = String.valueOf(snacks[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", snack");
					listaTemp += (informacaoAtualizada + "\n");
					percorre++;
					if(percorre == quantSnacks-1){
						percorre = 0;
					}
				}
				
				else if(produtoTemp[3].equals("outro")){
					preco = String.valueOf(outros[percorre].getPreco());
					quantidade = String.valueOf(outros[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", outro");
					listaTemp += (informacaoAtualizada + "\n");
					percorre++;
					if(percorre == quantOutros-1){
						percorre = 0;
					}
				}
				informacaoProduto = leitor.readLine();
				
			}
			try (Writer escritor = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(arquivoProdutos)))) {
				escritor.write(listaTemp);
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
	}

}
