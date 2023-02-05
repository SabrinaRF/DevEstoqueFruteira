/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

public class ProdutoCategoriaUnidade extends Produto{
    
    
    /**
    * Construtor da Classe PrudutoCategoriaUnidade, tem o super pq a classe extende a Classe Produto.
     * @param quantidade Quantidade do Produto.
     * @param nome Nome do Produto.
     * @param descricao Descrição do Produto.
     * @param preco Preço do Produto.
    **/ 
    public ProdutoCategoriaUnidade(int quantidade, String nome, String descricao,double preco, String categoria) throws Exception{
        super(nome, descricao, quantidade, preco, categoria);
    }

   
    
    /**
     *
     * Altera a quantidade do produto.
     * @param quantidade Quantidade do produto por unidade a ser alterado.
     * @throws java.lang.Exception Lança exceção quando a quantidade for menor ou igual a zero 
     * ou quando a quantidade inserida é double.
    **/
    public void setQuantidade(double quantidade)throws Exception {
        if(quantidade > 0){
            try{
                int q = (int) quantidade;
                setQuantidade(quantidade);
            }catch(Exception e){
                throw new Exception("Quantidade deve ser um valor inteiro");
            }
        }
        else{
            throw new Exception("Quantidade inválida, insira um valor maior que 0!");
        }
    }
    
    @Override
    public double calcularPrecoItem() {
     return preco * quantidade;
 }
     
    
    
}
      
    

