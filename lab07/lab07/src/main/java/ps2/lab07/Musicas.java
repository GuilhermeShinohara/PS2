package ps2.lab07;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Musicas{
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String compositor;
    private int ano;
    
    public Musicas(String t, String c, int a){
        titulo = t;
        compositor = c;
        ano = a;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setCompositor (String compositor){
        this.compositor = compositor;
    }

    public String getCompositor (){
        return compositor;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getAno(){
        return ano;
    }

}