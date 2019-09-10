package br.ufsc.ine5608.cineManagement.mapeadores;

import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Usuario;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorSala {

    private HashMap<String, SalaCinema> dadosSala = new HashMap<>();
    private final String filename = "sala.dados";

    public MapeadorSala(){
        load();
    }

    public SalaCinema get(String codigo){
        return dadosSala.get(codigo);
    }

    public void put(SalaCinema sala){
        dadosSala.put(sala.getNome(), sala);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(dadosSala);
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
            this.dadosSala = (HashMap<String, SalaCinema>) objIn.readObject();
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

    public void remove(SalaCinema sala){
        dadosSala.remove(sala.getNome());
        persist();
    }

    public Collection<SalaCinema> getList() {
        return dadosSala.values();
    }

    public boolean listaVazia() {
        return dadosSala.isEmpty();
    }

    public int tamanhoLista() {
        return dadosSala.size();
    }
}
