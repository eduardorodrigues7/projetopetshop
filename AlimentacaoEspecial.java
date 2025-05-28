public class AlimentacaoEspecial implements Servico {
    public String getNome() { return "Alimentação Especial"; }
    public double getPreco(Pet pet) { return 25.0; }
    public int getDuracaoMinutos() { return 15; }
}