import java.util.List;

public class Relatorio {
    public static void listarPetsPorEspecie(List<Pet> pets, String especie) {
        System.out.println("Pets da espécie: " + especie);
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(especie)) {
                System.out.println(p.getNome());
            }
        }
    }

    public static void listarPorPlano(List<Pet> pets, String plano) {
        System.out.println("Pets no plano: " + plano);
        for (Pet p : pets) {
            if (p.getPlano().getNomePlano().equalsIgnoreCase(plano)) {
                System.out.println(p.getNome());
            }
        }
    }
}
