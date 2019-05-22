package com.ats.tankwebapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ats.tankwebapi.model.Info;

@RestController
public class ImageUploadController {
	
	//private static String DOC_URL=	"C:/Users/MAXADMIN/Desktop/uploads/";
	//private static String DOC_URL=	"/opt/apache-tomcat-8.5.6/webapps/media/hr/";
	private static String DOC_URL=	"D:\\Uploads/";
	
	
	@RequestMapping(value = { "/photoUpload" }, method = RequestMethod.POST)
	public @ResponseBody Info photoUpload(@RequestParam("file") MultipartFile uploadfile , 
			@RequestParam("imageName") String imageName,@RequestParam("type") String type) {
		
		System.out.println("HELLO------------------------" );
		
		
		Info info = new Info();

		//System.out.println("File Name " + imageName.toString());

		try {

			saveUploadedFiles(uploadfile ,  imageName,type);

			info.setError(false);
			info.setMsg("File uploaded successfully");

		} catch (IOException e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("File upload failed");
		}

		return info;
	}

	// save file
	private void saveUploadedFiles(MultipartFile files,  String imageName,String type) throws IOException {

		/*try {
		for (MultipartFile file : files) {
			Path path=null;
			if (file.isEmpty()) {
				continue; 
			}
            if(type.equalsIgnoreCase("1"))
            {
			 path =Paths.get(DOC_URL + imageName);
            }
            
			byte[] bytes = file.getBytes();
			
			Files.write(path, bytes);
		}
	
	}*/
		
		try {
			
				Path path=null;
				
	            if(type.equalsIgnoreCase("1"))
	            {
	            	
	            String name=imageName.substring(1, imageName.length()-1);
	            
				 path =Paths.get(DOC_URL + name);
	            }

	            
				byte[] bytes = files.getBytes();
				
				Files.write(path, bytes);

			

		
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
}
