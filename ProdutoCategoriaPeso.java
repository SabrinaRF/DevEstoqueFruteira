/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

public class ProdutoCategoriaPeso extends Produto{
  private double quantidade;
  
  /*
    * Construtor da Classe PrudutoCategoriaPeso, tem o super pq a classe extende a Classe Produto.
     * @param quantidade Quantidade do Produto.
     * @param nome Nome do Produto.
     * @param descricao Descrição do Produto.
     * @param preco Preço do Produto.
    **/    
    public ProdutoCategoriaPeso(double quantidade, String nome, String descricao,double preco) throws Exception{
        super( nome, descricao, preco,quantidade);
        this.quantidade= quantidade;
        
        
         if(quantidade <0){
            throw new Exception ("quantidade do kg menor que 0");
        }
  
    
    }

    public double getQuantidade() {
        return quantidade;
    }

    

  
    //@Override
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
    
    
    //@Override
    public String toString (){
        return super.toString() + "quantidade"+ getQuantidade();
    }


    //@Override
    public double calcularPreco() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
   
}

