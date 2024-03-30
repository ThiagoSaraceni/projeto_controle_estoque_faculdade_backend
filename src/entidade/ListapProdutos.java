package entidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListapProdutos {
	 private Produto p;
	 
	 
	 //Criando a lista.
	 List <Produto> listaProdutos = new ArrayList<>();
	 
	 
	 //Método para adicionar um produto na lista.
	 public void adicionarProduto(Produto p) {
		 listaProdutos.add(p);
	 }
	 
	 
	 //Método para remover um produto
	 public void removerProduto(int codigo) {
		// Usa um iterador para percorrer a lista de produtos
	        Iterator<Produto> iterator = listaProdutos.iterator();
	        while (iterator.hasNext()) {
	            Produto produto = iterator.next();
	            // Se encontrar um produto com o código fornecido, remove-o da lista
	            if (produto.getCodigo_produto() == codigo) {
	                iterator.remove();
	                System.out.println("Produto removido com sucesso.");
	                return; // Sai do método após remover o produto
	            }
	        }
	        // Se não encontrar nenhum produto com o código fornecido, exibe uma mensagem
	        System.out.println("Nenhum produto encontrado com o código fornecido.");
	 }
	 
	 //Método para mostrar produto
	 public void mostrarProdutos() {
		 //Se lista vazia, escreva nenhum produto cadastrado, senao mostre os produtos
		 if(listaProdutos.isEmpty()) {
			 System.out.println("Lista vazia nenhum produto cadastrado!.");
		 } else {
		 for (Produto p: listaProdutos) {
			 System.out.println("| Codigo produto: "+ p.getCodigo_produto() + 
					 " | Descrição do produto: " + p.getDescricao() + 
					 " | Preço " + p.getPreco() +
					 " | Quantidade " + p.getQuantidade() +
					 " | Localização " + p.getLocalizacao() + " |");
		 }
		 }
	 }
	 
	 //Método para buscar produto por código
	 public Produto buscarProdutoPorCodigo(int codigo) {
		 //Um for que leia a lista inteira, se encontrar o codigo digitado retorne o produto.
		    for (Produto produto : listaProdutos) {
		        if (produto.getCodigo_produto() == codigo) {
		            return produto;
		        }
		    }
		    return null; // Retorna null se o produto não for encontrado
		}
	 
	 //Método para aumentar a quantidade de produtos
	 public void aumentarQuantidadeProduto(int codigo, int quantidade) {
		    Produto produto = buscarProdutoPorCodigo(codigo);
		    if (produto != null) {
		        produto.adicionarEntradaProduto(quantidade);
		        System.out.println("Quantidade do produto " + produto.getDescricao() + " aumentada em " + quantidade);
		    } else {
		        System.out.println("Produto não encontrado.");
		    }
		}
	 
	 //Método para diminuir a quantidade de um produto
	 public void diminuirQuantidadeProduto(int codigo, int quantidade) {
		    Produto produto = buscarProdutoPorCodigo(codigo);
		    if (produto != null) {
		        produto.adicionarSaidaProduto(quantidade);
		        System.out.println("Quantidade do produto " + produto.getDescricao() + " diminuida em " + quantidade);
		    } else {
		        System.out.println("Produto não encontrado.");
		    }
		}


}