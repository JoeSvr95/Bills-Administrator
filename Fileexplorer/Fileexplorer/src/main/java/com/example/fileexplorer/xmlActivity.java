package com.example.fileexplorer;


import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class xmlActivity extends Activity implements ActionBar.TabListener {

    //---> ESTA CLASE SE CREO AL ELEGIR EL TABBED ACTIVITY , LA MAYORIA DE LO QUE ESTA AQUI SE AUTOGENERO
    // DEBEN ENTENDER QUE HACE EL SECTIONS PAGE ADAPTER  Y EL PLACEHOLDERFRAGMENT, EN ESAS CLASES HICE LAS MODIFICACIONES

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    //-->SE CREO ESTE ARRAYLIST ESTATICO PARA PODER USARLO EN LA CLASE PlaceHolderFragment
    public static ArrayList<Archivo> archivosXML;
    //-->SE CREO ESTE ARRAYLIST ESTATICO PARA PODER GUARDAR TODA LA INFORMACION DE LAS FACTURAS COMO OBJETOS FACTURAS
    public static ArrayList<Float> listaAlimentos = new ArrayList<Float>();
    public static ArrayList<Float> listaMedicina = new ArrayList<Float>();
    public static ArrayList<Float> listaVivienda = new ArrayList<Float>();
    public static ArrayList<Float> listaEducacion = new ArrayList<Float>();
    public static ArrayList<Float> listaVestimenta = new ArrayList<Float>();
    public static ArrayList<Float> listaOtros = new ArrayList<Float>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        //--->DEVOLUCION DEL INTENT DEL ACTIVITY FileexplorerActivity DEL ARRAYLIST DE OBJETOS "ARCHIVO" PARA EXTRAER EL NOMBRE Y DIRECTORIO DE CADA ARCHIVO SELECCIONADO
        archivosXML=getIntent().getExtras().getParcelableArrayList("xmlList");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        //-->ESTE FOR ANIADE LAS TABS AL ACTIONBAR, EL NUMERO DE TABS DEPENDE DEL METODO getCount, que esta mas abajo
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_xml, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.grafios:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent i = new Intent(this, Graficos.class);

                i.putExtra("alimentos",listaAlimentos);
                i.putExtra("vivienda",listaVivienda);
                i.putExtra("medicina",listaMedicina);
                i.putExtra("educacion",listaEducacion);
                i.putExtra("vestimenta",listaVestimenta);
                i.putExtra("otros",listaAlimentos);

                startActivity(i);
                return true;
            case R.id.deducibles:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent j = new Intent(this, Deducibles.class);
                j.putExtra("alimentos",listaAlimentos);
                j.putExtra("vivienda",listaVivienda);
                j.putExtra("medicina",listaMedicina);
                j.putExtra("educacion",listaEducacion);
                j.putExtra("vestimenta",listaVestimenta);
                j.putExtra("otros",listaOtros);

                startActivity(j);
                return true;
            case R.id.barras:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                Intent k = new Intent(this, Barras.class);

                k.putExtra("alimentos",listaAlimentos);
                k.putExtra("vivienda",listaVivienda);
                k.putExtra("medicina",listaMedicina);
                k.putExtra("educacion",listaEducacion);
                k.putExtra("vestimenta",listaVestimenta);
                k.putExtra("otros",listaAlimentos);

                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        //ESTE ES UN STRING QUE PERMITE SACAR LOS INDICES DE CADA TAB O EN ESTE CASO, DE CADA ELEMENTO DEL ARRAYLIST
        private static final String ARG_SECTION_NUMBER = "section_number";

        public String regFood="TOSTACHOS|ZANAHORIA|APANADURA";
        public String regMed="";
        public String regViv="MACETERO(.)*|OLLA(.)*|PLASTICO(.)*";
        public String regEd="";
        public String regVest="";


        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_xml, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //AQUI SE GENERA UN OBJETO ARCHIVO,SE LO EXTRAE DEL ARRAYLIST QUE LO DEVOLVIO FileExplorerActivity
            // PARA SACAR CADA ELEMENTO EN ORDEN SE UTILIZA EL METODO getArguments CON ARG_SECTION_NUMBER, ESTE COMIENZA DESDE 1
            Archivo fileXml=archivosXML.get(getArguments().getInt(ARG_SECTION_NUMBER)-1);
            //SE GENERA UN OBJETO FILE DONDE SE EXTRAE LA INFORMACION DEL XML, POR MEDIO DEL DIRECTORIO Y SU NOMBRE
            File f=new File(fileXml.getDirectorio(), fileXml.getNombre());
            //EN ESTE PUNTO SE EXTRAE LOS DATOS CON EL SCANNER Y SE LOS PASA A UN TEXTVIEW
            // ESTA ES LA PARTE QUE DEBE CAMBIAR SEGUN LO QUE QUIERAN PRESENTAR EN PANTALLA PARA CADA ARCHIVO XML
            // EN ESTE CASO DECIDI QUE SIMPLEMENTE SE PRESENTE POR PANTALLA TODOS LOS DATOS DEL ARCHIVO XML
            try {
                Factura fact = new Factura();
                InputStream is = new FileInputStream(f);
                String text="";
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);

                Element element=doc.getDocumentElement();
                element.normalize();

                NodeList nList = doc.getElementsByTagName("estado");
                Node node =nList.item(0);
                Element element2 = (Element) node;
                fact.setEstado(element2.getTextContent());
                text+="INFORMACION TRIBUTARIA\nEstado:\t"+fact.getEstado();

                nList = doc.getElementsByTagName("numeroAutorizacion");
                node =nList.item(0);
                element2 = (Element) node;
                fact.setNumeroAutorizacion(element2.getTextContent());
                text+="\n# de Autorizacion:\t"+fact.getNumeroAutorizacion();

                nList = doc.getElementsByTagName("fechaAutorizacion");
                node =nList.item(0);
                element2 = (Element) node;
                fact.setFechaAutorizacion(element2.getTextContent());
                text+="\nFecha de Autorizacion:\t"+fact.getFechaAutorizacion();

                nList = doc.getElementsByTagName("infoTributaria");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("razonSocial");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setRazonSocial(element2.getTextContent());
                text+="\nRazon Social:\t"+fact.getRazonSocial();

                nList = doc.getElementsByTagName("infoTributaria");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("ruc");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setRuc(element2.getTextContent());
                text+="\nRuc:\t"+fact.getRuc();

                nList = doc.getElementsByTagName("infoTributaria");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("dirMatriz");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setDirMatriz(element2.getTextContent());
                text+="\nDireccion Matriz:\t"+fact.getDirMatriz();

                //AQUI EMPIEZA INFORMACION DE LA FACTURA
                nList = doc.getElementsByTagName("infoFactura");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("fechaEmision");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setFechaEmision(element2.getTextContent());
                text+="\n\nINFORMACION FACTURA\nFecha de Emision:\t"+fact.getFechaEmision();

                nList = doc.getElementsByTagName("infoFactura");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("dirEstablecimiento");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setEstab(element2.getTextContent());
                text+="\nDireccion Establecimiento:\t"+fact.getEstab();

                nList = doc.getElementsByTagName("infoFactura");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("razonSocialComprador");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setRazonSocialComprador(element2.getTextContent());
                text+="\nRazon Social Comprador:\t"+fact.getRazonSocial();

                nList = doc.getElementsByTagName("infoFactura");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("identificacionComprador");
                node = nList.item(0);
                element2 = (Element) node;
                fact.setIdentificacionComprador(element2.getTextContent());
                text+="\nCedula/Ruc:\t"+fact.getIdentificacionComprador();


                text+="\n"+String.format("%s%25s%20s%10s","Producto","Cantidad","P.Unitario","Total");
                nList = doc.getElementsByTagName("detalles");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("detalle");
                for (int i=0 ; i<nList.getLength();i++){
                    Producto pro = new Producto();
                    node = nList.item(i);
                    Element element3 = (Element) node;
                    NodeList nList2 = element3.getElementsByTagName("descripcion");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    pro.setDescripcion(element2.getTextContent());


                    nList2 = element3.getElementsByTagName("cantidad");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    pro.setCantidad(element2.getTextContent());

                    nList2 = element3.getElementsByTagName("precioUnitario");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    pro.setPrecioUnitario(Float.parseFloat(element2.getTextContent()));

                    nList2 = element3.getElementsByTagName("precioTotalSinImpuesto");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    pro.setPrecioTotalSinImpuesto(Float.parseFloat(element2.getTextContent()));
                    int x= 25-(pro.getDescripcion().length());
                    fact.setTotalSinImpuestos(fact.getTotalSinImpuestos()+pro.getPrecioTotalSinImpuesto());
                    text+="\n"+String.format("%s%"+x+"s%20s%10s",pro.getDescripcion(),pro.getCantidad(),pro.getPrecioUnitario(),pro.getPrecioTotalSinImpuesto());
                    fact.setProductos(pro);
                }

                String j = fact.getTotalSinImpuestos()+"";
                int y = 44-j.length();
                text+="\n"+String.format("%s%"+y+"s","\nTOTAL SIN IMPUESTOS:",fact.getTotalSinImpuestos());
                nList = doc.getElementsByTagName("infoFactura");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("totalConImpuestos");
                node =nList.item(0);
                element2 = (Element) node;
                nList = element2.getElementsByTagName("totalImpuesto");
                for (int i=0 ; i<nList.getLength();i++){
                    node = nList.item(i);
                    Element element3 = (Element) node;
                    NodeList nList2 = element3.getElementsByTagName("tarifa");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    String tarifa = ""+(Integer.parseInt(element2.getTextContent()));

                    nList2 = element3.getElementsByTagName("valor");
                    node =nList2.item(0);
                    element2 = (Element) node;
                    Float valor = Float.parseFloat(element2.getTextContent());
                    fact.setImpuestos(tarifa,valor);
                    int z = 76-valor.toString().length()-tarifa.length();
                    text+="\n"+String.format("%s%"+z+"s","IVA %"+tarifa+":",valor);
                }

                String a = fact.getPropina()+"";
                int b = 70-a.length();
                text+="\n"+String.format("%s%"+b+"s","PROPINA:",fact.getPropina());
                String c = fact.getImporteTotal()+"";
                int d = 56-c.length();
                fact.calcularImporte();
                text+="\n"+String.format("%s%"+d+"s","TOTAL A PAGAR: ",fact.getImporteTotal());
                //listaFacturas.add(fact);

                //COMPROBACION DE EXPRESION REGULAR
                Pattern pal= Pattern.compile(regFood);
                Pattern pme= Pattern.compile(regMed);
                Pattern pviv= Pattern.compile(regViv);
                Pattern pves= Pattern.compile(regVest);
                Pattern ped= Pattern.compile(regEd);


                for(Producto prod:fact.getProductos()) {
                    Matcher mal = pal.matcher(prod.getDescripcion());
                    Matcher mmed = pme.matcher(prod.getDescripcion());
                    Matcher mviv = pviv.matcher(prod.getDescripcion());
                    Matcher mves = pves.matcher(prod.getDescripcion());
                    Matcher med = ped.matcher(prod.getDescripcion());
                    Float prodTotal=prod.getPrecioUnitario()*Float.parseFloat(prod.getCantidad());
                    if(mal.matches()){
                        listaAlimentos.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                    else if(mmed.matches()){
                        listaMedicina.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                    else if(mviv.matches()){
                        listaVivienda.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                    else if(mves.matches()){
                        listaVestimenta.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                    else if(med.matches()){
                        listaEducacion.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                    else{
                        listaOtros.add(prodTotal-(prodTotal*prod.getDescuento()));
                    }
                }

                textView.setText(text);
                return rootView;
                /*
                for (int i=0; i<nList.getLength(); i++) {

                    Node node1 = nList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element2 = (Element) node;
                        String x = element2.getTextContent();
                        textView.setText("Razon Social:\t"+ x);
                        return rootView;
                        /*
                        tv1.setText(tv1.getText()+"\nName : " + getValue("name", element2)+"\n");
                        tv1.setText(tv1.getText()+"Surname : " + getValue("surname", element2)+"\n");
                        tv1.setText(tv1.getText()+"-----------------------");
                    }
                }*/

            } catch (Exception e) {
                textView.setText("Falle, soy una desgracia");
                e.printStackTrace();}


            /*
            try {
                Scanner sc=new Scanner(f);
                String dataXML="";
                while(sc.hasNextLine())
                    dataXML+=sc.nextLine();
                textView.setText("Archivo: "+fileXml.getNombre()+"\n"+dataXML);
                return rootView;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }*/
         return null;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private static String getValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            //--> ESTA PARTE SE CAMBIO PARA QUE NO CARGUE 3 TABS PREDETERMINADAS SINO QUE CARGUE LA CANTIDAD DE TABS SEGUN EL TAMANO
            // DEL ARRAYLIST, EN POCAS PALABRAS LA CANTIDAD DE ARCHIVOS
            return archivosXML.size();
        }

        @Override
        //ESTA PARTE SON LOS TITULOS DE LAS TABS, SE PUEDE CAMBIAR PARA QUE MUESTRE EL NOMBRE DEL ARCHIVO POR EJEMPLO
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "FACTURA 1";
                case 1:
                    return "FACTURA 2";
                case 2:
                    return "FACTURA 3";
                default:
                    return "FACTURA "+(position+1);
            }
        }
    }
}
