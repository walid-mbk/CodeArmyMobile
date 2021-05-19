/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.entities.Matiere;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.serviceCat;
import com.mycompany.myapp.services.ServiceMatiere;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListMatiere extends Form {
      public  ListMatiere(Form previous) {

      
       setTitle("List Produit");
         
   
 
        
      
        ServiceMatiere es = new ServiceMatiere();
        ArrayList<Matiere> list = es.getAllProduit();

        {
           
            for (Matiere r : list) {

          
 
                Container c3 = new Container(BoxLayout.y());
                SpanLabel cat= new SpanLabel("Matiere :" + r.getNom_matiere());
                 SpanLabel cat1= new SpanLabel("Coefficient  :" + r.getCofficient());
                  SpanLabel cat3= new SpanLabel("Volume en heure :" + r.getVolume_h());
               //   SpanLabel cat2= new SpanLabel("Image :" + r.getImage());
                 // SpanLabel cat4= new SpanLabel("description:" + r.getDescription());
                 
               
               
                     
                       c3.add(cat);
                        c3.add(cat1);
                         c3.add(cat3);
                       //   c3.add(cat2);
                        //c3.add(cat4);
       
                         Button Delete =new Button("Delete","LoginButton");
                        
                         Font materialFont = FontImage.getMaterialDesignFont();
int size = Display.getInstance().convertToPixels(6, true);
                         materialFont = materialFont.derive(size, Font.BASELINE);
                      FontImage.setMaterialIcon(Delete, FontImage.MATERIAL_DELETE_FOREVER);
    
         c3.add(Delete);
           
                 Delete.getAllStyles().setBgColor(0xF36B08);
            Delete.addActionListener(e -> {
               Dialog alert = new Dialog("Warning");
                SpanLabel message = new SpanLabel("Are you sure you want to delete your matiere?\nThis action once done cannot be reverted!");
                alert.add(message);
                Button ok = new Button("Proceed");
                Button cancel = new Button(new Command("Cancel"));
                //User clicks on ok to delete account
                ok.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent evt) {
                       es.Delete(r.getId_matiere());
                     
                        alert.dispose();
                        refreshTheme();
                    }
                    
                }
                
                
                );

                alert.add(cancel);
                alert.add(ok);
                alert.showDialog();
                
                new ListMatiere(previous).show();
              
                
             
            });
                       
                        
           System.out.println("");
              
  add(c3);
              
            
          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
            }
          
        }
     
    }
    
}
