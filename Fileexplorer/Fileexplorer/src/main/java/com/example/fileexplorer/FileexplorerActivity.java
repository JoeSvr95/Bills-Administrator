package com.example.fileexplorer;
  
import android.os.Bundle; 
import android.app.Activity; 
import android.content.Intent; 
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FileexplorerActivity extends Activity {
 
	private static final int REQUEST_PATH = 1;
 
	String curFileName;
    String curPath;
	ListView listXML;
	EditText edittext;
    archivoAdapter a;
    ArrayList<Archivo> datosArchivos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileexplorer); 
        edittext = (EditText)findViewById(R.id.editText);
        listXML=(ListView)findViewById(R.id.listXML);
        datosArchivos=new ArrayList<Archivo>();
        a=new archivoAdapter(this,datosArchivos);
        listXML.setAdapter(a);
    }
 
    public void getfile(View view){ 
    	Intent intent1 = new Intent(this, FileChooser.class);
        startActivityForResult(intent1,REQUEST_PATH);
    }
 // Listen for results.
    //ESTE METODO ESPERA EL RESULTADO QUE LE DEVUELVE EL ACTIVITY FILECHOOSER, EN ESTE CASO DEVUELVE EL DIRECTORIO Y EL NOMBRE DEL XML
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // See which child activity is calling us back.
    	if (requestCode == REQUEST_PATH){
    		if (resultCode == RESULT_OK) {
                curPath=data.getStringExtra("GetPath");
    			curFileName = data.getStringExtra("GetFileName");
            	edittext.setText(curFileName);
    		}
    	 }
    }

    //ANIADE LOS OBJETOS Archivo AL LISTVIEW CON SUS ATRIBUTOS
    public void addXML(View view){
        Archivo f=new Archivo(curFileName,curPath);
        if(!datosArchivos.contains(f))
            datosArchivos.add(f);
        a.notifyDataSetChanged();
    }

    //NOTEN QUE LOS DATOS QUE ESTA EN EL ARRAYLIST DATOS ARCHIVOS SON LOS MISMO QUE EL DEL LISTVIEW
    //ESTE METODO GENERA UN INTENT QUE SE CARGA CON EL ARRAYLIST DE LOS OBJETOS ARCHIVO, CON LA INFORMACION DE CADA NOMBRE Y DIRECTORIO DE CADA XML
    //ESTE METODO SE PASA AL ACTIVITY xmlActivity
    public void processXML(View view){
        Intent i=new Intent(this,xmlActivity.class);
        i.putExtra("xmlList",datosArchivos);
        startActivity(i);
    }
}
