<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.io.* , javax.servlet.http.Part"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


		<%
		/* Part filepart = request.getPart("f1");
		if(filepart!=null){
			System.out.println(filepart.getSubmittedFileName());	
		} */
		  String contentType = request.getContentType();
		  if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
            DataInputStream in = new DataInputStream(request.getInputStream());
            int formDataLength = request.getContentLength();
            byte dataBytes[] = new byte[formDataLength];
            int byteRead = 0;
            int totalBytesRead = 0;
            while (totalBytesRead < formDataLength) {
                    byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
                    totalBytesRead += byteRead;
		  }
            
            String file = new String(dataBytes);
            //System.out.println("%%%%% "+file);
            String saveFile = file.substring(file.indexOf("filename=\"") + 10);
           
            saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
            saveFile = saveFile.substring(saveFile.lastIndexOf("\\")+ 1,saveFile.indexOf("\""));
            int lastIndex = contentType.lastIndexOf("=");
            String boundary = contentType.substring(lastIndex + 1,contentType.length());
            int pos;
            pos = file.indexOf("filename=\"");
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            pos = file.indexOf("\n", pos) + 1;
            int boundaryLocation = file.indexOf(boundary, pos) - 4;
            int startPos = ((file.substring(0, pos)).getBytes()).length;
            int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
            String str="C:\\Users\\mayank\\Documents\\advnacejavaprojects\\SocialMedia\\WebContent\\images\\"+session.getAttribute("email");
            out.println(str);
            File f=new File(str);
            
            if(!f.exists()){
            	f.mkdir();
            }
            String path=str+"\\profilepicture.jpg";
            
            try{

                FileOutputStream fileOut = new FileOutputStream(path);
                fileOut.write(dataBytes, startPos, (endPos - startPos));
                fileOut.flush();
                fileOut.close();	
            } catch(Exception e){
            	response.getWriter().write(e.getMessage());
            }
            
            %><Br><table border="2"><tr><td><b>You have successfully
            		 upload the file by the name of:</b>
            		                                           </td></tr></table> <%
            		                }
            		        response.sendRedirect("index.jsp?useremail=" + session.getAttribute("email"));
            		%>
		
		%>

</body>
</html>