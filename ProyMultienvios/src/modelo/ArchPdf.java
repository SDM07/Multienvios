/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import com.barcodelib.barcode.QRCode;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
//archivos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//librerias ajenas a itext
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.tools.jar.Main;

public class ArchPdf {
    private File ruta_destino;
    public ArchPdf(){
        ruta_destino=null;
    }
    /* metodo que hace uso de la clase itext para manipular archivos PDF*/
    public void crear_PDF(Factura fac){
        //abre ventana de dialogo "guardar"
        Colocar_Destino();
        //si destino es diferente de null
        if(this.ruta_destino!=null){
            try {
                // se crea instancia del documento
                Document mipdf = new Document();
                // se establece una instancia a un documento pdf
                PdfWriter pw=PdfWriter.getInstance(mipdf, new FileOutputStream(this.ruta_destino + ".pdf"));
                mipdf.open();// se abre el documento
                mipdf.addTitle("Factura"); // se añade el titulo
                /*mipdf.addAuthor(a); // se añade el autor del documento
                mipdf.addSubject(s); //se añade el asunto del documento
                mipdf.addKeywords(k); //Se agregan palabras claves*/
                mipdf.add(new Paragraph("Datos Fatura"));
                mipdf.add(new Paragraph(fac.toString()));
                mipdf.add(codBar(mipdf, pw, fac));
                mipdf.add(codQR(fac));
                // se añade el contendio del PDF
                mipdf.close(); //se cierra el PDF&
                JOptionPane.showMessageDialog(null,"Documento PDF creado");
            } catch (DocumentException | FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error "+ex.getMessage());
            }
        }
    }
    /* abre la ventana de dialogo GUARDAR*/
    public void Colocar_Destino(){
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){
           this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }
    public File getRuta_destino() {
        return ruta_destino;
    }
    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    } 
    
    
 public Image codBar(Document doc, PdfWriter pw, Factura fac)
  {
    PdfContentByte cimg = pw.getDirectContent();
    Barcode128     code128 = new Barcode128();
    code128.setCode(convertirCod(fac));
    //tipo de codigo que se le va a enviar
    code128.setCodeType(Barcode128.CODE128);
    code128.setTextAlignment(Element.ALIGN_CENTER);
    Image img= code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
    //para el posicionamiento y tamaÃƒÆ’Ã‚ ±o  
    img.setAlignment(Element.ALIGN_CENTER);
    return img;
  }
  public  Image codQR(Factura fac){
    Image img=null;
    int udm=0; //unidad dimensión pixeles
        int resol=72; //resolución del qr
        //margenes de la zona blanca del qr
        float mi= 0.000f;
        float md= 0.000f;
        float ms= 0.000f;
        float min= 0.000f;
        //rotacion grados
        int rot=0;
        //tamaño de la imagen
        float tam=5.000f;
        QRCode cod= new QRCode();
        cod.setData(convertirCod(fac));
        cod.setDataMode(QRCode.MODE_BYTE);
        cod.setUOM(udm);
        cod.setLeftMargin(mi);
        cod.setTopMargin(ms);
        cod.setBottomMargin(min);
        cod.setRightMargin(md);
        cod.setRotate(rot);
        cod.setResolution(resol);
        cod.setModuleSize(tam);
        String archiv= System.getProperty("user.home")+"/QRDemo.gif";
        try {
            cod.renderBarcode(archiv);
            img=Image.getInstance(archiv);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
        }
    return img;
  }
  public String convertirCod(Factura fac)
  { return fac.getCliente().getId()+"-"+fac.getCliente().getNombre();
  }

}