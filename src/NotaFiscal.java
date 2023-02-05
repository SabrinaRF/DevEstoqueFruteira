//package devestoquefruteira.DevEstoqueFruteira;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dani e João
 */

 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class NotaFiscal {
   private static int codNotaFiscalGeral = 0;
   private final int codNotaFiscal; //sugestao da ide ser final
   private Date data;
   private final List<Item> listaDeItem; //sugestao da ide ser final
   private Produto produto;
   
   
    public NotaFiscal(Date data, List<Item> listaDeItem, Produto produto){
        this.codNotaFiscal = codNotaFiscalGeral ++;
        this.data = data;
        if(listaDeItem == null) {
    	this.listaDeItem = new ArrayList<>();
    } else {
    	this.listaDeItem = listaDeItem;
    }
        
        //this.listaDeItem = listaDeItem;
        this.produto = produto;
    }

    NotaFiscal() {
        this.codNotaFiscal = codNotaFiscalGeral++;
        this.listaDeItem = new ArrayList<>();
     }

    public int getCodNotaFiscal(){
        return codNotaFiscal;
    }


    public Date getData(){
        return data;
    }
    
    public void setData(Date data){
        this.data = data;
    }


    public double getTotal() throws Exception{
       double total = 0;
       for(Item item : listaDeItem){
            total += item.getTotal();
        }
       return total;
    }

    public void adicionarItem(Item item) throws Exception{
        if(item != null){
            this.listaDeItem.add(item);
        }else{
            throw new Exception ("O item é inválido.");
        }

    }

    public void removerItem(Item item) throws Exception{
        if(this.listaDeItem.size() < 1 || item == null){
            throw new Exception("O item é inválido.");
        }else{
            this.listaDeItem.remove(item);
        }
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
 //foi add 
     public Produto getProduto(){
        return produto;
    }
    
     public void setListaDeItens(List<Item> listaDeItem) {
    this.listaDeItem.clear();
    this.listaDeItem.addAll(listaDeItem);  
}
  
/*public void setListaDeItens(List<Item> listaDeItem) {
    listaDeItem = new ArrayList<>();
    listaDeItem.addAll(listaDeItem);  
}*/
     
     /*
    public void setListaDeItens(List<Item> listaDeItem) {
    this.listaDeItem.addAll(listaDeItem);

        }*/
     
    public List<Item> getListaItem() {     
        return  listaDeItem;
        
        
    }
    
   @Override
    public String toString(){
        return "Código: "+ codNotaFiscal+"\nData: " + data;
    }
}
