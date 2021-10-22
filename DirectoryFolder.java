import java.io.*; 
  
public class DirectoryFolder {
    
    public final String folderSrc="/home/pi/Documents/ErSisKayit";
    
    
    /**
     * Bu sınıf dizin klasörü ve anlık kayıt için gerekli klasörleri oluşturma görevini icra eder.
     *
     * @author guvenerene
     */
    public void FolderCreator(){
        
        File directory = new File(folderSrc);
        
        try
        {
            if (directory.exists())
            {
                System.out.println("Kayıt Klasörüne Ulasışdı.");
            }
            else
            {
                System.out.println("Kayıt Klasörü Bulunamadı!");
                File saveDirectory = new File(folderSrc);
                saveDirectory.mkdir();
                Runtime.getRuntime().exec("sudo chmod o+rw " + folderSrc);
                System.out.println("Kayıt Klasörü Oluşturuldu");
            }
        }
        catch (Exception e)
        {
            System.exit(e.hashCode());
        }
    }
    
    public void FolderRecord(String reading){
        
        File source = new File(folderSrc);
        
        try
        {
            System.out.println("Kimlik fotoğrafı kayıt ediliyor...");
            File file = new File(folderSrc+"/"+reading);
            file.mkdir();
            Runtime.getRuntime().exec("sudo chmod o+rw " + folderSrc+"/"+reading);
            System.out.println("Kimlik Fotoğrafı Kayıt Klasörü Oluşturuldu");
        }
        catch (Exception e)
        {
            System.exit(e.hashCode());
        }
    }
    public String getFolderSrc(){
        return folderSrc;
    }
}
