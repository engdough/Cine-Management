package br.ufsc.ine5608.cineManagement.mapeadores;

import br.ufsc.ine5608.cineManagement.models.SalaCinema;
import br.ufsc.ine5608.cineManagement.models.Sessao;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorSessao {
    private HashMap<String, Sessao> dadosSessao = new HashMap<>();
    private final String filename = "sessao.dados";

    public MapeadorSessao(){
        load();
    }

    public Sessao get(String codigo){
        return dadosSessao.get(codigo);
    }

    public void put(Sessao sessao){
        dadosSessao.put(sessao.getCodigo(), sessao);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(dadosSessao);
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
            this.dadosSessao = (HashMap<String, Sessao>) objIn.readObject();
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
        dadosSessao.remove(codigo);
        persist();
    }

    public Collection<Sessao> getList() {
        return dadosSessao.values();
    }

    public boolean listaVazia() {
        return dadosSessao.isEmpty();
    }

    public int tamanhoLista() {
        return dadosSessao.size();
    }
}
