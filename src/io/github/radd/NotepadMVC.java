/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.radd;

import io.github.radd.controller.NoteControllerImpl;
import io.github.radd.model.NoteModelImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Piotr
 */
public class NotepadMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotepadMVC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NotepadMVC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NotepadMVC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NotepadMVC.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //</editor-fold>
        
        NoteModelImpl model = new NoteModelImpl();
        NoteControllerImpl controller = new NoteControllerImpl(model);
    }
    
}
