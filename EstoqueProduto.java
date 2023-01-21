package devestoquefruteira.DevEstoqueFruteira;

import java.util.ArrayList;
import java.util.List;
import devestoquefruteira.DevEstoqueFruteira.Execoes.CodigoInvalidoException;
public class EstoqueProduto implements IProduto{

    List<Produto> listaProdutos;

    public EstoqueProduto (List<Produto> p){
        this.listaProdutos = p;
    }
    public EstoqueProduto (){
        this.listaProdutos = new ArrayList<>();
    }

    @Override
    public void addProduto(Produto p) throws Exception {
        //if (p != null) {
            listaProdutos.add(p);
        //}else{
            throw new Exception("Produto não pode ser adicionado!");
        //}   
    }

    @Override 
    public void removeProduto(int codigo) throws Exception {
        
        listaProdutos.remove(getProduto(codigo));
        
    }

    @Override 
    public Produto getProduto(int codigo) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() == codigo ){ 
                return  listaProdutos.get(i) ;
            }
        }
        throw new CodigoInvalidoException();
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                listaProdutos.get(i).setQuantidade(nova);
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getPreco() == codigo) {
                listaProdutos.get(i).setPreco(novo);
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                double novaQuantidade = (listaProdutos.get(i).getQuantidade())+ quantidade;
                
                    listaProdutos.get(i).setQuantidade(novaQuantidade);
                
            }else{
                throw new CodigoInvalidoException();
            }
        }
        
    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws Exception {
        for(int i=0;i<listaProdutos.size();i++){
            if (listaProdutos.get(i).getCodigo() ==codigo) {
                double novaQuantidade = (listaProdutos.get(i).getQuantidade())-quantidade;              
                listaProdutos.get(i).setQuantidade(novaQuantidade);
            }else{
                throw new CodigoInvalidoException();
            }
        }
    }

    public String toString(){
        String dados="";
        for(Produto v: listaProdutos){
            dados+=v.toString()+"\n";
        }
        return dados;
       
    }
   
}
