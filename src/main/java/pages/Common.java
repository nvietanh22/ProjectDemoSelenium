package pages;


import core.BasePage;
import core.SeleniumBase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Common extends BasePage {


    public Common(WebDriver driver) {
        super(driver);
    }

    public void deleteAllFile() throws IOException {
        String projectPath = System.getProperty("user.dir");
        String pathDownload = projectPath + "\\download";
        File directory = new File(pathDownload);
        FileUtils.cleanDirectory(directory);
    }

    public static void checkNameFile(String mode)throws Exception{
        Thread.sleep(5000);
        String projectPath = System.getProperty("user.dir");
        String pathDownload = projectPath + "\\download";
        File directoryPath = new File(pathDownload);
        boolean check = false;
        String contents[] = directoryPath.list();
        for (int i = 0; i < contents.length; i++) {
            String nameFile = FilenameUtils.getBaseName(contents[i]);
            String extendFile = FilenameUtils.getExtension(contents[i]);
            if(nameFile.contains(mode) && extendFile.equalsIgnoreCase("txt"))  {
                check = true;
            }
            else{
                check = false;
            }
        }
        if(check == false){
            throw new Exception("The file name isn't in the correct format");
        }
    }

    public void navative(String username, String password, String host){
        String url = "http://"+username+":"+password+"@"+host;
        System.out.println(url);
        driver.get(url);
    }
}
