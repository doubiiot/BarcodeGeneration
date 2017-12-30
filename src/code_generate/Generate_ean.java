package code_generate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class Generate_ean {
    Generate_ean(String num) {
        try {
            //Create the barcode bean
            EAN13Bean eanbean  = new  EAN13Bean();//产生EAN13对象

            final int dpi = 180;

            eanbean.setModuleWidth(0.2);
            eanbean.doQuietZone(false);

            //Open output file
            File outputFile = new File("D:\\out\\out.png");//设置输出文件路径
            OutputStream out = new FileOutputStream(outputFile);//设置输出文件流
            try {
                //Set up the canvas provider for monochrome JPEG output
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

                //生成
                eanbean.generateBarcode(canvas, "467651328233");

                //Signal end of generation
                canvas.finish();
            } finally {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
