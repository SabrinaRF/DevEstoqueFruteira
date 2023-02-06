/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

/**
 *
 * @author Dani
 * Classe item
 */
public class Item{
    double preco;
    int quantidade;
    Produto produto;
    /**
     * Construto da classe item
     * @param produto
     * @param quantidade 
     */
    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
    }
    /**
     * Captura o preço do item
     * @return 
     */
    public double getPreco(){
        return this.preco;
    }
    /**
     * Captura a quantidade
     * @return 
     */
    public int getQuantidade(){
        return this.quantidade;
    }
    /**
     * Altera a quantidade
     * @param quantidade 
     */
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    /**
     * Captura o produto
     * @return 
     */
    public Produto getProduto(){
         return this.produto;
    }
    
    /**
     * Altera o produto
     * @param produto 
     */
    public void setProduto(Produto produto){
        this.produto = produto;
        this.preco = produto.getPreco();
    }
    /**
     * Captura o total
     * @return 
     */
    public double getTotal(){
        return this.preco * this.quantidade;
    }
    
    @Override
    public String toString(){
        return "Prduto: "+this.produto+"\n Quantidade: "+this.quantidade+"\n Preço: "+this.preco;
    }
    
}
