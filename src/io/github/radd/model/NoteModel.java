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

    public void saveFile();

    public void setEditFileContent(String text);

    public String getSaveFilePath();

    public void saveFile(File file);
    
    public static enum Action {
        OPEN_FILE, OPEN_ERROR, SAVE_NEW_FILE
    };
    
    public String getOpenFilePath();

    public FileFilter getFileFilter();

    public void openFile(File file);
    
    public String getFileContent();

    public String getErrorMsg();
    

}
