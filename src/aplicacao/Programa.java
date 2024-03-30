package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.ListapProdutos;
import entidade.Produto;

public class Programa {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String resp = null;
    	boolean repeticao = true;
        ListapProdutos list = new ListapProdutos();
        while (repeticao == true) {
            System.out.println("--------------");
            System.out.println("Controle de estoque");
            System.out.println("-------------------");
            System.out.println("1) Cadastro de produtos");
            System.out.println("2) Deletar produtos");
            System.out.println("3) Mostrar todos os produtos");
            System.out.println("4) Aumentar quantidade de um item no estoque");
            System.out.println("5) Diminuir quantidade de um item no estoque");
            System.out.println("6) Fechar programa!");
            int num = 0;
            System.out.print("\nEscolha uma das opções: ");
            num = sc.nextInt();
            
            Produto produto = null;

            switch(num) {
            	//CASO PARA CADASTRAR UM PRODUTO!
                case 1:
                	//Pergunta as informações do produto, após isso cria o objeto e coloca ele em uma lista.
                    System.out.print("Digite o código do produto: ");
                    int cod_prod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Qual a descrição do produto? ");
                    String descricao = sc.nextLine();
                    System.out.print("Qual o preço do produto? ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Qual a quantidade do produto em estoque? ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Qual a localização que fica o produto? ");
                    String localizacao = sc.nextLine();
                    produto = new Produto(cod_prod, descricao, price, quantidade, localizacao);
                    list.adicionarProduto(produto);
                    System.out.println("----------");
                    System.out.println("Produto cadastrado!");
                    repeticao = !verificarRetornoTelaInicial(sc);
                    break;
                    
                //CASE 2 DELETAR PRODUTOS
                case 2:
                	System.out.print("Digite o codigo do produto que você deseja remover: ");
                	int codigo = sc.nextInt();
                	list.removerProduto(codigo);
                	repeticao = !verificarRetornoTelaInicial(sc);
                	break;
                	
                	
                //CASE 3 MOSTRAR TODOS OS PRODUTOS
                case 3:
                	list.mostrarProdutos();
                	resp = null;
                	System.out.println("--------");
                	repeticao = !verificarRetornoTelaInicial(sc);
                    break;
                    
                case 4:
                    System.out.print("Digite o código do produto para aumentar a quantidade: ");
                    int codigoProduto = sc.nextInt();
                    if (list.buscarProdutoPorCodigo(codigoProduto) != null) {
                        System.out.print("Digite a quantidade para adicionar ao estoque: ");
                        int quantidadeAdicionar = sc.nextInt();
                        list.aumentarQuantidadeProduto(codigoProduto, quantidadeAdicionar);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    repeticao = !verificarRetornoTelaInicial(sc);
                    break;
                case 5:
                	System.out.print("Digite o código do produto para diminuir a quantidade: ");
                    int codigoProdutoDiminuir = sc.nextInt();
                    if (list.buscarProdutoPorCodigo(codigoProdutoDiminuir) != null) {
                        System.out.print("Digite a quantidade para diminuir ao estoque: ");
                        int quantidadeDiminuir = sc.nextInt();
                        list.diminuirQuantidadeProduto(codigoProdutoDiminuir, quantidadeDiminuir);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    repeticao = !verificarRetornoTelaInicial(sc);
                    break;

                    
                //CASE 6 FINALIZAR PROGRAMA.
                case 6:
                	System.out.println("FINALIZANDO PROGARMA....");
                	repeticao = false;
                	break;
                default:
                	System.out.println("Valor errado! Favor digitar uma das opções acima.");
            }
        }

        System.out.println("PROGRAMA FINALIZADO.");
        
        
        
        sc.close();
    }
    
    public static boolean verificarRetornoTelaInicial(Scanner sc) {
        System.out.println("Deseja voltar à tela inicial? s/n? ");
        String resp = sc.next();
        while (!"n".equalsIgnoreCase(resp) && !"s".equalsIgnoreCase(resp)) {
            System.out.println("Resposta errada, favor digitar 's' ou 'n'. Deseja voltar à tela inicial? s/n");
            resp = sc.next();
        }
        return "n".equalsIgnoreCase(resp);
    }

}