/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author ASUS
 */
public class HomeEnseignant extends Form {
    Form current ;
    public HomeEnseignant() {
        current = this ;
        setTitle("Espace Enseignant");
        setLayout(BoxLayout.y());

        Toolbar tb = current.getToolbar();
        Container topBar = BorderLayout.east(new Label("Go"));
        tb.addComponentToSideMenu(topBar);

        tb.addMaterialCommandToSideMenu("Gestion Notes", FontImage.MATERIAL_WEB, e -> new ListNoteForm(current).show());
      //  tb.addMaterialCommandToSideMenu("Gestion Cours", FontImage.MATERIAL_BOOK,  e -> new AddNoteForm(current).show());
        tb.addMaterialCommandToSideMenu("Contacter", FontImage.MATERIAL_ARROW_CIRCLE_UP,e -> new AddmailHamza(current).show());
        tb.addMaterialCommandToSideMenu("A propos", FontImage.MATERIAL_INFO, e -> {});
        tb.addMaterialCommandToSideMenu("Deconnexion", FontImage.MATERIAL_INFO, e -> {});


    }


}
