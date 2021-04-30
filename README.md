# Banco :bank: 

Nesse repositório foi criado um pequeno sistema de banco, onde é possível o gerente realizar algumas operações de teste. O objetivo foi apenas treinar a herança, polimorfismo, interfaces e seus mecanismos e não criar uma implementação complexa de como é na vida real.

![img](https://lh6.googleusercontent.com/o6R4MCtfr62Q8cBHQNxSQLrHTMgXn8bsasOqZmyKonXVuVvz8lniVqmzhP6etTCby3SlMSTkZDdt1Ee8HhXBaDss_sqqNEnT6ktFKWqJTPTcGJsx1OGzFvNPCrf9ukYXazwkhmgt)

O menu está dentro de uma repetição e fica disponível enquanto o usuário não digitar uma opção para sair. Enquanto o usuário não digitar “7”, o menu será mostrado.

Foi criada uma superclasse **Conta** e as subclasses **ContaCorrente, ContaPoupanca e ContaSalario**, onde foram incluídos os métodos **saldo(), saque(), depósito()** e **transferência()**.

Na **Conta Corrente** há um limite de saque baseado no limite de cheque especial de cada objeto. Ou seja, por exemplo, se a conta tem um saldo de R$100,00 e um limite de cheque especial de R$500,00, o cliente tem disponível para saque R$600,00. Além deste valor ele não pode sacar. 

Na **Conta Poupança** o valor do saldo pode variar dependendo do dia de aniversário da conta e da taxa de juros.

Na **Conta Salário** existe uma restrição na qual existe um limite de saques que podem ser feitos.

Os **Clientes** e as **Contas** são armazenadas em ArrayList e Hasmap respectivamente. 

A Interface **Tributável** insere uma taxa para as operações de transferência bancária.

Foi criado um método para calcular valor financeiro que o banco possui em suas contas. Esse método soma o saldo de todas as contas existentes.

