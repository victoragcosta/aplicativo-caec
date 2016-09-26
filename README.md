# Aplicativo-caec
Aplicativo para auxiliar no controle do estoque e venda do CAEC.

# Localizações

- Todo item a venda é composto de 5 componentes: a tecla de atalho, o nome, a quantidade escolhida e os botões para modificar a quantidade.

- Os items a venda estão divididos em 3 categorias: bebidas, snacks (lanches) e outros (tudo que não se enquadra nos 2 primeiros). Há atualmente um limite para 9 itens na área de bebidas, 18 em snacks e 9 em outros.

- Há uma área localizada no canto superior direito onde tem escrito "Pedido:", é lá onde será mostrado o pedido feito pelo usuário e o total, a tela sempre atualiza quando o pedido é modificado.

- Há 2 botões relacionados à venda dos produtos, 2 botões relacionados à quantidade em estoque dos produtos e 3 botões relacionados às informações de um produto.

# Manual

1. Como verificar quantidade em estoque.
2. Como efetuar uma venda.
3. Como efetuar um reestoque.
4. Como mudar de preço.
5. Como adicionar um produto.
6. Como remover um produto. (NÃO IMPLEMENTADO)


# Como verificar quantidade em estoque

  Para verificar a quantidade em estoque, somente é preciso clicar no botão "Verifica Estoque" e aparecerá uma janela com o estoque atual.

# Como efetuar uma venda

  Para efetuar uma venda, considerando que haja estoque (caso não exista disponibilidade de um item, não será possível acrescentar o mesmo ao pedido), deve-se clicar no "+" correspondente ao item desejado ou tecla de atalho (que se encontra antes do nome), uma vez que o pedido corresponda ao pedido do cliente, deve-se informar ao cliente o total, receber o dinheiro e clicar em "Concluir" para finalizar a venda.
  
# Como efetuar um reestoque

  Para reestocar, deve-se clicar no botão "Reestoque". Uma vez aberta a janela, o usuário deverá inserir a quantidade COMPRADA, não a quantidade comprada adicionada ao estoque, em seu devido lugar.
  
# Como mudar de preço

  Para mudar de preço é só clicar no botão "Muda preço", achar o produto que se deseja mudar o preço e mudar o preço.
  
# Como adicionar um produto

  Para adicionar um novo produto, deve-se clicar no botão "Adiciona Produto" e inserir as informações nos campos correspondentes, atentando à limitação de no máximo 9 produtos das categorias "bebidas" e "outros" e 18 de "snack".
  
# Como remover um produto

  Como ainda não está implementado o código, deve-se ir até o arquivo texto, abrir o arquivo texto e remover a linha inteira do produto desejado.
  
# Bugs conhecidos

  Por algum motivo, os estoques de snacks e outros ficam ciclando, o de bebidas está normal.
  
# A melhorar
  - Código para leitura e escrita do arquivo texto.txt.
  - Passar a usar um banco de dados em vez de um arquivo texto.
  - Implementar função relatório.
  - Implementar função do botão Remove Produto.
  - Descobrir as formatações bonitinhas para tornar o README mais visualmente atrativo.
