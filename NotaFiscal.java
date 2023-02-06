package devestoquefruteira.DevEstoqueFruteira;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dani e João
 */

 
import java.util.List;

/**
 * Classe NotaFiscal
 * @author PC
 */
public class NotaFiscal {
   private static int codNotaFiscalGeral = 0;
   private final int codNotaFiscal; //sugestao da ide ser final
   private String data;
   private final List<Item> listaDeItem; //sugestao da ide ser final
   private Produto produto;
   /**
    * Construtor da nota fiscal
    * @param data
    * @param listaDeItem
    * @param produto 
    */
    public NotaFiscal(String data, List<Item> listaDeItem, Produto produto){
        this.codNotaFiscal = codNotaFiscalGeral ++;
        this.data = data;
        this.listaDeItem = listaDeItem;
        this.produto = produto;
    }

    NotaFiscal() {
       this.codNotaFiscal = codNotaFiscalGeral++;
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       this.listaDeItem = null;
    }
    /**
     * Capotura o código da nota fiscal
     * @return 
     */

    public int getCodNotaFiscal(){
        return codNotaFiscal;
    }

/**
 * Captura a data da nota fiscal
 * @return 
 */
    public String getData(){
        return data;
    }
    /**
     * Altera a data da nota fiscal
     * @param data 
     */
    public void setData(String data){
        this.data = data;
    }

/**
 * Captura o total de itens
 * @return
 * @throws Exception 
 */
    public double getTotal() throws Exception{
       double total = 0;
       for(Item item : listaDeItem){
            total += item.getTotal();
        }
       return total;
    }
/**
 * Classe para adicionar item na nota fiscal
 * @param item
 * @throws Exception 
 */
    public void adicionarItem(Item item) throws Exception{
        if(item != null){
            this.listaDeItem.add(item);
        }else{
            throw new Exception ("O item é inválido.");
        }

    }
    /**
     * Classe para remover o item da nota fiscal
     * @param item
     * @throws Exception 
     */

    public void removerItem(Item item) throws Exception{
        if(this.listaDeItem.size() < 1 || item == null){
            throw new Exception("O item é inválido.");
        }else{
            this.listaDeItem.remove(item);
        }
    }
/**
 * Altera o produto
 * @param produto 
 */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
 /**
  * Captura o produto
  * @return 
  */
     public Produto getProduto(){
        return produto;
    }
    
     
     
    
   @Override
    public String toString(){
        return "Código: "+ codNotaFiscal+"\nData: " + data;
    }
}
