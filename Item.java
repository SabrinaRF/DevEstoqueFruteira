/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

/**
 *
 * @author Dani
 */
public class Item{
    double preco;
    int quantidade;
    Produto produto;
    
    
    public Item (){
    
    }
    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public Produto getProduto(){
         return this.produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
        this.preco = produto.getPreco();
    }
    
    public double getTotal(){
        return this.preco * this.quantidade;
    }
    
    
   public double calcularPrecoDoItem(){
       return this.preco * this.quantidade;
     
       
       /* quantidade do item = 3 
               multiplo valor do produto 
                       e exbido o calculo 
                               
                               exibe na tabela 
                   */                    
   }
    
    
    @Override
    public String toString(){
        return "Prduto: "+this.produto+"\n Quantidade: "+this.quantidade+"\n Preço: "+this.preco;
    }
    
}
