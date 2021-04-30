public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
        super(numero, agencia, banco, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public final double getSaldo(){
        return this.chequeEspecial + this.saldo;
    }

    @Override
    public boolean getSaque(double valor){
        if (valor > getSaldo()) {
            System.out.println("Operação saque falhou.");
            System.out.println("Seu saldo é insuficiente para efetuar essa transação.");
            return false;
        } else {
            saldo -= valor;
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

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "Conta Corrente{" +
                "Número=" + getNumero() +
                ", Agencia=" + getAgencia() +
                ", Banco=" + getBanco() +
                ", Saldo=" + saldo +
                ", Cheque Especial=" + chequeEspecial +
                ", Saldo Total Disponível=" + getSaldo() +
                '}';
    }
}
