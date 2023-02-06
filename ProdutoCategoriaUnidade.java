/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

public class ProdutoCategoriaUnidade extends Produto{
    private int quantidade;
    
    /**
    * Construtor da Classe PrudutoCategoriaUnidade, tem o super pq a classe extende a Classe Produto.
     * @param quantidade Quantidade do Produto.
     * @param nome Nome do Produto.
     * @param descricao Descrição do Produto.
     * @param preco Preço do Produto.
    **/ 
    public ProdutoCategoriaUnidade(int quantidade, String nome, String descricao,double preco) throws Exception{
        super(nome, descricao, preco);
        this.quantidade=quantidade;
        
        if(quantidade <0){
         throw new Exception ("quantidade do kg menor que 0");
        
        }
        
        
    }

    
    /**
     *
     * Altera a quantidade do produto.
     * @param quantidade Quantidade do produto por unidade a ser alterado.
     * @throws java.lang.Exception Lança exceção quando a quantidade for menor ou igual a zero 
     * ou quando a quantidade inserida é double.
    **/
    
    @Override
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
    public double calcularPreco() {
     return preco * quantidade;
     
 }
    
    @Override
    public String toString (){
        return super.toString() + "quantidade"+ getQuantidade();
    }

    @Override
    public double getQuantidade() {
        return this.quantidade;
    }
    
    

    
    
}
      
    

