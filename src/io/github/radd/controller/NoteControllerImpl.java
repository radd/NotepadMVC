/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.radd.controller;

import io.github.radd.model.NoteModel;
import io.github.radd.view.MainFrame;

/**
 *
 * @author Piotr
 */
public class NoteControllerImpl implements NoteController {
    
    private NoteModel model;
    private MainFrame view;
    
     public NoteControllerImpl(NoteModel model) {
        this.model = model;
        
        //Create view and show it
        view = new MainFrame(this, model);
        view.showView();
    }
    
}
