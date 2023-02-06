/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dani
 */
public class GerenciarNotasFiscais implements INotasFiscais{
    private List<NotaFiscal> listaDeNotasFiscais;
    private List <Produto> listaProdutos; //add
    
    
    /**
     * Construtor da Classe GerenciarNotasFiscais .
     * @param listaDeNotasFiscais Lista de Notas Fiscais.
     * @param listaProdutos Lista de Produtos.
     */
    public GerenciarNotasFiscais(List<NotaFiscal> listaDeNotasFiscais, List<Produto> listaProdutos){
        this.listaDeNotasFiscais = listaDeNotasFiscais;
        this.listaProdutos = listaProdutos;
    }

    /**
     * Construtor da Classe GerenciarNotasFiscais .
     */
    public GerenciarNotasFiscais(){
     this.listaDeNotasFiscais = new ArrayList<NotaFiscal>();
    }
    
    /**
     * Adiciona a nota fiscal a lista.
     * @param nf NotaFiscal como parametro.
     * @throws Exception Lança exceção a nota fiscal não possa ser adicionada.
     */
    @Override
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
     * Remove a Nots Fiscal da lista de notas.
     * @param codigo Código da nota fiscal a ser inserida.
     * @throws Exception Lança exceção quando não é encontrada.
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
     * Retorna uma Nota Fiscal da lista de notas fiscais.
     * @param codigo Código da Nota Fiscal.
     * @return nota Nota fiscal é retornada.
     * @throws Exception Lança execeção quando a Nota Fiscal não for encontrada.
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
     * Retorna o total de uma nota fiscal.
     * @param codigo Código da Nota Fiscal.
     * @return Total de uma nota fiscal.
     * @throws Exception Lança execeção quando a Nota Fiscal não for encontrada.
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

    /**
     * Adiciona umm item a nota fiscal.
     * @param codigo Código da Nota Fiscal.
     * @param item Item é um objeto Item.
     * @throws Exception Lança execeção quando o item não for encontrada.
     */
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
    
    /**
     * Remove umm item a nota fiscal.
     * @param codigo Código da Nota Fiscal.
     * @param item Item é um objeto Item.
     * @throws Exception Lança execeção quando o item não for encontrada.
     */
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
    
    /**
     * Retorna o total vendido no dia.
     * @param data data é uma data.
     * @return Total vendido do dia.
     * @throws Exception Lança execeção quando o item não for encontrada.
     */
    public double totalVendidoDia(Date data) throws Exception{
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
