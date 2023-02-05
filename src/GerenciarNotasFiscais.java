/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class GerenciarNotasFiscais implements INotasFiscais{
    private List<NotaFiscal> listaDeNotasFiscais;
    private List <Produto> listaProdutos; //add
    
    
  
    public GerenciarNotasFiscais(List<NotaFiscal> listaDeNotasFiscais, List<Produto> listaProdutos){
        this.listaDeNotasFiscais = listaDeNotasFiscais;
        this.listaProdutos = listaProdutos;
    }

    public GerenciarNotasFiscais(){
     this.listaDeNotasFiscais = new ArrayList<NotaFiscal>();
    }
    /**
     *
     * @param nf
     * @throws Exception
     */
    @Override
   /* public void addNotaFiscal(NotaFiscal nf) throws Exception{
        if(nf != null){
        listaDeNotasFiscais.add(nf);
        } else {
             throw new Exception("Nota fiscal não pode ser adicionado!");
        }
    }
    */
    
        public void addNotaFiscal(NotaFiscal nf) throws Exception{
        if(listaDeNotasFiscais == null) {
            listaDeNotasFiscais = new ArrayList<NotaFiscal>();
        }
        if(nf != null){
            listaDeNotasFiscais.add(nf);
        } else {
            throw new Exception("Nota fiscal não pode ser adicionado!");
        }
    }

    
    
    /**
     *
     * @param codigo
     * @throws Exception
     */
    @Override
    public void removeNotaFiscal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                listaDeNotasFiscais.remove(nota);
            }
        }
        throw new Exception("Nota fiscal não encontrada. Logo, não há como remover");
    }
    
    /**
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                return nota;
            }
        }
        throw new Exception("Nota fiscal não encontrada.");
    }
    
    
    /**
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    @Override
    public double getTotal(int codigo) throws Exception{
        for(NotaFiscal nota : listaDeNotasFiscais){
            if(nota.getCodNotaFiscal() == codigo){
                return nota.getTotal();
            }
          
        }
        throw new Exception("Código inválido. Nota fiscal não pôde ser encontrada.");
    }

    @Override
    public void addItem(int codigo, Item item) throws Exception{
        if(item != null){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getCodNotaFiscal() == codigo){
                    nota.adicionarItem(item);
                }
            }
        }
        throw new Exception("Item inválido.");
    }
    
    @Override
    public void removeItem(int codigo, Item item) throws Exception{
        if(item != null){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getCodNotaFiscal() == codigo){
                    nota.removerItem(item);
                }
            }
        }
        throw new Exception("Item inválido.");
    }
    
    public double totalVendidoDia(String data) throws Exception{
        double total = 0;
        if(!data.equals("")){
            for(NotaFiscal nota : listaDeNotasFiscais){
                if(nota.getData().equals(data)){
                    total += nota.getTotal();
                }
            }
            return total;
        }

        throw new Exception("Data inválida.");
    }
    
    

    //foi add 
    public List<NotaFiscal> getListaNota() {
           
        return listaDeNotasFiscais;
    }
    
    //foi add 
    public List<Produto> getListsProduto() {     
        return  listaProdutos;
        
        
    }
    
     public NotaFiscal get(int i){
    return  listaDeNotasFiscais.get(i);
    }
    
     public int size(){
        return listaDeNotasFiscais.size();
    
    }
    
    public int getNProduto(){
    return listaProdutos.size();
    } 
            
    public int getQuantElementos() { ///////////// Add
        int quant = 0;
       for(int i=0;i<listaDeNotasFiscais.size();i++){
            quant++;
        }
        return quant;
    }
}
