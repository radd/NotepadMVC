/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.radd.controller;

import java.io.File;

/**
 *
 * @author Piotr
 */
public interface NoteController {

    public void setFile(File selectedFile);

    public void saveFile();

    public void updateFileContent(String text);

    public void saveFile(File selectedFile);
    
}
