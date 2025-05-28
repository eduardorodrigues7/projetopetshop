import java.time.LocalDateTime;

public class Fatura {
    private Pet pet;
    private LocalDateTime horaSaida;

    public Fatura(Pet pet) {
        this.pet = pet;
        this.horaSaida = LocalDateTime.now();
    }

    public void emitir() {
        long horas = java.time.Duration.between(pet.getHoraEntrada(), horaSaida).toHours();
        double total = pet.calcularTotal(horas);

        System.out.println("---- Fatura ----");
        System.out.println("Pet: " + pet.getNome());
        System.out.println("Entrada: " + pet.getHoraEntrada());
        System.out.println("Saída: " + horaSaida);
        System.out.println("Plano: " + pet.getPlano().getNomePlano());
        System.out.println("Serviços:");
        for (ServicoAgendado s : pet.getServicos()) {
            System.out.println(s.getServico().getNome() + " - " + s.getDataHora());
        }
        System.out.println("Total a pagar: R$" + total);
    }
}
