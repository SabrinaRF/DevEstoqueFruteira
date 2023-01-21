package devestoquefruteira.DevEstoqueFruteira.Execoes;

public class CodigoInvalidoException extends RuntimeException {

    public CodigoInvalidoException (){
        super("Código inválido, insira outro!");
    }
}
