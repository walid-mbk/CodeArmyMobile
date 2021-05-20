/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUser;
import static com.codename1.ui.TextArea.ANY;
import com.codename1.ui.spinner.Picker;
import java.util.Date;
import java.util.Vector;
import javafx.scene.control.DatePicker;

/**
 * Signup UI
 *
 * @author Shai Almog
 */
public class SignUpForm extends BaseForm {

    public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
        
        TextField prenom = new TextField("", "prenom", 20, TextField.ANY);
        TextField nom = new TextField("", "nom", 20, TextField.ANY);
        Picker date = new Picker();
        date.setType(Display.PICKER_TYPE_DATE);
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField mail = new TextField("", "E-Mail", 20, TextField.EMAILADDR);
        TextField mdp = new TextField("", "Password", 20, TextField.PASSWORD);
        
          //role
   Vector<String> vectorRole;
   vectorRole = new Vector();
   vectorRole.add("Enseignant");
   vectorRole.add("Etudiant");   
   ComboBox<String>role=new ComboBox<>(vectorRole);
   
   
        prenom.setSingleLineTextArea(false);
        
        nom.setSingleLineTextArea(false);

        username.setSingleLineTextArea(false);

        mail.setSingleLineTextArea(false);
    
        mdp.setSingleLineTextArea(false);
        
        
        
        Button next = new Button("Sign Up");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> new SignInForm(res).show());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        Container content = BoxLayout.encloseY(
                new Label("Sign Up","LogoLabel"),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(username),
                createLineSeparator(),
                new Label("Date de naissance","TextField"),
                createLineSeparator(),
                date,
                createLineSeparator(),
                new FloatingHint(mail),
                createLineSeparator(),
                new FloatingHint(mdp),
                createLineSeparator(),
                role
                
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        next.addActionListener(e -> {
            ServiceUser.getInstance().signup(nom,prenom,username,mail,mdp,role,res);
            Dialog.show("Success","account is saved","ok",null);
            new SignInForm(res).show();
                    
        
        
        
        }
                
        );
    }
    
}
