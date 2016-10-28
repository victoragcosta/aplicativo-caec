package basico;

import basico.AcessoBDProdutos;
import java.util.ArrayList;

public class Estoque {
	//7 Bebidas, 12 Snacks, 8 Outros
	public int quantBebidas = 0,
			quantSnacks = 0,
			quantOutros = 0;
	public Produto[] bebidas = new Produto[30];
	public Produto[] snacks = new Produto[30];
	public Produto[] outros = new Produto[30];
	private AcessoBDProdutos produtos = new AcessoBDProdutos();
	
	public Estoque(){
		System.out.println("Faz o Urro");
		this.atualizarProdutos();
	}
	
	public void atualizarProdutos(){
		produtos.readProdutos();
		ArrayList<Produto> tempArray = produtos.getBebidas();
		for(quantBebidas = 0; quantBebidas < tempArray.size(); quantBebidas++){
			bebidas[quantBebidas] = tempArray.get(quantBebidas);
		}
		quantBebidas = tempArray.size();
		tempArray = produtos.getSnacks();
		for(quantSnacks = 0; quantSnacks < tempArray.size(); quantSnacks++){
			snacks[quantSnacks] = tempArray.get(quantSnacks);
		}
		quantSnacks = tempArray.size();
		tempArray = produtos.getOutros();
		for(quantOutros = 0; quantOutros < tempArray.size(); quantOutros++){
			outros[quantOutros] = tempArray.get(quantOutros);
		}
		quantOutros = tempArray.size();
	}
	
	public void atualizarValores(){
		this.atualizarProdutos();
	}
	
	public void vendeEstoque(){
		int i;
		ArrayList<Produto> temp = new ArrayList<Produto>();
		for(i = 0; i < quantBebidas; i++){
			if(this.bebidas[i] != null)
				temp.add(this.bebidas[i]);
		}
		produtos.setBebidas(temp);
		temp.clear();
		for(i = 0; i < quantSnacks; i++){
			if(this.snacks[i] != null)
				temp.add(this.snacks[i]);
		}
		produtos.setSnacks(temp);
		temp.clear();
		for(i = 0; i < quantOutros; i++){
			if(this.outros[i] != null)
				temp.add(this.outros[i]);
		}
		produtos.setOutros(temp);
		produtos.writeProdutos();
	}
	
	public AcessoBDProdutos getAcesso(){
		return produtos;
	}

}
