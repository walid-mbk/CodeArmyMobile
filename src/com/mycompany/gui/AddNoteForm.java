/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.mycompany.entite.MatiereType;
import com.mycompany.entite.Note;
import com.mycompany.entite.NoteType;
import com.mycompany.entite.UserType;
import com.mycompany.services.NoteService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AddNoteForm  extends Form{

    public AddNoteForm(Form previous) {
        setTitle("Mes notes");
        setLayout(BoxLayout.y());

        NoteService es = new NoteService();
        ArrayList<NoteType> list3 = es.getListallsnpe();
        ArrayList<MatiereType> list2 = es.getListallsnpe2();

        for (NoteType r : list3) {

            Container c3 = new Container(BoxLayout.y());
            SpanLabel cat2 = new SpanLabel("matiere :" + "Java");
            SpanLabel cat1 = new SpanLabel("Note :" + r.note);
          //  cat2.setText(list2.get(0).nommat);
            c3.add(cat2);
            c3.add(cat1);


            add(c3) ;

        }

          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente


    }



}
