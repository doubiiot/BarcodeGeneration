package code_generate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class Generate_code39 {
    Generate_code39(String num){
        try {
            //Create the barcode bean
            Code39Bean bean = new Code39Bean();//

            final int dpi = 180;//设置dpi

            //Configure the barcode generator
            bean.setModuleWidth(0.2); //设置宽度
            //width exactly one pixel
            bean.setWideFactor(3);
            bean.doQuietZone(false);//两边空白区

            //Open output file
            File outputFile = new File("D:\\out\\out.png");//设置输出路径
            OutputStream out = new FileOutputStream(outputFile);//设置输出文件流
            try {
                //Set up the canvas provider for monochrome JPEG output
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                        out, "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

                //Generate the barcode
                bean.generateBarcode(canvas, num);

                //Signal end of generation
                canvas.finish();
            }finally {
                out.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
