/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

public class ProdutoCategoriaUnidade extends Produto{
    
    public ProdutoCategoriaUnidade(int quantidade, String nome, String descricao,double preco){
    super(nome, descricao, quantidade, preco);
    }
     public void setQuantidade(int quantidade)throws Exception {
         if(quantidade > 0){
             setQuantidade(quantidade);
         }else{
             throw new Exception("Quantidade inválida, insira um valor maior que 0!");
         }
     }
    
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
    
}
