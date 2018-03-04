package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;

import javax.servlet.http.HttpServlet;

public class DatabaseFile {

	public static String[] read() {
		String[] settings = new String[5];
		
		File archivo;
		FileReader fr = null;
		BufferedReader br;
		String[] data;
				
		try {
			String url2 = DatabaseFile.class.getProtectionDomain().getCodeSource().getLocation().toString();
			System.out.println(url2);
			//File temp = new File(DatabaseFile.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			//String url = new File(".").getCanonicalPath();
			String url = getApplicationPath();
			System.out.println(url);
			URL path = Thread.currentThread().getContextClassLoader().getResource("");
			Path p = Paths.get(path.toURI());
			String location = p.getParent().toString();
			System.out.println(location);
			File configFile = new File(url + "/config.txt");
			System.out.println(configFile.getPath());
			archivo = new File(location + "/config.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			int i = 0;
			while (br.ready()) {
				data = br.readLine().split("=");
				settings[i] = data[1];
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return settings;
	}
	
	public static String getApplicationPath() {
		CodeSource codeSource = DatabaseFile.class.getProtectionDomain().getCodeSource();
		File rootPath = null;
		
		try {
			rootPath = new File(codeSource.getLocation().toURI().getPath());
		} catch (URISyntaxException ex) {
			ex.printStackTrace();
		}
		
		return rootPath.getParentFile().getParentFile().getPath();
	}
	
}
