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
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListNoteForm extends Form {

    public ListNoteForm() {
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public ListNoteForm(Form previous) {
          setTitle("Liste de notes");
            SpanLabel sp = new SpanLabel();
        setLayout(BoxLayout.y());

        //  sp.setText();
      //  sp.setText("this is : "+ NoteService.getInstance().getListallsnp().toString());
//   sp.setText("this is : "+ NoteService.getInstance().getListallsnpe().toString());
        // add(sp) ;
        NoteService es = new NoteService();
        ArrayList<NoteType> list3 = es.getListallsnpe();

        ArrayList<UserType> list = es.getListallsnp();
        ArrayList<NoteType> list2 = es.getListalls();


        int i =0 ;
            for (UserType r : list) {

                Container c3 = new Container(BoxLayout.y());
                SpanLabel cat = new SpanLabel("Nom :" + r.getNom());
                SpanLabel cat1 = new SpanLabel("Prenom  :" + r.getPrenom());

                c3.add(cat);
                c3.add(cat1);
                TextField cat2 = new TextField() ;
                cat2.setText(list2.get(i).note);

                  //  SpanLabel cat2 = new SpanLabel("Note :" + list2.get(i).note);
                    c3.add(cat2) ;
                Button Modifier =new Button("Modifier","Modifier");
                c3.add(Modifier) ;


                Modifier.addActionListener(new ActionListener() {
                    Dialog alert = new Dialog("Warning");
                    Button cancel = new Button(new Command("Cancel"));

                    public void actionPerformed(ActionEvent evt) {
                        if (Integer.parseInt(cat2.getText())>20)
                        { alert.add("La note doit etre inferieur à 20 ") ;
                            alert.add(cancel);
                            cat2.setText("");
                            alert.showDialog();
                        }
                        else if (((Integer.parseInt(cat2.getText()))<0) )
                        {     alert.add("La note doit etre superieur à 0") ;
                            alert.add(cancel);
                            cat2.setText("");
                            alert.showDialog();}
                        else
                        es.Modifier(r.id,Integer.parseInt(cat2.getText())) ;
                        myapi();
                    }

                }  );

                add(c3) ;

                i = i+1;
            }



          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente

    }

    public void myapi () {

        LocalNotification n = new LocalNotification();
        n.setId("notification");
        n.setAlertBody("Your Bike added ");
        n.setAlertTitle("Succefull !!");
        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
    }


}
