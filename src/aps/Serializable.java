package aps;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import aps.Usuario;

public class Serializable {
    
    private HashMap<String, Usuario> dadosUsuarios = new HashMap<>();
    private final String filename = "mercado.loja";

    public Serializable(){
        load();
    }
        
    public Usuario get(Integer idLoja){
        return dadosUsuarios.get(idLoja);
    }

    public void put(Usuario usuario){
        dadosUsuarios.put(usuario.getCpf(), usuario);
        persist();
    }

    public ArrayList<Usuario> getList(){
        return  new ArrayList<>(dadosUsuarios.values());
    }

    public void persist(){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oo = new ObjectOutputStream(fout);
            oo.writeObject(dadosUsuarios);
            oo.flush();
            fout.flush();
            oo.close();
            fout.close();
            } catch (FileNotFoundException ex){
                System.out.println("arquivo nao encontrado");
            } catch (IOException exx){
                System.out.println(exx);
            }
        }
        
    public  void load(){
        try { 
            FileInputStream fin = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fin);
            this.dadosUsuarios = (HashMap<String, Usuario>) oi.readObject();
            oi.close();
            fin.close();
            } catch (ClassNotFoundException x){
                System.out.println("Arquivo invalido");
                persist();
            } catch (FileNotFoundException ex){
                System.out.println("Arquivo nao encontrado");
            } catch (IOException e){
                System.out.println(e);
            }
        }
        
    public void remove(Usuario usuario){
        dadosUsuarios.remove(usuario.getCpf());
    }    
}
