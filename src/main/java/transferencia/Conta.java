package transferencia;

public class Conta {
    private String agencia;

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void realizarDeposito(double valor){
        saldo = saldo + valor;
    }

    public boolean realizarSaque(double valor){
        if (valor > saldo){
            return false;
        }
        saldo = saldo - valor;
        return true;
    }

    public  boolean realizarTransferencia(double valor,Conta destino){
       if (realizarSaque(valor)){
           destino.realizarDeposito(valor);
           return true;
       }
       return false;
    }

    public Conta(String agencia, String numeroConta, double saldo, Cliente proprietario) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.proprietario = proprietario;
    }

    private String numeroConta;
    private double saldo;
    private Cliente proprietario;
}
