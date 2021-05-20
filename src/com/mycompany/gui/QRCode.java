package com.mycompany.gui;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
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
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
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


public class QRCode extends Form{
 public QRCode(Form previous) {
	 super(BoxLayout.y());
	 
	 String urlQR = "https://chart.googleapis.com/chart?cht=qr&chl=%22%20+%20stringQr%20+%20%22&choe=UTF-8&chs=500x500";
     Image blue = Image.createImage(500, 500, 0xff0000ff);
     EncodedImage enc = EncodedImage.createFromImage(blue, false);
     URLImage imgQR = URLImage.createToStorage(enc,  "Qr", urlQR);
     
     ImageViewer imageQR = new ImageViewer(imgQR);
     Label sl=new Label("Votre QR Code:");
     addAll(sl,imageQR);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->{ 
    	 OrganiserEventForm oe =new OrganiserEventForm();
    	 previous.showBack(); 
    	 });
	 
 }
   
    
 }