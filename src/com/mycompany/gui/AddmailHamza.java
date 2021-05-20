/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author eya
 */
public class AddmailHamza extends Form{

    public AddmailHamza(Form previous) {


        setTitle("Envoyer un Email");
        setLayout(BoxLayout.y());

   TextField adress=new TextField("","Veillez entrer l'adress mail du destinataire  ");
         addStringValue("Adress :",adress);
    TextField object=new TextField("","Veillez enter l'objet de l'Email ");
         addStringValue("Objet :",object);
    TextField mail=new TextField("","Veillez enter le text ");
    addStringValue("Mail:",mail);

           Button btnAjouter=new Button("Envoyer");
        addStringValue("",btnAjouter);

        btnAjouter.addActionListener(new ActionListener()


        {


            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((mail.getText().length()==0))
                    Dialog.show("Alerte", "Veillez remplir tous les champs", new Command("OK"));
                else
                {   try {
                    mailUtilHamza.sendMail(adress.getText(), "excellenceacademy878@gmail.com","freefire1234",object.getText(), mail.getText());
                    } catch (Exception ex) {

                    }
                       }

                }



        });


                 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente

    }

    private void addStringValue(String s ,Component v) {
         add(BorderLayout.west  (new Label(s,"PaddedLabel")).add(BorderLayout.CENTER,v));
    }


}









