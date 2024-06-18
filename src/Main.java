import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PacienteManager pacienteManager = new PacienteManager("pacientes.txt");
        ArrayList<Paciente> pacientes = pacienteManager.getPacientes();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa de cadastro de Pacientes");
        while(true){

            int option = 0;
            System.out.println("\n\nEscolha uma das opções do menu:\n");
            System.out.println("1 - Cadastrar\n2 - Editar\n3 - Deletar\n4 - Listar todos\nOutro número - Encerrar programa");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option < 1 || option > 4){
                break;
            }

            switch (option){
                case 1:
                    System.out.println("Cadastro de paciente");
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o plano: ");
                    String plano = scanner.nextLine();
                    Paciente novo = new Paciente(nome, idade, plano);
                    pacientes.add(novo);
                    System.out.println("Cadastrado");
                    break;

                case 2:
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i+" - "+pacientes.get(i).getNome() + " - " + pacientes.get(i).getIdade() + " - " + pacientes.get(i).getPlano());
                    }
                    System.out.println("Escolha o número do paciente a ser editado:");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome: ");
                    String nomeEdit = scanner.nextLine();
                    System.out.println("Digite a idade: ");
                    int idadeEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o plano: ");
                    String planoEdit = scanner.nextLine();
                    Paciente novoEdit = new Paciente(nomeEdit, idadeEdit, planoEdit);
                    pacientes.set(index, novoEdit);
                    System.out.println("Editado");
                    break;

                case 3:
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i+" - "+pacientes.get(i).getNome() + " - " + pacientes.get(i).getIdade() + " - " + pacientes.get(i).getPlano());
                    }
                    System.out.println("Escolha o número do paciente a ser excluído:");
                    int indexDelete = scanner.nextInt();
                    scanner.nextLine();
                    pacientes.remove(indexDelete);
                    System.out.println("Excluído");
                    break;

                case 4:
                    for (Paciente paciente : pacientes) {
                        System.out.println(paciente.getNome() + " - " + paciente.getIdade() + " - " + paciente.getPlano());
                    }
                    break;
            }
        }

        pacienteManager.salvarPacientes();
    }
}
