/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.gestform.GUI;

import com.alex.gestform.model.Module;
import com.alex.gestform.model.dao.ModuleDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alex
 */
public class JTableModules extends AbstractTableModel {
    private final String[] cols = {"Libellé","Descripton","Durée"};
    private final List<Module> allMdl;
    
    public JTableModules(){
        super();
        allMdl = ModuleDAO.findAll();
        
    }

    JTableModules(ArrayList<Object> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount(){
        return allMdl.size();
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
              return allMdl.get(rowIndex).getLibelle();
              
             case 1:
              return allMdl.get(rowIndex).getDescription();
              
             case 2:
              return allMdl.get(rowIndex).getDuree(); 
              
             default:
                 return null;
              
              
        }
}

public Module getModule(int rowIndex){
    return allMdl.get(rowIndex);
}

public void addModule(Module mdl){
    this.allMdl.add(mdl);
    this.fireTableDataChanged();
}

public void removeModule(Module mdl){
    this.allMdl.add(mdl);
    this.fireTableDataChanged();
}

    @Override
    public void fireTableDataChanged() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

