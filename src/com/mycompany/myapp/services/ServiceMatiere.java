/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Matiere;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceMatiere {
      public ArrayList<Matiere> matiere;
    
    public static ServiceMatiere instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceMatiere() {
         req = new ConnectionRequest();
    }

    public static ServiceMatiere getInstance() {
        if (instance == null) {
            instance = new ServiceMatiere();
        }
        return instance;
    }

   
    public ArrayList<Matiere> parseProduit(String jsonText){
        try {
           matiere=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> ProduitListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)ProduitListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
              Matiere t = new Matiere();
                float id = Float.parseFloat(obj.get("id").toString());
                float coef = Float.parseFloat(obj.get("coefficient").toString());
                float volume = Float.parseFloat(obj.get("volume_h").toString());
                t.setId_matiere((int)id);
                  t.setCofficient((int)coef);
                  t.setVolume_h((int)volume);
                  t.setNom_matiere(obj.get("nom_matiere").toString());
                   // t.setReference(obj.get("reference").toString());
                   // t.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        // t.setImage(obj.get("image").toString());
                      //t.setDescription(obj.get("Description").toString());
             
                matiere.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return  matiere;
    }
    
    public ArrayList< Matiere> getAllProduit(){
         String url = Statics.BASE_URL + "/matiere/showmatieremobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                matiere = parseProduit (new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return matiere ;
    }
    
    public boolean  Delete(int id){
       String url = "http://127.0.0.1:8000/matiere/supprimermobile/"+id;

        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
      
      
      }
    
}
