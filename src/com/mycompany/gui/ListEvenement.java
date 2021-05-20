package com.mycompany.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.entite.Evenement;
import com.mycompany.entite.Stage;
import com.mycompany.services.ServiceEvenement;
import com.mycompany.services.ServiceStage;
import com.codename1.io.CharArrayReader;

import java.util.ArrayList;

/**
 *
 * @author souhaib
 */
public class ListEvenement extends Form{
 public ListEvenement() {
   
    
       super(BoxLayout.y());
       setTitle("Liste des Evenements");
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
               


       
                   ServiceEvenement spp=new ServiceEvenement();
                ArrayList<Evenement>pl=spp.getListalls();
           //  setupSideMenu();
     
            
        
                     for(int iter = 0 ; iter < spp.getListalls().size() ; iter++) {
                         final Evenement p=pl.get(iter);
                       
                        
                            SpanLabel sp1= new SpanLabel("Nom:"+ pl.get(iter).getNom_evenement());
                            SpanLabel sp2= new SpanLabel("Date:"+ pl.get(iter).getDate());
                            SpanLabel sp3= new SpanLabel("description:"+ pl.get(iter).getDescription());
                            SpanLabel sp4= new SpanLabel("responsable:"+ pl.get(iter).getResponsable());
                            Label nb= new Label("nbr_place:"+p.getNbr_place());
                            sp1.getSelectedStyle().setBgColor(0xffff);
                            Button btnd=new Button("supprimer");
                            
                            btnd.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ev) {
                                    
                                             spp.Delete(p.getId());
                                             ListEvenement le=new ListEvenement();
                                             le.show();
                                             refreshTheme();
                                             Dialog.show("Success","event deleted succesfully",new Command("OK"));
                                             
                                   
                                      }
                           });
                             
                         addAll(sp1,sp2,sp3,sp4,nb,btnd);
                        
                         
                          
                         
                                  
                              
                          
                       
                     }
                     Button btnorg = new Button("Organiser Un Evenement");
                     addAll(btnorg);
                     btnorg.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent evt) {
                             OrganiserEventForm org =new OrganiserEventForm();
                             org.show();
                             
                         }});
                     
                     Button btnref = new Button("Actualiser");
                     addAll(btnref);
                     
                     btnref.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent evt) {
                        	 ListEvenement le=new ListEvenement();
                             le.show();
                         }});
                     
                     }
 

}