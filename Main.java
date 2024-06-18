import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TrabalhadorManager trabalhadorManager = new TrabalhadorManager("trabalhadores.txt");
        List<Trabalhador> trabalhadores = trabalhadorManager.getTrabalhadores();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o salário bruto: ");
        float salarioBruto = scanner.nextFloat();

        System.out.print("Digite o desconto do INSS: ");
        float descontoInss = scanner.nextFloat();

        System.out.print("Digite o número de dependentes: ");
        int dependentes = scanner.nextInt();

        System.out.print("Digite o valor total dos descontos: ");
        float valorTotalDescontos = scanner.nextFloat();

        scanner.nextLine();

        System.out.print("Digite o CPF (inclua os pontos e com o traço no seguinte formato: 000.000.000-00): ");

        String CPF = scanner.nextLine();
        while (true){
            if (CPFValidator.isValidCPF(CPF)){
                break;
            }
            System.out.println("CPF inválido, digite novamente");
            CPF = scanner.nextLine();
        }
        System.out.println("CPF validado!");

        System.out.print("Digite o CEP: (digite no formato 00000-000)");
        String CEP = scanner.nextLine();
        try {
            String resposta = EnderecoSearch.buscarEndereco(CEP);
            System.out.println(resposta);
        } catch (IOException e) {
            System.out.println("Erro ao buscar o endereço: " + e.getMessage());
        }

        Trabalhador novoTrab = new Trabalhador(nome, salarioBruto, descontoInss, dependentes, valorTotalDescontos, CPF, CEP);
        System.out.println("O valor do imposto de renda é: " + novoTrab.calcularImpostoRenda());

        trabalhadorManager.setTrabalhadores(trabalhadores.stream().filter(trab -> !trab.getCPF().equals(novoTrab.getCPF())).collect(Collectors.toList()));

        trabalhadorManager.adicionarTrabalhador(novoTrab);
        trabalhadorManager.salvarTrabalhadores();
    }
}
