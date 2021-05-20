package com.mycompany.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entite.Evenement;
import com.mycompany.entite.Stage;
import com.mycompany.entite.convention;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author souhaib
 */
public class ServiceStage {
        public ArrayList<Stage> tasks;
     public static ServiceStage instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
     public ServiceStage() {
         req = new ConnectionRequest();
    }
        public static ServiceStage getInstance() {
        if (instance == null) {
            instance = new ServiceStage();
        }
        return instance;
    }
        public ArrayList<Stage> listAlll(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
              Stage s = new Stage();
             float id = Float.parseFloat(obj.get("id").toString());
              s.setId((int)id);
              s.setPays(obj.get("pays").toString());
              s.setDate_debut(obj.get("date_debut").toString());
              s.setDate_fin((obj.get("date_fin").toString()));
              s.setEmail_societe(obj.get("Email_Societe").toString());
              s.setType_stage(obj.get("type_stage").toString());
             
            
              
               
                
            
                tasks.add(s);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
          ArrayList<Stage> listall = new ArrayList<>();
    public ArrayList<Stage> getListalls(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/stageamobile");
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceStage ser = new ServiceStage();
                listall = ser.listAlll(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listall;
    }
    
    public boolean demanderC(convention c) {
        String url = "http://127.0.0.1:8000/stage/conventionmobile?id=" + c.getId_stage();
        req.setUrl(url);
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
    
    public boolean Postuler() {
        String url = "http://127.0.0.1:8000/stage/postuler" ;
        req.setUrl(url);
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
    
    
}
