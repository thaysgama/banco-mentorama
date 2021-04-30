import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {

    private double taxaDeJuros = 1.05;
    private String dataAniversario;
    private String dataDia = String.valueOf(LocalDate.now());

    public ContaPoupanca(int numero, int agencia, String banco, double saldo, String dataAniversario) {
        super(numero, agencia, banco, saldo);
        this.dataAniversario = dataAniversario;
    }

    public double getSaldo(String dataDia) {
        LocalDate localDateAniversario = LocalDate.parse(dataAniversario, DateTimeFormatter.ISO_DATE);
        LocalDate localDateDia = LocalDate.parse(dataDia, DateTimeFormatter.ISO_DATE);
        long diff = ChronoUnit.MONTHS.between(localDateAniversario.withDayOfMonth(1), localDateDia.withDayOfMonth(1));
        DecimalFormat df = new DecimalFormat("0.00");
        if (localDateDia.isBefore(localDateAniversario.plusMonths(1))){
            return this.saldo;
        } else {
            double saldoJuros = this.saldo * Math.pow(taxaDeJuros, diff);
            return Math.round(saldoJuros*100.00)/100.00;
        }
    }

    @Override
    public boolean getSaque(double valor){
        if (valor > getSaldo(dataDia)) {
            System.out.println("Operação saque falhou.");
            System.out.println("Seu saldo é insuficiente para efetuar essa transação.");
            return false;
        } else {
            saldo = getSaldo() - valor;
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
            this.saldo = this.getSaldo() - valor - getValorTaxa();
            destino.saldo += valor;
            System.out.println("Transferência realizada com sucesso");
            System.out.println("Você transferiu R$"+ valor +" e pagou a taxa de R$" + getValorTaxa());
            System.out.println("Sua conta atualizada: \n" +
                    this.toString());
            return true;
        }
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getDataDia() {
        return dataDia;
    }

    public void setDataDia(String dataDia) {
        this.dataDia = dataDia;
    }

    @Override
    public String toString() {
        return "Conta Poupanca{" +
                "Numero=" + getNumero() +
                ", Agencia=" + getAgencia() +
                ", Banco=" + getBanco() +
                ", Data Aniversario=" + dataAniversario +
                ", Data do Dia=" + dataDia +
                ", Saldo=" + saldo +
                ", Taxa de Juros=" + taxaDeJuros +
                ", Saldo + rendimento=" + getSaldo(dataDia) +
                '}';
    }
}
