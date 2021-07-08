/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titanicPkg;


//import com.google.common.collect.Table;
import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

/**
 *
 * @author SaiF El-deen
 */
public class MainClass {
    public static void main(String[] args) throws IOException{
        
        
        DataFrame<Object> df = DataFrame.readCsv("D:\\AI\\JavaITI\\Data_to_use\\titanic.csv");
        
        DataFrame<Object> df2 = df.retain("sex", "age" , "survived")
                .groupBy(row -> row.get(1))
                .mean();
        
        DataFrame<Object> df3 = df.retain("sex", "age")
                .groupBy(row -> row.get(0))
                .max();
        
        DataFrame<Object> df4 = df.retain("sex", "age")
                .groupBy(row -> row.get(0))
                .min();
        
        DataFrame<Object> df5 = df.retain("sex", "age", "survived")
                .groupBy(row -> row.get(1))
                .stddev();
        
        System.out.println(df);
        System.out.println(df2);
        System.out.println(df3);
        System.out.println(df4);
        System.out.println(df5);
        
        //1.Read from file
        Table titanicData;
        String dataPath = "D:\\AI\\JavaITI\\Data_to_use\\titanic.csv";
        titanicData = Table.read().csv(dataPath);
        
        List<Column<?>> dataStructure = titanicData.columns();
        System.out.println(dataStructure);
        System.out.println(titanicData.summary());

    }
            
}
