import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class App {
    private static List<Pet> pets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Cadastrar Pet");
            System.out.println("2 - Agendar Serviço");
            System.out.println("3 - Emitir Fatura");
            System.out.println("4 - Relatório");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrarPet(sc);
                case 2 -> agendarServico(sc);
                case 3 -> emitirFatura(sc);
                case 4 -> gerarRelatorio(sc);
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void cadastrarPet(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Espécie: ");
        String especie = sc.next();
        System.out.print("Raça: ");
        String raca = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        System.out.print("Nome do tutor: ");
        String nomeTutor = sc.next();
        System.out.print("Contato do tutor: ");
        String contato = sc.next();

        System.out.print("Plano (1-Standard, 2-Premium, 3-VIP): ");
        int planoOpc = sc.nextInt();
        PlanoHospedagem plano = switch (planoOpc) {
            case 1 -> new Standard();
            case 2 -> new Premium();
            case 3 -> new VIP();
            default -> new Standard();
        };

        Tutor tutor = new Tutor(nomeTutor, contato);
        Pet pet = new Pet(nome, especie, raca, idade, peso, tutor, plano);
        pets.add(pet);

        System.out.println("Pet cadastrado!");
    }

    private static void agendarServico(Scanner sc) {
        System.out.print("Nome do Pet: ");
        String nome = sc.next();

        Pet pet = pets.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
        if (pet == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        System.out.println("Serviço (1-Banho, 2-Tosa, 3-Passeio, 4-Alimentação Especial, 5-Consulta): ");
        int serv = sc.nextInt();
        Servico servico = switch (serv) {
            case 1 -> new Banho();
            case 2 -> new Tosa();
            case 3 -> new Passeio();
            case 4 -> new AlimentacaoEspecial();
            case 5 -> new ConsultaVeterinaria();
            default -> new Banho();
        };

        System.out.println("Agendar para quando? (yyyy-MM-dd HH:mm): ");
        String data = sc.next() + " " + sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime horario;
try {
    horario = LocalDateTime.parse(data, formatter);
} catch (DateTimeParseException e) {
    System.out.println("Formato inválido. Use: yyyy-MM-dd HH:mm");
    return;
}
    }

    private static void emitirFatura(Scanner sc) {
        System.out.print("Nome do Pet: ");
        String nome = sc.next();
        Pet pet = pets.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);

        if (pet == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        Fatura fatura = new Fatura(pet);
        fatura.emitir();
    }

    private static void gerarRelatorio(Scanner sc) {
        System.out.print("Relatório por (1-Especie, 2-Plano): ");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            System.out.print("Espécie: ");
            String especie = sc.next();
            Relatorio.listarPetsPorEspecie(pets, especie);
        } else {
            System.out.print("Plano: ");
            String plano = sc.next();
            Relatorio.listarPorPlano(pets, plano);
        }
    }
}
