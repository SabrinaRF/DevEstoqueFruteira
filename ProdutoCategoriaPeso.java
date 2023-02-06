/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

public class ProdutoCategoriaPeso extends Produto{
    private float quantidadePeso;
    
    /**
    * Construtor da Classe PrudutoCategoriaPeso, tem o super pq a classe extende a Classe Produto.
     * @param quantidade Quantidade do Produto.
     * @param nome Nome do Produto.
     * @param descricao Descrição do Produto.
     * @param preco Preço do Produto.
    **/    
    public ProdutoCategoriaPeso(int quantidade, String nome, String descricao,double preco) throws Exception{
        super(nome, descricao, quantidade, preco);
    }
    
    
     @Override
    public double calcularPrecoItem() {
     return preco * quantidade;
 }
    
    
  
}

