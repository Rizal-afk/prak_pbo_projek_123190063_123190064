/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Asus
 */
public class MVC {
    
    public void Admin(){
        ViewAdmin viewAdmin = new ViewAdmin();
        ModelAdmin modelAdmin = new ModelAdmin();
        Controller controller = new Controller(viewAdmin, modelAdmin);
    }
    
    public void Tamu(){
        ViewTamu viewTamu = new ViewTamu();
        ModelTamu modelTamu = new ModelTamu();
        Controller controller = new Controller(viewTamu, modelTamu);
    }
}
