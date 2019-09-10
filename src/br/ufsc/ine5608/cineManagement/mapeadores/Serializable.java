package br.ufsc.ine5608.cineManagement.mapeadores;

import java.io.*;
import java.util.HashMap;

public class Serializable {

    private HashMap<String, Usuario> dadosUsuarios = new HashMap<>();
    private final String filename = "usuarios.cine";

    public Serializable(){
        load();
    }

    public Usuario get(String cpf){
        return dadosUsuarios.get(cpf);
    }

    public void put(Usuario usuario){
        dadosUsuarios.put(usuario.getCpf(), usuario);
        persist();
    }

    public void persist(){
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(dadosUsuarios);
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
            this.dadosUsuarios = (HashMap<String, Usuario>) objIn.readObject();
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

    public void remove(Usuario usuario){
        dadosUsuarios.remove(usuario.getCpf());
    }
}
