package ps2.lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
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
				out.println("    MENU    ");
				out.println("(1) Criar Faculdade");
				out.println("(2) Listar Faculdades");
				out.println("(3) Criar Professor");
				out.println("(4) Listar Professores");
				out.println("(0) Sair");
				out.println("Escolha uma opção:  ");

				int opcao = Integer.parseInt(entrada.nextLine());

				switch (opcao) {
					case 0:
						sair = true;
						break;
					
					case 1:

						break;
					
					case 2:

						break;

					case 3:
						System.out.println("Digite o nome do professor:  ");
						String NomeNovoProfessor = entrada.nextLine();

						System.out.println("Digite o CPF do professor:  ");
						String cpfNovoProfessor = entrada.nextLine();

						System.out.println("Matrícula do novo professor:  ");
						String matriculaNovoProfessor = entrada.nextLine();
						break;

					case 4:

						break;
					
					default:
						System.out.println("Opção Inválida");
						break;
				}


}



		Faculdade f = new Faculdade("Faculdade de Engenharia", 1890);
		faculdadeRepo.save(f);
		out.println("id da nova faculdade: " + f.getId());

		out.println("Pressione ENTER para terminar o programa...");
		entrada.nextLine();
	}
}