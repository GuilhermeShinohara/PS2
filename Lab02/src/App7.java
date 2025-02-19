import banco.*;

public class App7 {
    public static void main(String[]args){
        Banco meuBanco = new Banco("Java");
        meuBanco.adicionar(new ContaInfinita(1111, 50));
        meuBanco.adicionar(new ContaBancaria(2222 , 99));
        meuBanco.adicionar(new ContaBancaria(3333, 1000));
        meuBanco.adicionar(new ContaInfinita(4444 , 999));
        meuBanco.premiarInfinitas();
        meuBanco.mostrar();
    }
}