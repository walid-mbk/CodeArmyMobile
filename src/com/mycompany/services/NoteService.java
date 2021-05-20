/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.entite.MatiereType;
import com.mycompany.entite.Note;
import com.mycompany.entite.NoteType;
import com.mycompany.entite.UserType;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import com.mycompany.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class NoteService {
        public ArrayList<Note> tasks;
    public ArrayList<UserType> ta;
    public ArrayList<NoteType> ta2;
    public ArrayList<MatiereType> ta3;

    public static NoteService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;



       public NoteService() {
         req = new ConnectionRequest();
    }

    public static NoteService getInstance() {
        if (instance == null) {
            instance = new NoteService();
        }
        return instance;
    }


       public boolean addTask(Note t) {
        String url = Statics.BASE_URL + "/setnoti/" + t.getId(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    ArrayList<NoteType> listall1 = new ArrayList<>();

public ArrayList<NoteType> parseTasks(String jsonText){
        try {

            tasks=new ArrayList<>();

            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json


            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));


            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");


            for(Map<String,Object> obj : list){

                Note t = new Note();

                t.setId(obj.get("id").toString());
              //  JsonArray array = new obj.getJSONArray("user" );
            //    for (int i = 0 ; i<array.length();i++)
             //   {
                  //  t.setUser_id(array.getJSONObject(i).getString("nom"));

              //  }
                t.setUser_id(obj.get("user").toString());
             //   String st = obj.get("user : {id}").toString();
             //   st = st.replace(':', ' ').replace('{', ' ').replace('}', ' ').replace('=', ' ').replace('i', ' ').replace('d', ' ');
             //   double d = Double.parseDouble(st); //Decimal
             //   int i = (int)d;
             //   int a = i ;
             //   System.out.print("a===="+a);
             //   String np = getnp(a) ;
             //   t.setUser_id(np);

                t.setMatiere_id(obj.get("matiere").toString());
                t.setClasse_id(obj.get("classe").toString());
                t.setNote(obj.get("note").toString());

                tasks.add(t);


                NoteType notetyp = new NoteType() ;
               notetyp.note = t.getNote() ;
               notetyp.id = t.getUser_id() ;
                listall1.add(notetyp) ;
            }


        } catch (IOException ex) {

        }

        return listall1;
    }

    public ArrayList<UserType> parseTasksnp(String jsonText){

        try {

            ta=new ArrayList<>();

            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json


            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));


            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");

            int i = 1 ;
            for(Map<String,Object> obj : list){


                UserType t = new UserType();

                t.id = i ;

               t.setNom(obj.get("nom").toString());

              t.setPrenom(obj.get("prenom").toString());

                ta.add(t);
                i = i+1 ;
            }


        } catch (IOException ex) {

        }

        return ta;
    }

    public ArrayList<NoteType> parseTasksnpe(String jsonText){

        try {

            ta2=new ArrayList<>();

            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json


            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));


            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");

            int i = 1 ;
            for(Map<String,Object> obj : list){


                NoteType t = new NoteType();



                t.id=(obj.get("matiere").toString());

                t.note=(obj.get("note").toString());

                ta2.add(t);
                i = i+1 ;
            }


        } catch (IOException ex) {

        }

        return ta2;
    }

    public ArrayList<MatiereType> parseTasksnpe2(String jsonText){

        try {

            ta3=new ArrayList<>();

            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json


            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));


            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");

            int i = 1 ;
            for(Map<String,Object> obj : list){


                MatiereType t = new MatiereType();



                t.nommat=(obj.get("id").toString());

                ta3.add(t);
            }


        } catch (IOException ex) {

        }

        return ta3;
    }

              ArrayList<NoteType> listall = new ArrayList<>();

    public ArrayList<NoteType> getListalls(){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/getnoti");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                NoteService ser = new NoteService();
                listall = ser.parseTasks(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listall;
    }


    ArrayList<UserType> listall2 = new ArrayList<>();

    String np ;
    public ArrayList<UserType> getListallsnp(){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/getnp/7");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                NoteService ser = new NoteService();
                listall2 = ser.parseTasksnp(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listall2;
    }

    ArrayList<NoteType> listall3 = new ArrayList<>();

    public ArrayList<NoteType> getListallsnpe(){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/getmynote/"+7);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                NoteService ser = new NoteService();
                listall3 = ser.parseTasksnpe(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listall3;
    }


    public boolean Modifier(int id,int n) {

        String url = "http://127.0.0.1:8000/makenoti/editm/"+id+"/"+n; //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    ArrayList<MatiereType> listall4 = new ArrayList<>();

    public ArrayList<MatiereType> getListallsnpe2(){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/showmatieremobile");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                NoteService ser = new NoteService();
                listall4 = ser.parseTasksnpe2(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listall4;
    }



}
