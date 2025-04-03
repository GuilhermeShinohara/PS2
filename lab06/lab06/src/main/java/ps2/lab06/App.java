package ps2.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private ProfessorRepo professorRepo;

    @Autowired
    private FaculdadeRepo faculdadeRepo;

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        out.println("# Gerenciador de Professores e Faculdades!");
        boolean sair = false;
        while (!sair) {
            out.println("\nMenu");
            out.println("(1) Cadastrar Faculdade");
            out.println("(2) Listar Faculdades");
            out.println("(3) Cadastrar Professor");
            out.println("(4) Listar Professores");
            out.println("(5) Sair");
            out.print("# Escolha uma opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarFaculdade();
                    break;
                case 2:
                    listarFaculdades();
                    break;
                case 3:
                    cadastrarProfessor();
                    break;
                case 4:
                    listarProfessores();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarFaculdade() {
        out.println("\nCADASTRAR NOVA FACULDADE");
        out.print("Nome da nova faculdade: ");
        String nome = entrada.nextLine();
        out.print("Ano da fundação da faculdade: ");
        int ano = Integer.parseInt(entrada.nextLine());
    
        Faculdade f = new Faculdade(nome, ano);
        faculdadeRepo.save(f);
        out.println("Faculdade cadastrada com sucesso!");
    }
    

    private void listarFaculdades() {
        List<Faculdade> faculdades = (List<Faculdade>) faculdadeRepo.findAll();
        out.println("\nFaculdades cadastradas:");
        for (Faculdade f : faculdades) {
            out.println(f.getId() + " - " + f.getNome());
        }
    }

    private void cadastrarProfessor() {
        out.print("Nome do novo professor: ");
        String nome = entrada.nextLine();
        out.print("CPF do novo professor: ");
        String cpf = entrada.nextLine();
        out.print("Matrícula do novo professor: ");
        int matricula = Integer.parseInt(entrada.nextLine());

        out.println("Faculdade do novo professor (selecione um dos números abaixo)");
        List<Faculdade> faculdades = (List<Faculdade>) faculdadeRepo.findAll();
        for (Faculdade f : faculdades) {
            out.println("- (" + f.getId() + ") " + f.getNome());
        }
        out.print("Digite o número da faculdade: ");
        int faculdadeId = Integer.parseInt(entrada.nextLine());
        Faculdade faculdade = faculdadeRepo.findById((long) faculdadeId).orElse(null);

        if (faculdade != null) {
            Professor p = new Professor(nome, cpf, matricula, faculdade);
            professorRepo.save(p);
            out.println("Professor cadastrado!");
        } else {
            out.println("Faculdade não encontrada!");
        }
    }

    private void listarProfessores() {
        List<Professor> professores = (List<Professor>) professorRepo.findAll();
        out.println("\nID    NOME          CPF          MATRÍCULA     FACULDADE");
        for (Professor p : professores) {
            out.printf("%-5d %-12s %-12s %-10d %-20s\n", p.getId(), p.getNome(), p.getCpf(), p.getMatricula(), p.getFaculdade().getNome());
        }
    }
}
