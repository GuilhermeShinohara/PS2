package ps2.lab07;

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
    private MusicasRepo musicasRepo;

    private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

	@Override
	public void run (String... args){
		out.println("   Gerenciador de Musicas");
		boolean sair = false;

		while(sair!= true){
			out.println("\nMenu");
            out.println("(1) Cadastrar musica");
            out.println("(2) Listar musicas");
            out.println("(3) Sair");
            out.print("Escolha uma opção: ");

			int opcao = Integer.parseInt(sc.nextLine());

			switch(opcao){
				case 1:
				    cadastrarMusica();
					break;
			    case 2:
				    listarMusicas();
                case 3:
				    sair = true;
					break;
				default:
				    out.println("Opção inserida inválida!");
			}
		}

	}

private void cadastrarMusica(){
	out.println("Cadastro de musica");
	out.print("Título da musica:");
	String titulo = sc.nextLine();

	out.print("Compositor da música: ");
	String compositor = sc.nextLine();

    out.print("Ano de lançamento: ");
	int ano = Integer.parseInt(sc.nextLine());

	Musicas m = new Musicas(titulo, compositor, ano);
	musicasRepo.save(m);
	out.println("Música cadastrada com sucesso");
}

private void listarMusicas(){
	List<Musicas> musicas = (List<Musicas>) musicasRepo.findAll();
	out.println("\nMusicas cadastradas: ");
	for (Musicas m : musicas){
		out.println(m.getId() +" -" + m.getTitulo());
	}
}

}
