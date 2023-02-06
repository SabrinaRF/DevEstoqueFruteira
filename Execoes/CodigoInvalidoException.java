package devestoquefruteira.DevEstoqueFruteira.Execoes;

public class CodigoInvalidoException extends RuntimeException {

    /**
     * Exception criada para quando o código inválido.
    **/
    public CodigoInvalidoException (){
        super("Código inválido, insira outro!");
    }
}
