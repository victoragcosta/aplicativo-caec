package examples;

import java.io.*;

import basico.Estoque;
import basico.Produto;

public class JavaLesson32 {

	static Estoque estoque = new Estoque();
	
	private static class Customer{
		public String firstName, lastName;
		public int custAge;
		
		public Customer(String firstName, String lastName, int custAge){
			this.firstName = firstName;
			this.lastName = lastName;
			this.custAge = custAge;
		}
	}
	public static void main(String[] args) {
		
		Customer[] customers = getCustomers();
		
		PrintWriter customerOutput = createFile("teste.txt");
		
		createCustomers(estoque, customerOutput);
		customerOutput.close();
		getFileInfo();
	}
	
	private static void getFileInfo() {
		System.out.println("Info Written to File\n");
		File listOfNames = new File("texto.txt");
		try{
			BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));
			String custInfo = getInfo.readLine();
			
			while(custInfo != null){
				String[] produto = custInfo.split(", ");
				int preco = Integer.parseInt(produto[1]);
				custInfo = getInfo.readLine();
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

	private static void createCustomers(Estoque estoque, PrintWriter customerOutput) {
		// TODO Auto-generated method stub
		int percorre = 0;
		
		File listaProdutos = new File("texto.txt");
		try{
			BufferedReader leitor = new BufferedReader(new FileReader(listaProdutos));
			String informacaoProduto = leitor.readLine();
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				double preco = Double.parseDouble(produtoTemp[1]);
				int quantidade = Integer.parseInt(produtoTemp[2]);
//				System.out.println(produtoTemp[3] + " " + produtoTemp[0] + 
//						" tem " + produtoTemp[2] + " unidade(s) e custa R$" + produtoTemp[1]);
				if(produtoTemp[3].equals("bebida")){
					estoque.bebidas[percorre] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.bebida);
					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
				}
				
				if(produtoTemp[3].equals("snack")){
					estoque.snacks[percorre] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.snack);
					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
				}
				
				if(produtoTemp[3].equals("outro")){
					estoque.outros[percorre] = new Produto(produtoTemp[0], preco, quantidade, basico.TipoProduto.outro);
					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
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
		
		try{
			File listaProdutos1 = new File("texto.txt");
			BufferedReader leitor1 = new BufferedReader(new FileReader(listaProdutos1));
			
			try{
				File listaTemp = new File("textoTemp.txt");
				customerOutput = new PrintWriter(new BufferedWriter(new FileWriter(listaTemp)));
			}
			catch(IOException e){
				System.out.println("An I/O Error Occurred");
				System.exit(0);
			}
			
			String informacaoProduto = leitor1.readLine();
			String informacaoAtualizada;
			String preco;
			String quantidade;
			
			while(informacaoProduto != null){
				String[] produtoTemp = informacaoProduto.split(", ");
				customerOutput.println("oi");
				
				if(produtoTemp[3].equals("bebida")){
					preco = String.valueOf(estoque.bebidas[percorre].getPreco());
					quantidade = String.valueOf(estoque.bebidas[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", bebida");
					customerOutput.println(informacaoAtualizada);
					//System.out.println(informacaoAtualizada);

					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
				}
//				
				if(produtoTemp[3].equals("snack")){
					preco = String.valueOf(estoque.bebidas[percorre].getPreco());
					quantidade = String.valueOf(estoque.bebidas[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", snack");
					//System.out.println(informacaoAtualizada);
					customerOutput.println(informacaoAtualizada);
					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
				}
				
				if(produtoTemp[3].equals("outro")){
					preco = String.valueOf(estoque.bebidas[percorre].getPreco());
					quantidade = String.valueOf(estoque.bebidas[percorre].getQuantidade());
					informacaoAtualizada = (produtoTemp[0] + ", " + preco + ", " + quantidade + ", outro");
					//System.out.println(informacaoAtualizada);
					customerOutput.println(informacaoAtualizada);
					percorre++;
					if(percorre == 7){
						percorre = 0;
					}
				}
				informacaoProduto = leitor1.readLine();
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

	

	private static Customer[] getCustomers() {
		
		Customer[] customers = new Customer[5];
		
		customers[0] = new Customer("John", "Smith", 21);
		customers[1] = new Customer("Sally", "Smith", 30);
		customers[2] = new Customer("Paul", "Ryan", 21);
		customers[3] = new Customer("Mark", "Jacobs", 21);
		customers[4] = new Customer("Steve", "Nash", 21);
		
		return customers;
	}
	
	private static PrintWriter createFile(String fileName){
		
		try{
			File listOfNames = new File(fileName);
			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
			return infoToWrite;
		}
		
		catch(IOException e){
			System.out.println("An IO Error");
			System.exit(0);
		}
		return null;
	}

}
