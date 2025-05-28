public class Banho implements Servico {
    public String getNome() { return "Banho"; }
    public double getPreco(Pet pet) { return 30.0; }
    public int getDuracaoMinutos() { return 30; }
}