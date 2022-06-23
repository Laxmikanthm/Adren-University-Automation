package pages;


import cucumber.api.DataTable;
import cucumber.api.Transformer;

public class ExcelDataToDataTable extends Transformer<DataTable> {

    @Override
    public DataTable transform(String filePath){
        System.out.println("Hello");
        DataTable table = null;
        return table;
    }

}
