public class Trabalhador {

    private String nome;
    private float salarioBruto;
    private float descontoInss;
    private int dependentes;
    private float valorTotalDescontos;
    private String CPF;
    private String CEP;

    public Trabalhador(String nome, float salarioBruto, float descontoInss, int dependentes, float valorTotalDescontos, String CPF, String CEP) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.descontoInss = descontoInss;
        this.dependentes = dependentes;
        this.valorTotalDescontos = valorTotalDescontos;
        this.CPF = CPF;
        this.CEP = CEP;
    }

    public float calcularDescontos() {
        // Dedução por dependente (valor vigente em 2024: R$ 189,59 por dependente)
        float deducaoDependente = 189.59f;
        return descontoInss + (dependentes * deducaoDependente);
    }

    public float calcularBaseCalculo() {
        return salarioBruto - valorTotalDescontos;
    }

    public float calcularImpostoRenda() {
        float baseCalculo = calcularBaseCalculo();
        float imposto = 0;

        // Alíquotas do Imposto de Renda (valores fictícios para exemplo)
        if (baseCalculo <= 1903.98f) {
            imposto = 0;
        } else if (baseCalculo <= 2826.65f) {
            imposto = (baseCalculo - 1903.98f) * 0.075f;
        } else if (baseCalculo <= 3751.05f) {
            imposto = (2826.65f - 1903.98f) * 0.075f + (baseCalculo - 2826.65f) * 0.15f;
        } else if (baseCalculo <= 4664.68f) {
            imposto = (2826.65f - 1903.98f) * 0.075f + (3751.05f - 2826.65f) * 0.15f + (baseCalculo - 3751.05f) * 0.225f;
        } else {
            imposto = (2826.65f - 1903.98f) * 0.075f + (3751.05f - 2826.65f) * 0.15f + (4664.68f - 3751.05f) * 0.225f + (baseCalculo - 4664.68f) * 0.275f;
        }

        return imposto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getDescontoInss() {
        return descontoInss;
    }

    public void setDescontoInss(float descontoInss) {
        this.descontoInss = descontoInss;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public float getValorTotalDescontos() {
        return valorTotalDescontos;
    }

    public void setValorTotalDescontos(float valorTotalDescontos) {
        this.valorTotalDescontos = valorTotalDescontos;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
