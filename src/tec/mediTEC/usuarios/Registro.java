package tec.mediTEC.usuarios;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Properties;
import java.util.Stack;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public abstract class Registro {
	private  final int qr_image_width = 400;
    private  final int qr_image_height = 400;
    private  final String IMAGE_FORMAT = "png";
    private  final String IMG_PATH = "C:\\Users\\pedro\\Desktop\\CodigosServer\\qrcode.png";
    
    private final Properties properties = new Properties();
    private Session session;
	
	public void codigoQR(int cod) throws Exception{
		// URL to be encoded
        String data = Integer.toString(cod);

        // Encode URL in QR format
        BitMatrix matrix;
        Writer writer = new QRCodeWriter();
        try {

            matrix = writer.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);

        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }

        // Create buffered image to draw to
        BufferedImage image = new BufferedImage(qr_image_width,
                qr_image_height, BufferedImage.TYPE_INT_RGB);

        // Iterate through the matrix and draw the pixels to the image
        for (int y = 0; y < qr_image_height; y++) {
            for (int x = 0; x < qr_image_width; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }

        // Write the image to a file
        FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
        ImageIO.write(image, IMAGE_FORMAT, qrCode);

        qrCode.close();

    }
		
	private void init() {

	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.port",587);
	        properties.put("mail.smtp.mail.sender","mediservertec@gmail.com");
	        properties.put("mail.smtp.user", "mediservertec@gmail.com");
	        properties.put("mail.smtp.auth", "true");

	        this.session = Session.getDefaultInstance(properties);
	    }
	
	public void enviarCorreo(String correo){
		init();
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.setSubject("Código de verificación");          

            // Creamos un cuerpo del correo con ayuda de la clase BodyPart
            BodyPart cuerpoMensaje = new MimeBodyPart();

            // Asignamos el texto del correo
            cuerpoMensaje.setText("Este es su código de verificación");

            // Creamos un multipart al correo
            Multipart multiparte = new MimeMultipart();

            // Agregamos el texto al cuerpo del correo multiparte
            multiparte.addBodyPart(cuerpoMensaje);

            // Ahora el proceso para adjuntar el archivo
            cuerpoMensaje = new MimeBodyPart();
            String nombreArchivo = "C:\\Users\\pedro\\Desktop\\CodigosServer\\qrcode.png";
            DataSource fuente = new FileDataSource(nombreArchivo);
            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
            cuerpoMensaje.setFileName(nombreArchivo);
            multiparte.addBodyPart(cuerpoMensaje);
            message.setContent(multiparte);
            Transport t = this.session.getTransport("smtp");
            t.connect((String)properties.get("mail.smtp.user"), "mediserver123");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }catch (MessagingException me){
            System.out.print(me);
        }
		
	}

	public int numRandom(){
			int result=0;
			int length = 4;
		//Array donde guardo los randoms    
		    int[] arrayRandom=new int[length];
		//Variable donde genero numeros por separado    
		    int pos;
		//Variable donde eligo el Rango de Numeros     
		    int nNums = 9;//En este caso del 1 al 9.
		//Creo un objeto Pila 
	        Stack< Integer> pila = new Stack< Integer>();
		//For para generar los numeros
	        for (int i = 0; i < arrayRandom.length; i++) {
	//Genero un numero random    
	            pos = (int) Math.floor(Math.random() * nNums+1);
	//Lo guardo en el array
	            arrayRandom[i] = pos;
	 
	//Si la pila ya contiene el numero 
	            while (pila.contains(pos)) {
	//Vuelvo a generar un numero random  hasta que no se repita   
	                pos = (int) Math.floor(Math.random() * nNums);
	                arrayRandom[i] = pos;
	            }
	//Guardo en el Stack (pila)
	            pila.push(pos);
	        }
	 
	//Lo convierto a un solo numero entero
	//Variable para Conseguir decena/centena/ Etc...
	  int multiplicador = 1;
	//Segun el tamaño del numero (length)  
	        for (int i = 1; i < length; i++) {
	 
	           multiplicador=multiplicador*10;
	        }
	//Convierto el Array de numeros aleatorios en un solo entero      
	    for (int i = 0; i < length; i++) {
	//Multiplicando por el mas alto     
	       result += (arrayRandom[i]*multiplicador);
	//Decremento el multiplicador        
	       multiplicador = multiplicador/10;
	 
	    }
	 
	        return result;
	 
	}
}
