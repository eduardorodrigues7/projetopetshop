public class Passeio implements Servico {
    public String getNome() { return "Passeio"; }
    public double getPreco(Pet pet) { return 20.0; }
    public int getDuracaoMinutos() { return 60; }
}