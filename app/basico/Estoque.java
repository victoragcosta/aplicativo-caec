package basico;

import basico.AcessoBDProdutos;
import java.util.ArrayList;
import java.io.*;

public class Estoque {
	//7 Bebidas, 12 Snacks, 8 Outros
	public int quantBebidas = 0,
			quantSnacks = 0,
			quantOutros = 0;
	public Produto[] bebidas = new Produto[9];
	public Produto[] snacks = new Produto[18];
	public Produto[] outros = new Produto[9];
	private AcessoBDProdutos produtos = new AcessoBDProdutos();
	
	public Estoque(){
		System.out.println("Faz o Urro");
		this.atualizarProdutos();
	}
	
	public void atualizarProdutos(){
		produtos.readProdutos();
		bebidas = (Produto[]) produtos.getBebidas().toArray();
		snacks = (Produto[]) produtos.getSnacks().toArray();
		outros = (Produto[]) produtos.getOutros().toArray();
		quantBebidas = produtos.getBebidas().size();
		quantSnacks = produtos.getSnacks().size();
		quantOutros = produtos.getOutros().size();
	}
	
	public void atualizarValores(){
		this.atualizarProdutos();
	}
	
	public void vendeEstoque(){
		int i;
		ArrayList<Produto> temp = new ArrayList<Produto>();
		for(i = 0; i < quantBebidas; i++){
			temp.add(this.bebidas[i]);
		}
		produtos.setBebidas(temp);
		temp.clear();
		for(i = 0; i < quantSnacks; i++){
			temp.add(this.snacks[i]);
		}
		produtos.setSnacks(temp);
		temp.clear();
		for(i = 0; i < quantOutros; i++){
			temp.add(this.outros[i]);
		}
		produtos.setOutros(temp);
		produtos.writeProdutos();
	}

}
