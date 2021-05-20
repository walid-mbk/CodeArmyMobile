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
import com.mycompany.entite.Stage;
import com.mycompany.entite.convention;
import com.mycompany.services.ServiceStage;

import java.util.ArrayList;

/**
 *
 * @author souhaib
 */
public class ListStage extends Form{
 public ListStage() {
   
    
	   super(BoxLayout.y());
       setTitle("Liste des Stages");
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
      
               


       
                   ServiceStage spp=new ServiceStage();
                ArrayList<Stage>pl=spp.getListalls();
           //  setupSideMenu();
     
            
        
                     for(int iter = 0 ; iter < spp.getListalls().size() ; iter++) {
                         final Stage p=pl.get(iter);
                       
                         MultiButton mb = new MultiButton();
                            SpanLabel sp1=new SpanLabel("email:"+ pl.get(iter).getEmail_societe());
                            SpanLabel sp2=new SpanLabel("pays:"+ pl.get(iter).getPays());
                            SpanLabel sp3=new SpanLabel("date debut:"+ pl.get(iter).getDate_debut());
                            SpanLabel sp4=new SpanLabel("date_fin:"+ pl.get(iter).getDate_fin());
                           // MultiButton mb1 = new MultiButton();
                            Label nb= new Label("type_stage:"+p.getType_stage());
                            Button btnpos=new Button("Postuler"); 
                            Button btnconv=new Button("Demander Convention"); 
                             
                         addAll(sp1,sp2,sp3,sp4,nb,btnconv,btnpos);
                          btnconv.addActionListener(new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent ev) {
                            	  
                                         convention c = new convention(p.getId());
                                         if (spp.demanderC(c)) {
                                        	 Dialog.show("Success","demande envoyée",new Command("Obtenir QRCode"));
                                        	 ListStage ls=new ListStage();
                                        	 QRCode qc=new QRCode(ls);
                                        	 qc.show();
                                             
                                        	 
                                         };
                                 
                                    }
                         });
                          
                          btnpos.addActionListener(new ActionListener() {
                              @Override
                              public void actionPerformed(ActionEvent ev) {
                            	  
                                         convention c = new convention(p.getId());
                                         if (spp.Postuler()) {
                                        	 Dialog.show("Success","Votre demande est en cours de traitement",new Command("OK"));
                                             
                                        	 
                                         };
                                 
                                    }
                         });
                       
                     }}}