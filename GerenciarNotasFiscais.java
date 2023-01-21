/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class GerenciarNotasFiscais implements INotasFiscais{
    private List<NotaFiscal> listaDeNotasFiscais;
    
    public GerenciarNotasFiscais(){
        listaDeNotasFiscais = new ArrayList<>();
    }
    
    public GerenciarNotasFiscais(List<NotaFiscal> listaDeNotasFiscais){
        this.listaDeNotasFiscais = listaDeNotasFiscais;
    }
    
    /**
     *
     * @param nf
     * @throws Exception
     */
    @Override
    public void addNotaFiscal(NotaFiscal nf) throws Exception{
        this.listaDeNotasFiscais.add(nf);
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
}
