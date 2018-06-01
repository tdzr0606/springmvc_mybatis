package com.nature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * springmvc_mybatis
 * Doc2PdfUtils
 *
 * @Author: 竺志伟
 * @Date: 2018-06-01 14:21
 */
public class Doc2PdfUtils
{
    public static void main(String[] args)
    {
        Doc2PdfUtils.convertWordToPdf("/Users/apple/Desktop/111.docx", "/Users/apple/Desktop/111.pdf");
        System.out.println("OVER");
    }


    public static void convertWordToPdf(String src, String desc)
    {
        try
        {
            //create file inputstream object to read data from file
            FileInputStream fs = new FileInputStream(src);
            //create document object to wrap the file inputstream object
            XWPFDocument doc = new XWPFDocument(fs);
            //72 units=1 inch
            Document pdfdoc = new Document(PageSize.A4, 72, 72, 72, 72);
            //create a pdf writer object to write text to mypdf.pdf file
            PdfWriter pwriter = PdfWriter.getInstance(pdfdoc, new FileOutputStream(desc));
            //specify the vertical space between the lines of text
            pwriter.setInitialLeading(20);
            //get all paragraphs from word docx
            List<XWPFParagraph> plist = doc.getParagraphs();

            // 基本字体
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            //open pdf document for writing
            pdfdoc.open();
            for(int i = 0; i < plist.size(); i++)
            {
                //read through the list of paragraphs
                XWPFParagraph pa = plist.get(i);
                //get all run objects from each paragraph
                List<XWPFRun> runs = pa.getRuns();
                //read through the run objects
                for(int j = 0; j < runs.size(); j++)
                {
                    XWPFRun run = runs.get(j);
                    //get pictures from the run and add them to the pdf document
                    List<XWPFPicture> piclist = run.getEmbeddedPictures();
                    //traverse through the list and write each image to a file
                    Iterator<XWPFPicture> iterator = piclist.iterator();
                    while(iterator.hasNext())
                    {
                        XWPFPicture pic = iterator.next();
                        XWPFPictureData picdata = pic.getPictureData();
                        byte[] bytepic = picdata.getData();
                        Image imag = Image.getInstance(bytepic);
                        pdfdoc.add(imag);
                    }

                    //construct unicode string
                    String text = run.getText(-1);
                    if(text != null)
                    {
                        //add string to the pdf document
                        pdfdoc.add(new Chunk(new String(text.getBytes(), "UTF-8"), new Font(baseFont, run.getFontSize())));

                    }
                }
                //output new line
                pdfdoc.add(new Chunk(Chunk.NEWLINE));
            }
            //close pdf document
            pdfdoc.close();
            pwriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

        }
    }

}
