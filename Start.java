public class Start
{
    /**
     * Bu sınıf programa ait tüm sınıfların sırasıyla çağırılmasını ve işlemlerin sürekli tekrar etmesini sağlar. 
     *
     * @author guvenerene
     */
    public static void main(String[] args)
    {      
        while(true){
            
            //Damgalama sınıfına ait damga adlı nesne üretildi
            Stamping stamp=new Stamping();
            
            //cardRead sınıfına ait kartiOku adlı nesne üretildi
            CardRead cardRead= new CardRead();
            //kartOku nesnesine ait KayitYolu adlı değişken temizlendi.
            cardRead.setSaveSrc();
            cardRead.cardRead();
            cardRead.getSaveSrc();
            cardRead.getReading();

            DirectoryFolder FolderCheck=new DirectoryFolder();
            FolderCheck.FolderCreator();
            FolderCheck.FolderRecord(stamp.getTimeStamping());

            CameraProcces photo = new CameraProcces();
            photo.CameraProcces(cardRead.getSaveSrc(),stamp.getTimeStamping());

        }
    }
}