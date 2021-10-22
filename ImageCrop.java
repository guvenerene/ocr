import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCrop {
    /**
     * Bu sınıf kameradan çekilerek kayıt edilmiş fotoğrafın belirli koordinantlara göre kırpma işlemini irca eder. 
     *
     * @author guvenerene
     */
    public void ImageCrop(String directorySrc){
        try {
            BufferedImage croppedImage = ImageIO.read(new File(directorySrc+".jpg"));
            
            System.out.println("Orijinal Görselin Boyutu: "+croppedImage.getWidth()+"x"+croppedImage.getHeight());
            
            //Raspberyy Pi Camera Rev 1.3
            //BufferedImage SubImgage = croppedImage.getSubimage(170, 160, 400, 75);
            
            //Mini zoom lens
            //BufferedImage SubImgage = croppedImage.getSubimage(130, 530, 1620, 331);
            
            //Mega zoom lens
            BufferedImage SubImgage = croppedImage.getSubimage(0, 650, 2590, 450);
            
            System.out.println("Kırpılan Görselin Boyutu: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

            File clipped = new File(directorySrc+"_kirpilan.jpg");
            ImageIO.write(SubImgage, "jpg", clipped);

            System.out.println("Kırpma İşlemi Bararıyla Tamamlandı, Kayıt dizini: "+clipped.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}