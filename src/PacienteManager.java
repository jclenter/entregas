import java.io.*;
import java.util.ArrayList;

public class PacienteManager {
    private ArrayList<Paciente> pacientes;
    private String filePath;

    public PacienteManager(String filePath) {
        this.filePath = filePath;
        this.pacientes = new ArrayList<>();
        carregarPacientes();
    }

    private void carregarPacientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    String nome = dados[0];
                    int idade = Integer.parseInt(dados[1]);
                    String plano = dados[2];
                    Paciente paciente = new Paciente(nome, idade, plano);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar pacientes: " + e.getMessage());
        }
    }

    public void salvarPacientes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Paciente paciente : pacientes) {
                bw.write(paciente.getNome() + "," + paciente.getIdade() + "," + paciente.getPlano());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
}
