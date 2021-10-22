public class CameraProcces {

    /**
     * Bu sınıf kameradan işlemlerini sıralı bir şekilde icra etmek için tanımlanmıştır.
     *
     * @author guvenerene
     */
    public void CameraProcces(String kayitYolu, String damga){
        
        try
        {
            RaspiStill camera = new RaspiStill();
            camera.PhotoTake(kayitYolu + damga + "/" + damga + ".jpg",2592,1944);
            Thread.sleep(2000);

            ImageCrop crop = new ImageCrop();
            crop.ImageCrop(kayitYolu + damga + "/" + damga);
        }
        catch (Exception e)
        {
            System.exit(e.hashCode());
        }
    }
}