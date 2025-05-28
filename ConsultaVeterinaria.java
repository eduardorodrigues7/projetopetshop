public class ConsultaVeterinaria implements Servico {
    public String getNome() { return "Consulta Veterinária"; }
    public double getPreco(Pet pet) { return 100.0; }
    public int getDuracaoMinutos() { return 60; }
}