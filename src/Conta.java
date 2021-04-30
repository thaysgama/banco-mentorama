public abstract class Conta implements Tributavel {
    private int numero;
    private int agencia;
    private String banco;
    protected double saldo;
    protected double saque;
    protected double deposito;
    protected double transferencia;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean getSaque(double valor);

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public boolean getDeposito(double valor){
        saldo += valor;
        System.out.println("Depósito feito com sucesso");
        System.out.println("Você depositou R$" + valor);
        System.out.println("O saldo atualizado da conta é R$" + saldo);
        return true;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public abstract boolean getTransferencia(Conta destino, double valor);

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public Conta(int numero, int agencia, String banco, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.banco = banco;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    public double getValorTaxa() {
        return 10.0;
    }
}

