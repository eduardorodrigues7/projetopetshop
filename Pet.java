import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    private Tutor tutor;
    private LocalDateTime horaEntrada;
    private PlanoHospedagem plano;
    private List<ServicoAgendado> servicos;

    public Pet(String nome, String especie, String raca, int idade, double peso, Tutor tutor, PlanoHospedagem plano) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.tutor = tutor;
        this.plano = plano;
        this.horaEntrada = LocalDateTime.now();
        this.servicos = new ArrayList<>();
    }

    public void agendarServico(ServicoAgendado servico) {
        this.servicos.add(servico);
    }

    public double calcularTotal(long horas) {
        double total = plano.calcularTarifa(horas);
        for (ServicoAgendado s : servicos) {
            total += s.getServico().getPreco(this);
        }
        return total;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public String getNome() {
        return nome;
    }

    public PlanoHospedagem getPlano() {
        return plano;
    }

    public List<ServicoAgendado> getServicos() {
        return servicos;
    }
}
