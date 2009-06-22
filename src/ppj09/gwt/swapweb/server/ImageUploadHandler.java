package ppj09.gwt.swapweb.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageUploadHandler extends HttpServlet {
   
   final static String UPLOADDIR = "uploads/";
	
   public void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
       
       resp.setContentType("text/html");
       
       ArrayList l = getFileItem(req);
       FileItem uploadItem = (FileItem) l.get(0);
       if(uploadItem == null) {
           resp.getWriter().write("NO-SCRIPT-DATA");
           return;
       }
       
       String filename = uploadItem.getName();
       
       int indexPoint = filename.lastIndexOf(".");
       int length = filename.length();
       
       String extension = filename.substring(indexPoint, length);
       
       GregorianCalendar cal = new GregorianCalendar(); 
       
       String newFileName = cal.getTimeInMillis()+extension;
       
       System.out.println("FILENAME: " + newFileName);
       
       File f = new File(UPLOADDIR + newFileName);
       
       try {
		  uploadItem.write(f);
       } catch (Exception e) {
		// TODO Auto-generated catch block
		  e.printStackTrace();
       }
       
       DataBankerQueries dbq = new DataBankerQueries();
       
       boolean saved = dbq.saveImageToArticle(UPLOADDIR + newFileName, (String)l.get(1));
       
       if(saved) {
    	   resp.getWriter().write(new String("Ihr Bild wurde erfolgreich gespeichert")); 
       } else {
    	   resp.getWriter().write(new String("Ihr Bild konnte nicht in der Datenbank gespeichert werden"));
       }
   }

   private ArrayList getFileItem(HttpServletRequest req) {
       FileItemFactory factory = new DiskFileItemFactory();
       ServletFileUpload upload = new ServletFileUpload(factory);
       
       ArrayList l = new ArrayList();
       
       try {
           List items = upload.parseRequest(req);
           Iterator it = items.iterator();
           
           FileItem i = null;
           
           while(it.hasNext()) {
               FileItem item = (FileItem) it.next();
               if(!item.isFormField() && "uploadFormElement".equals(item.getFieldName())) {
            	   l.add(item);
               }
               if("uploadHiddenElement".equals(item.getFieldName())) {
            	   l.add(item.getString());
               }
           }
           return l;
       }
       catch(FileUploadException e){
           return null;
       }
   }

}