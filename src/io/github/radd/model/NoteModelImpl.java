/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.radd.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Piotr
 */
public class NoteModelImpl extends Observable implements NoteModel {

    private String openFilePath;
    private String saveFilePath;
    private FileNameExtensionFilter fileFilter;
    private File currFile;
    private String fileContent;
    private String editFileContent;
    
    private String errorMessage;
    
    public NoteModelImpl() {
        initModel();
    }
    
    private void initModel() {
        setOpenFilePath();
        setFileFilter();
        setSaveFilePath();
    }
    
    private void changeStateAndNotify(Action a) {
        setChanged();
        notifyObservers(a);
    }
    
    @Override
    public String getErrorMsg() {
        return errorMessage;
    }

    @Override
    public String getOpenFilePath() {
        return openFilePath;
    }

    private void setOpenFilePath() {
        String path = System.getProperty("user.home") + "/Documents";
        if(path == null || path.isEmpty())
            path = "C:";  
        openFilePath = path;
    }
        
    @Override
    public FileFilter getFileFilter() {
        return fileFilter;
    }
    
    private void setFileFilter() {
        fileFilter = new FileNameExtensionFilter("Text file", "txt");
    }

    @Override
    public void openFile(File file) {
        if(file != null) {
            try {
                readFile(file);
                currFile = file;
                editFileContent = fileContent;
                setSaveFilePath((currFile.getParentFile()).getAbsolutePath());
                changeStateAndNotify(Action.OPEN_FILE);
            } catch (IOException ex) {
                errorMessage = ex.getMessage();
                changeStateAndNotify(Action.OPEN_ERROR);
            }   
        } 
        else {
            errorMessage = "No file selected";
            changeStateAndNotify(Action.OPEN_ERROR);
        }

    }

    //ISSUE format encoding
    private void readFile(File file) throws IOException {
        fileContent = Files.lines(Paths.get(file.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getFileContent() {
        return fileContent;
    }

    @Override
    public void setEditFileContent(String text) {
        editFileContent = text;
    }
    
    @Override
    public void saveFile() {
        if(editFileContent != null)
            if(currFile == null)
                getNewFileToSave();


    }
    
    @Override
    public void saveFile(File file) {
        if(editFileContent != null)
            saveNewFile(file);
    }

    private void getNewFileToSave() {
        changeStateAndNotify(Action.SAVE_NEW_FILE);
    }

    @Override
    public String getSaveFilePath() {
        return saveFilePath;
    }
    
    private void setSaveFilePath() {
        String path = System.getProperty("user.home") + "/Documents";
        if(path == null || path.isEmpty())
            path = "C:";  
        saveFilePath = path;
    }

    private void setSaveFilePath(String path) {
        if(path == null || path.isEmpty())
            setSaveFilePath();
        else
            saveFilePath = path;
    }

    
    private void saveNewFile(File file) {
        //System.out.println("" + file.getAbsolutePath());
        Path path = Paths.get(file.getAbsolutePath() + ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(editFileContent);
        }       
        catch (IOException ex) {
            Logger.getLogger(NoteModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    
    
    
    
}
