package br.ufsc.ine5608.cineManagement.mapeadores;

import br.ufsc.ine5608.cineManagement.models.Filme;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorFilme {

    private HashMap<String, Filme> dadosFilmes = new HashMap<>();
    private final String filename = "filmes.dados";

    public MapeadorFilme(){
        load();
    }

    public Filme get(String codigo){
        return dadosFilmes.get(codigo);
    }

    public void put(Filme filme){
        dadosFilmes.put(Integer.toString(filme.getCodigo()), filme);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(dadosFilmes);
            objOut.flush();
            fileOut.flush();
            objOut.close();
            fileOut.close();
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public  void load(){
        try {
            FileInputStream fileOut = new FileInputStream(filename);
            ObjectInputStream objIn = new ObjectInputStream(fileOut);
            this.dadosFilmes = (HashMap<String, Filme>) objIn.readObject();
            objIn.close();
            fileOut.close();
        } catch (ClassNotFoundException e){
            System.out.println("Arquivo inválido");
            persist();
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void remove(String codigo){
        dadosFilmes.remove(codigo);
        persist();
    }

    public Collection<Filme> getList() {
        return dadosFilmes.values();
    }

    public boolean listaVazia() {
        return dadosFilmes.isEmpty();
    }

    public int tamanhoLista() {
        return dadosFilmes.size();
    }
}
