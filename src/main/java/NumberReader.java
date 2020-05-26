import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class NumberReader {

    public String reader(String pictureDirectory){
        ITesseract image = new Tesseract();
        try {
            image.setDatapath("D:\\tessdata");
            String data = image.doOCR(new File(pictureDirectory));
            System.out.println(data);
            return data;
        }catch(TesseractException e){
            e.printStackTrace();
        }
        return null;
    }

}
