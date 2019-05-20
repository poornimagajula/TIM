package com.regnant.tim.operations;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadDocServlet")
public class UploadDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload= new ServletFileUpload(factory);
		
		 if(ServletFileUpload.isMultipartContent(request)){
	            try {
	            	
	            	List<FileItem> multiparts = upload.parseRequest((RequestContext) request);
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                        String name = new File(item.getName()).getName();
	                        item.write( new File("F:/TIM/Trust_In_Me/Docs" + File.separator + name));
	                    }
	                }
	               //File uploaded successfully
	               request.setAttribute("message", "File Uploaded Successfully");
	            } catch (Exception ex) {
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }         		
	        }else{
	
	            request.setAttribute("message","No File found");
}
	        request.getRequestDispatcher("Result.jsp").forward(request, response);
	
	    }


}