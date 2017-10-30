package com.splearn.svgtopng.web;


import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;

import com.lowagie.text.rtf.RtfWriter2;
import com.splearn.svgtopng.common.SvgPngConverter;
import org.apache.batik.transcoder.TranscoderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class convertToPngController {


    @RequestMapping("/convertToPng")
    public void convertToPng(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException, com.itextpdf.text.DocumentException {

        try {
            String svg_data = request.getParameter("chartData");
            System.out.println("svg_data"+svg_data);

            String file_path = "C:\\Users\\wb-gxy329407\\Desktop\\20171028.png";
            SvgPngConverter.convertToPng(svg_data,file_path);

            //写入doc
            List<String> list_content = new ArrayList<String>();

            list_content.add("    本周（2017/10/02 - 2017/10/08）平台总体报警数量 7960，上周（2017/09/25 - 2017/10/01）平台总体报警数量 26607，环比下降 70.08%。    ");
            list_content.add("     \uF09F 测试1-红色本周平台总体报警数量 2591，上周平台总体报警数量 3195，环比下降  18.90%。");
            list_content.add("     \uF09F 测试2-堵点本周平台总体报警数量 992，上周平台总体报警数量 2330，环比下降  57.42%。");
            list_content.add("     \uF09F 测试3-红色本周平台总体报警数量 4365，上周平台总体报警数量 21071，环比下降 79.28%。");
            list_content.add("     \uF09F 测试4-堵点本周平台总体报警数量 12，上周平台总体报警数量 11，环比上升 9.09%。 ");

            String path = "C:\\Users\\wb-gxy329407\\Desktop\\20171028.doc";
            createWord(path,list_content);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TranscoderException e) {
            e.printStackTrace();
        }

    }


    public void createWord(String path,List<String> list_content) throws IOException, DocumentException{
        //设置纸张大小
        Document document = new Document(PageSize.A4);
        //建立一个书写器，与document对象关联
        RtfWriter2.getInstance(document, new FileOutputStream(path));
        document.open();
        //设置中文字体
        BaseFont bfChinese = BaseFont.createFont();
        Font titleFont = new Font(bfChinese,20,Font.BOLD);
        Paragraph title = new Paragraph("doc文档写入测试");
        //设置标题格式对齐方式
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(titleFont);
        //标题
        document.add(title);

        for(String content:list_content){

            //正文字体风格
            Font contextFont = new Font(bfChinese,10,Font.NORMAL);
            Paragraph context = new Paragraph(content);
            context.setAlignment(Element.ALIGN_LEFT);
            context.setFont(contextFont);
            //段间距
            context.setSpacingBefore(3);

            document.add(context);

            //换行
            // document.add(new Paragraph("\n"));
        }




        //插如图片
        Image img = null;

        // 图片
        img = Image.getInstance("C:\\Users\\wb-gxy329407\\Desktop\\20171028.png");


        //img = Image.getInstance(svg_data.getBytes());
        float heigth = img.getHeight();
        float width = img.getWidth();
        int percent = getPercent2(heigth, width);
        img.setAlignment(Image.MIDDLE);
        img.scalePercent(percent + 3);// 表示是原来图像的比例;
        document.add(img);

        document.close();
    }


    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
     *
     */
    public static int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }

}