package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class BancoDePalavras.
 */
public class BancoDePalavras{
    
    /** The times. */
    private List <String> times; 
    
    /** The filmes. */
    private List <String> filmes;
    
    /** The jogos. */
    private List <String> jogos;
    
    /** The series. */
    private List <String> series;
    
    /** The animes. */
    private List <String> animes;
    
    /** The programacao. */
    private List <String> programacao;

    /**
     * Instantiates a new banco de palavras.
     */
    public BancoDePalavras(){
        times = new ArrayList<>();
        filmes = new ArrayList<>();
        jogos = new ArrayList<>();
        series = new ArrayList<>();
        animes = new ArrayList<>();
        programacao = new ArrayList<>();
    
        adcionarTimes();
        adcionarAnimes();
        adcionarFilmes();
        adcionarJogos();
        adcionarProgramacao();
        adcionarSeries();
    }

    /**
     * Adcionar times.
     */
    private void adcionarTimes(){
        times.add("SAO PAULO");
        times.add("FLAMENGO");
        times.add("BARCELONA");
        times.add("REAL MADRID");
        times.add("CRB");
        times.add("CSA");
        times.add("CORINTHIANS");
        times.add("GREMIO");
        times.add("ATLETICO MINEIRO");
        times.add("ATLETICO PARANAENSE");
    }
    
    /**
     * Adcionar filmes.
     */
    private void adcionarFilmes(){
        filmes.add("TITANIC");
        filmes.add("O REI LEAO");
        filmes.add("TOY STORY");
        filmes.add("OS VINGADORES");
        filmes.add("TODO MUNDO EM PANICO");
        filmes.add("INVOCACAO DO MAL");
        filmes.add("JOGOS MORTAIS");
        filmes.add("GENTE GRANDE");
        filmes.add("SEMPRE AO SEU LADO");
        filmes.add("LAGOA AZUL");
        filmes.add("EXTERMINADOR DO FUTURO");
        filmes.add("VELOZES E FURIOSOS");
    }
    
    /**
     * Adcionar jogos.
     */
    private void adcionarJogos(){
        jogos.add("MINECRAFT");
        jogos.add("FIFA");
        jogos.add("LEAGUE OF LEGENDS");
        jogos.add("HABBO");
        jogos.add("GOD OF WAR");
        jogos.add("PERFECT WORLD");
        jogos.add("CALL OF DUTY");
        jogos.add("GRAND THEFT AUTO");
        jogos.add("DOTA");
        jogos.add("POU");
        jogos.add("ANGRY BIRDS");
    }
    
    /**
     * Adcionar series.
     */
    private void adcionarSeries(){
        series.add("DOCTOR WHO");
        series.add("THE WALKING DEAD");
        series.add("GREY S ANATOMY");
        series.add("BLACK MIRROR");
        series.add("GAME OF THRONES");
        series.add("THE BIG BANG THEORY");
        series.add("SUPERNATURAL");
        series.add("GRIMM");
        series.add("THE UMBRELLA ACADEMY");
        series.add("BROOKLYN NINE NINE");
        series.add("FRIENDS");
        series.add("PRISON BREAK");
        series.add("THE GOOD PLACE");
    }
    
    /**
     * Adcionar animes.
     */
    private void adcionarAnimes(){
        animes.add("NARUTO");
        animes.add("DRAGON BALL");
        animes.add("TOKYO GHOUL");
        animes.add("SWORD ART ONLINE");
        animes.add("DR STONE");
        animes.add("ANOTHER");
        animes.add("VIOLET EVERGARDEN");
        animes.add("BLACK CLOVER");
        animes.add("ONE PUNCH MAN");
    }
    
    /**
     * Adcionar programacao.
     */
    private void adcionarProgramacao(){
        programacao.add("BUG");
        programacao.add("JAVA");
        programacao.add("DEBUG");
        programacao.add("JAVASCRIPT");
        programacao.add("HELLO WORLD");
        programacao.add("GAMBIARRA");
        programacao.add("VARIAVEL");
    }

    /**
     * Sortear palavra.
     *
     * @param palavra the palavra
     * @return the string
     */
    public String sortearPalavra(String palavra){
        Random gerador = new Random();
        if (palavra.equals("TIMES")){ 
            int index = gerador.nextInt(this.times.size());
            return times.get(index); 
        }
        if (palavra.equals("FILMES")){ 
            int index = gerador.nextInt(this.filmes.size()); 
            return filmes.get(index); 
        }
        if (palavra.equals("JOGOS")){ 
            int index = gerador.nextInt(this.jogos.size()); 
            return jogos.get(index); 
        }
        if (palavra.equals("SERIES")){
            int index = gerador.nextInt(this.series.size());
            return series.get(index);
        }
        if (palavra.equals("ANIMES")){
            int index = gerador.nextInt(this.animes.size());
            return animes.get(index); 
        }
        else { 
            int index = gerador.nextInt(this.programacao.size());
            return programacao.get(index);
        }     
    }
}
