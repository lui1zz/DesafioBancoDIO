public class Main {

    public static void main(String[] args){

        Cliente luiz = new Cliente();
        luiz.setNome("Luiz");

        Conta cc = new ContaCorrente(luiz);
        Conta poupanca = new ContaPoupanca(luiz);

        cc.depositar(1400);
        cc.transferir(200, poupanca);
        cc.sacar(1000);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
