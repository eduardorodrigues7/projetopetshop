import java.time.LocalDateTime;

public class ServicoAgendado {
    private Servico servico;
    private LocalDateTime dataHora;

    public ServicoAgendado(Servico servico, LocalDateTime dataHora) {
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
