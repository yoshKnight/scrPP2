package com.ungs.pp2.scrPP2;

import java.awt.EventQueue;
import java.io.IOException;
/*
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.pushingpixels.substance.api.skin.SubstanceChallengerDeepLookAndFeel;*/
/*SubstanceBusinessBlackSteelLookAndFeel;SubstanceBusinessLookAndFeel;
 * SubstanceChallengerDeepLookAndFeel;SubstanceDustCoffeeLookAndFeel;
 * SubstanceDustLookAndFeel;SubstanceEmeraldDuskLookAndFeel;
 * SubstanceGeminiLookAndFeel;SubstanceGraphiteAquaLookAndFeel;
 * SubstanceGraphiteGlassLookAndFeel;SubstanceMagellanLookAndFeel;
 * SubstanceMistSilverLookAndFeel;SubstanceSaharaLookAndFeel;*/

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.View.HomeView;
import com.ungs.pp2.scrPP2.textUtils.TextUserStoryMapper;
import com.ungs.pp2.scrPP2.utils.Logger;
import com.ungs.pp2.scrPP2.utils.UserStoryMapper;

public class MainScrum {
	public static void main( String[ ] args ) {

/*		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
//					TODO comente esta linea porque esta generando un exceso de informacion 
//					y rompio  la integracion continnua al generar un archivo de log mayr a 4M
//					Averiguar como deshabilitarlo para las pruebas o como deshabilitarle el log de errores. 
//					UIManager.setLookAndFeel(new SubstanceChallengerDeepLookAndFeel());
				} catch (Exception e) {
					JFrame.setDefaultLookAndFeelDecorated(false);
				}
			}
		});*/

		EventQueue.invokeLater( new Runnable() {
			@Override
			public void run() {

				//			try {
				//				OutputStream f = new FileOutputStream("/tmp/scrumMGR.log",true);
				//				Logger.setOutStream(f);
				//			} catch (FileNotFoundException e) {
				//				e.printStackTrace();
				//			}
				Logger.init();
				UserStoryMapper usMapper=null;
				try {
					usMapper = new TextUserStoryMapper();
					//llamar al plugin factory con el path de los plugins, para que los cargue
				} catch (RuntimeException | IOException e) {
					
//					e.printStackTrace();
				}
				
				HomeController controller = new HomeController(null,usMapper);

				HomeView view = new HomeView(controller);	
				view.setVisible( true );


			}});
	}}

