/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.radd.model;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Piotr
 */
public interface NoteModel {
    
    public static enum Action {
        OPEN_FILE, OPEN_ERROR
    };
    
    public String getOpenFilePath();

    public FileFilter getFileFilter();

    public void openFile(File file);
    
    public String getFileContent();

    public String getErrorMsg();
    

}
