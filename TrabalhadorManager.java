import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TrabalhadorManager {
    private List<Trabalhador> trabalhadores;
    private String filePath;

    public TrabalhadorManager(String filePath) {
        this.filePath = filePath;
        this.trabalhadores = new ArrayList<>();
        carregarTrabalhadores();
    }

    private void carregarTrabalhadores() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 7) {
                    String nome = dados[0];
                    float salarioBruto = Float.parseFloat(dados[1]);
                    float descontoInss = Float.parseFloat(dados[2]);
                    int dependentes = Integer.parseInt(dados[3]);
                    float valorTotalDescontos = Float.parseFloat(dados[4]);
                    String CPF = dados[5];
                    String CEP = dados[6];
                    Trabalhador trabalhador = new Trabalhador(nome, salarioBruto, descontoInss, dependentes, valorTotalDescontos, CPF, CEP);
                    trabalhadores.add(trabalhador);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar trabalhadores: " + e.getMessage());
        }
    }

    public void salvarTrabalhadores() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Trabalhador trabalhador : trabalhadores) {
                bw.write(trabalhador.getNome() + "," + trabalhador.getSalarioBruto() + "," + trabalhador.getDescontoInss() + "," +
                        trabalhador.getDependentes() + "," + trabalhador.getValorTotalDescontos() + "," +
                        trabalhador.getCPF() + "," + trabalhador.getCEP());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar trabalhadores: " + e.getMessage());
        }
    }

    public void setTrabalhadores(List<Trabalhador> lista){
        this.trabalhadores = lista;
    }

    public List<Trabalhador> getTrabalhadores() {
        return trabalhadores;
    }

    public void adicionarTrabalhador(Trabalhador trabalhador) {
        trabalhadores.add(trabalhador);
    }
}
