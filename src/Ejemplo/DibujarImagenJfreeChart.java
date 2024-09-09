/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author antonio
 */
public class DibujarImagenJfreeChart {

    private static DibujarImagenJfreeChart instancia;

    public static DibujarImagenJfreeChart getInstancia() {
        if (instancia == null) {
            instancia = new DibujarImagenJfreeChart();
        }
        return instancia;
    }

    private Conexion c=new Conexion();
    public Connection cn=c.conectar();
    
    public String consulta="";
    
    
    public void mostrarProducto() throws SQLException, IOException{
        
        consulta="Select * from producto";
       
        Statement statement=cn.createStatement();
        ResultSet rs=statement.executeQuery(consulta);
       
        DefaultPieDataset dataset=new DefaultPieDataset();
        while(rs.next()){
            dataset.setValue(rs.getString("nombre"), Integer.parseInt(rs.getString("stock")));
        }
        
        //dibujamos el grafico
        
        JFreeChart chart= ChartFactory.createPieChart("Grafico de Stock de Producto", dataset, true, true, false);
       
        //tamano para la imgen
        int ancho=560;
        int alto=380;
        File f=new File("Grafico.png");
        ChartUtilities.saveChartAsPNG(f, chart, ancho, alto);
      
    }
    
}
