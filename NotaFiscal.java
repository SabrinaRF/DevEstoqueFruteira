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


public class NotaFiscal {
   private static int codNotaFiscalGeral = 0;
   private final int codNotaFiscal; //sugestao da ide ser final
   private String data;
   private final List<Item> listaDeItem; //sugestao da ide ser final

    public NotaFiscal(String data, List<Item> listaDeItem){
        this.codNotaFiscal = codNotaFiscalGeral ++;
        this.data = data;
        this.listaDeItem = listaDeItem;
    }

    NotaFiscal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCodNotaFiscal(){
        return codNotaFiscal;
    }


    public String getData(){
        return data;
    }
    
    public void setData(String data){
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

   @Override
    public String toString(){
        return "Código: "+ codNotaFiscal+"\nData: " + data;
    }
}
