public class RaspiStill
{
   private final String _raspistillPath = "/opt/vc/bin/raspistill";
   
   /**
     * Bu sınıf kameradan fotoğraf çekme ve bu görüntüyü kaydetme işlemlerini icra etmektedir.
     *
     * @author guvenerene
     */
   public void PhotoTake(String name, int width, int height)
   {
      try
      {
         Runtime.getRuntime().exec(_raspistillPath 
                                    + " -n -bm "
                                    +" -t 2000"  
                                    + " -w " 
                                    + width 
                                    + " -h " 
                                    + height 
                                    + " -q 100 " 
                                    + " --colfx 128:128 " 
                                    + " -e " 
                                    + "jpg" + " -o " 
                                    + name);
                                    
         System.out.println(_raspistillPath 
                                    + " -n -bm "
                                    +" -t 2000"  
                                    + " -w " 
                                    + width 
                                    + " -h " 
                                    + height 
                                    + " -q 100 " 
                                    + " --colfx 128:128 " 
                                    + " -e " 
                                    + "jpg" + " -o " 
                                    + name);
         
         
         Thread.sleep(2000);
      }
      catch (Exception e)
      {
         System.exit(e.hashCode());
      }
   }


}