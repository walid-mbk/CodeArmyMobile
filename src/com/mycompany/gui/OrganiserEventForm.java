package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entite.Evenement;
import com.mycompany.services.ServiceEvenement;




public class OrganiserEventForm extends Form{
	Resources theme ;

    public OrganiserEventForm() {
        setTitle("Organiser un evenement");
        setLayout(BoxLayout.y());

        TextField A = new TextField("","Nom_Evenement");
        TextField B= new TextField("", "date de l'evenement");
         TextField C = new TextField("","Responsable");
        TextField D= new TextField("", "Description");
        TextField E= new TextField("", "Nombre Des Places");
        Button btnValider = new Button("Valider");
        
        
        
      
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((A.getText().length()==0)||(B.getText().length()==0)||(C.getText().length()==0)||(D.getText().length()==0)||(E.getText().length()==0))
                    Dialog.show("Alert", "il y a un champ vide", new Command("OK"));
               
                else 
                {
                    try {
                        Evenement e = new Evenement(A.getText(),C.getText(), B.getText(), D.getText(), E.getText());
                       

                        if( ServiceEvenement.getInstance().addTask(e)) {
                            Dialog.show("Success","added successfully",new Command("Obtenir QRCode"));
                            OrganiserEventForm oef= new OrganiserEventForm();
                            QRCode qc=new QRCode(oef);
                            qc.show();
                        
                    
                        }
                              
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    refreshTheme();
                }
                    
                }
                
                
            
        });
                    
                
                
                
            
        
        
        addAll(A,B,C,D,E,btnValider);
        ListEvenement le=new ListEvenement();
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->{ le.showBack(); 
        ListEvenement lev= new ListEvenement();
        lev.refreshTheme();
        });
    }
    
    
}
