package com.mycompany.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.RGBImage;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entite.Evenement;
import com.mycompany.entite.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 *
 * @author souhaib
 */
public class ServiceEvenement {
        public ArrayList<Evenement> tasks;
     public static ServiceEvenement instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
     public ServiceEvenement() {
         req = new ConnectionRequest();
    }
        public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    }
        public ArrayList<Evenement> listAlll(String jsonText){
        try {
            tasks=new ArrayList<Evenement>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
              Evenement e = new Evenement();
              float id = Float.parseFloat(obj.get("id_evenement").toString());
              e.setId((int)id);
              e.setNom_evenement(obj.get("nom_evenement").toString());
              e.setNbr_place(obj.get("nbr_place").toString());
              e.setDescription(obj.get("description").toString());
              e.setResponsable(obj.get("responsable").toString());
              e.setDate(obj.get("date_evenement").toString());
             
            
       
              
            
              
               
                
            
                tasks.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }
          ArrayList<Evenement> listall = new ArrayList<>();
    public ArrayList<Evenement> getListalls(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8000/Affichemobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceEvenement ser = new ServiceEvenement();
                listall = ser.listAlll(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listall;
    }
    
    public boolean addTask(Evenement e) {
        String url = Statics.BASE_URL + "/AddMobile?nome=" + e.getNom_evenement()+"&nbp="+  e.getNbr_place()+"&desc=" + e.getDescription()+"&resp="+ e.getDate()+"&date="+  e.getResponsable();
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
    
    public boolean  Delete(int id){
        String url = "http://127.0.0.1:8000/Deletemobile/"+id;
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
