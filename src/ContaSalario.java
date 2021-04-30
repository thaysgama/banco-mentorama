public class ContaSalario extends Conta {

    int limiteSaques;

    public ContaSalario(int numero, int agencia, String banco, double saldo) {
        super(numero, agencia, banco, saldo);
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public boolean getSaque(double valor) {
        if (valor > getSaldo()) {
            System.out.println("Operação saque falhou.");
            System.out.println("Seu saldo é insuficiente para efetuar essa transação.");
            return false;
        } else if (!(limiteSaques <2)) {
            System.out.println("Operação saque falhou.");
            System.out.println("O limite de saques foi excedido.");
            return false;
        } else {
            saldo -= valor;
            limiteSaques+=1;
            System.out.println("Saque feito com sucesso");
            System.out.println("Você sacou R$" + valor);
            System.out.println("O saldo atualizado da conta é R$" + saldo);
            return true;
        }
    }

    @Override
    public boolean getTransferencia(Conta destino, double valor) {
        if (getSaldo() < valor + getValorTaxa()) {
            System.out.println("Operação transferência falhou.");
            System.out.println("Não há saldo suficiente para realizar essa transação.");
            return false;
        } else {
            this.saldo = this.saldo - valor - getValorTaxa();
            destino.saldo += valor;
            System.out.println("Transferência realizada com sucesso");
            System.out.println("Você transferiu R$"+ valor +" e pagou a taxa de R$" + getValorTaxa());
            System.out.println("Sua conta atualizada: \n" +
                    this.toString());
            return true;
        }
    }

    @Override
    public String toString() {
        return "Conta Salario{" +
                "Número=" + getNumero() +
                ", Agencia=" + getAgencia() +
                ", Banco=" + getBanco() +
                ", Saldo=" + saldo +
                '}';
    }

}
