package br.ufsc.ine5608.cineManagement.mapeadores;

import br.ufsc.ine5608.cineManagement.models.ProdutoBomboniere;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class MapeadorBomboniere {

    private HashMap<String, ProdutoBomboniere> dadosBomboniere = new HashMap<>();
    private final String filename = "bomboniere.dados";

    public MapeadorBomboniere(){
        load();
    }

    public ProdutoBomboniere get(String codigoBarras){
        return dadosBomboniere.get(codigoBarras);
    }

    public void put(ProdutoBomboniere produto){
        dadosBomboniere.put(produto.getCodigoBarra(), produto);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(dadosBomboniere);
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
            this.dadosBomboniere = (HashMap<String, ProdutoBomboniere>) objIn.readObject();
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

    public void remove(ProdutoBomboniere produto){
        dadosBomboniere.remove(produto.getCodigoBarra());
        persist();
    }

    public Collection<ProdutoBomboniere> getList() {
        return dadosBomboniere.values();
    }

    public boolean listaVazia() {
        return dadosBomboniere.isEmpty();
    }

    public int tamanhoLista() {
        return dadosBomboniere.size();
    }
}
