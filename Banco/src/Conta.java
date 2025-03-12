
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (checkLimiteSaquePorTransacao(valor)) {
            saldo -= valor;
        } else {
            System.out.println("Ultrapassou o limite por transação.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }


    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (checkSaldo(valor)){
        this.sacar(valor);
        contaDestino.depositar(valor);}
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    protected boolean checkLimiteSaquePorTransacao(double valor) {
        return valor<=1000;
    }

    protected boolean checkSaldo(double valor) {
        return saldo >= valor;
    }

    public int getAgencia() {

        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}

