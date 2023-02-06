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
    String categoria;
    
    
    
    public Item(Produto produto, int quantidade,String categotria){
        this.produto = produto;
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
        this.categoria=categotria;
    }
    
    public Item (){
    
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
        if (this.produto instanceof ProdutoCategoriaPeso) {
            return this.preco * this.quantidade * this.produto.getQuantidade();
        } else {
            return this.preco * this.quantidade;
        }
       
        
    }
   
   public double calcular(){
    return this.preco * this.quantidade;
   }
   
   
   
   
   public double calcularPrecoPorKg(){
        //return this.preco * this.quantidade * this.produto.getQuantidade();
     return produto.getPrecoPorKg() * quantidade;
    }
public String getCategoria (){
    return categoria;
    
    }


 public double calcularPrecoPorUnidade() {
    return produto.getPrecoPorUnidade() * quantidade;
  }


    
    @Override
    public String toString(){
        return "Prduto: "+this.produto+"\n Quantidade: "+this.quantidade+"\n Preço: "+this.preco;
    }
    
}
