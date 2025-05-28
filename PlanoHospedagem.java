    public abstract class PlanoHospedagem {
    protected String nomePlano;
    protected double tarifaHora;

    public PlanoHospedagem(String nomePlano, double tarifaHora) {
        this.nomePlano = nomePlano;
        this.tarifaHora = tarifaHora;
    }

    public double calcularTarifa(long horas) {
        return tarifaHora * horas;
    }

    public String getNomePlano() {
        return nomePlano;
    }
}

