package entidade;

public class Produto {
	
	private int codigo_produto;
	private String descricao;
	private double preco;
	private int quantidade;
	private String localizacao;
	

	//Construtor
	public Produto(int codigo_produto, String descricao, double preco, int quantidade, String localizacao) {
		this.codigo_produto = codigo_produto;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.localizacao = localizacao;
	}

	//Getters and Setters
	public int getCodigo_produto() {
		return codigo_produto;
	}


	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	//toString
	@Override
	public String toString() {
		return "Produto [codigo_produto=" + codigo_produto + ", descricao=" + descricao + ", preco=" + preco
				+ ", localizacao=" + localizacao + "]";
	}
	
	//Método para aumentar a quantidade de um produto
	public void adicionarEntradaProduto(int n) {
		this.quantidade = this.quantidade + n;
	}
	
	//Método para diminuir a quantidade de um produto
	public void adicionarSaidaProduto(int n) {
		this.quantidade = this.quantidade - n;
	}
	
}