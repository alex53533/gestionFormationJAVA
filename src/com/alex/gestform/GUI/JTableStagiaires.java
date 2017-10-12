/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.gestform.GUI;

import com.alex.gestform.model.Stagiaire;
import com.alex.gestform.model.dao.StagiaireDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class JTableStagiaires extends AbstractTableModel  {
    private final String[] cols;
    private final List<Stagiaire> allStg;
    
    public JTableStagiaires(){
        super();
        this.cols = new String[]{"Code Postale", "Téléphone", "Nom", "Prénom", "Adresse", "Ville", "Email"};
        allStg = StagiaireDAO.findAll();
        
    }

    JTableStagiaires(ArrayList<Object> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount(){
        return allStg.size();
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getColumnCount(){
        return cols.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return cols[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            
             case 0:
              return allStg.get(rowIndex).getCp();
              
             case 1:
              return allStg.get(rowIndex).getTelephone();
              
             case 2:
              return allStg.get(rowIndex).getNom(); 
              
             case 3:
              return allStg.get(rowIndex).getPrenom();  
              
             case 4:
              return allStg.get(rowIndex).getAdresse();  
              
             case 5:
              return allStg.get(rowIndex).getVille(); 
              
             case 6:
              return allStg.get(rowIndex).getEmail();  
              
             default:
                 return null;
              
              
        }
}

public Stagiaire getStagiaire(int rowIndex){
    return allStg.get(rowIndex);
}

public void addStagiaire(Stagiaire stg){
    this.allStg.add(stg);
    this.fireTableDataChanged();
}

public void removeStagiaire(Stagiaire stg){
    this.allStg.add(stg);
    this.fireTableDataChanged();
}

    /**
     *
     */
    @Override
    public void fireTableDataChanged() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



