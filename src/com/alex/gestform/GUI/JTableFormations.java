/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.gestform.GUI;

import com.alex.gestform.model.Formation;
import com.alex.gestform.model.Stagiaire;
import com.alex.gestform.model.dao.FormationDAO;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author alex
 */
public class JTableFormations extends AbstractTableModel {
    private final String[] cols;
    private final List<Formation> allFrt;
    
    public JTableFormations(){
        super();
        this.cols = new String[]{"Libelle", "Description", "Volume horaire", "Lieu", "Date début", "Formateur"};
        allFrt = FormationDAO.findAll();
        
    }

    JTableFormations(List<Formation> findAll) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int getRowCount(){
        return allFrt.size();
    }
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
              return allFrt.get(rowIndex).getLibelle();
              
             case 1:
              return allFrt.get(rowIndex).getDescription();
              
             case 2:
              return allFrt.get(rowIndex).getNbrHeure(); 
              
             case 3:
              return allFrt.get(rowIndex).getLieu();  
              
             case 4:
              return allFrt.get(rowIndex).getDateDebut();  
              
             case 5:
              return allFrt.get(rowIndex).getPersonnel(); 

             default:
                 return null;
              
              
        }
}

public Formation getFormation(int rowIndex){
    return allFrt.get(rowIndex);
}

public void addFormation(Stagiaire stg){
        Formation frt = null;
    this.allFrt.add(frt);
    this.fireTableDataChanged();
}

public void removeFormation(Stagiaire stg){
        Formation frt = null;
    this.allFrt.add(frt);
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
