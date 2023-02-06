
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package devestoquefruteira.DevEstoqueFruteira;

/**
 *
 * @author Dani
 */
public class Item{
    double preco;
    double total;
    double quantidade;
    Produto produto;
    
    
    
    public Item(Produto produto, double quantidade){
        this.produto = produto;
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
    }
    
    public Item (){
    
    }
    public double getPreco(){
        return this.preco;
    }
    
    public double getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }
    
    public Produto getProduto(){
         return this.produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
        this.preco = produto.getPreco();
    }
    
   
   /*public double calcularPrecoDoItem(){
        if (this.produto instanceof ProdutoCategoriaPeso) {
            return this.preco * this.quantidade * this.produto.getQuantidade();
        } else {
            return this.preco * this.quantidade;
        }
    }*/
   
   public double getTotalProduto() {
       if(produto.getQuantidade() < quantidade){
           //throw new Exception("Valor não permitido pois a quantidade em estoque é menor do que a solicitada");
       }
        try {
            //produto.setQuantidade(produto.getQuantidade() - quantidade);
        } catch (Exception ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.preco * quantidade;
   
    }
   

    
    @Override
    public String toString(){
        return "Prduto: "+this.produto+"\n Quantidade: "+this.quantidade+"\n Preço: "+this.preco;
    }
    
}
