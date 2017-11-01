package com.splearn.Chapter1;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 生成work文档 并校验 iText 支持的及中字体
 */
public class DocFontTest {

    public static void main(String[] args) throws IOException, DocumentException {



        String path = "D:\\export\\Font.doc";

        //设置纸张大小
        Document document = new Document(PageSize.A4);
        //建立一个书写器，与document对象关联
        RtfWriter2.getInstance(document, new FileOutputStream(path));
        document.open();
        //设置中文字体
        BaseFont bfChinese = BaseFont.createFont();
        //BaseFont bfChinese = BaseFont.createFont("Courier-Bold",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        //设置标题的大小 粗体
        Font titleFont = new Font(bfChinese,20,Font.BOLD);
        Paragraph title = new Paragraph("总体分析");
        //设置标题格式对齐方式
        title.setAlignment(Element.ALIGN_CENTER);
        title.setFont(titleFont);
        //标题
        document.add(title);

        //---------------------------Font.BOLD---------------------------
        //正文字体风格
        Font contextFont = new Font(bfChinese,10,Font.BOLD);
        Paragraph context = new Paragraph("Font.BOLD》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.BOLD---------------------------

        //---------------------------Font.SYMBOL---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.SYMBOL);
        context = new Paragraph("Font.SYMBOL》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.SYMBOL---------------------------

        //---------------------------Font.NORMAL---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.NORMAL);
        context = new Paragraph("Font.NORMAL》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.NORMAL---------------------------

        //---------------------------Font.BOLDITALIC---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.BOLDITALIC);
        context = new Paragraph("Font.BOLDITALIC》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.BOLDITALIC---------------------------

        //---------------------------Font.COURIER---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.COURIER);
        context = new Paragraph("Font.COURIER》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.COURIER---------------------------

        //---------------------------Font.DEFAULTSIZE---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.DEFAULTSIZE);
        context = new Paragraph("Font.DEFAULTSIZE》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.DEFAULTSIZE---------------------------

        //---------------------------Font.HELVETICA---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.HELVETICA);
        context = new Paragraph("Font.HELVETICA》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.HELVETICA---------------------------

        //---------------------------Font.ITALIC---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.ITALIC);
        context = new Paragraph("Font.ITALIC》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.ITALIC---------------------------

        //---------------------------Font.STRIKETHRU---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.STRIKETHRU);
        context = new Paragraph("Font.STRIKETHRU》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.STRIKETHRU---------------------------

        //---------------------------Font.TIMES_ROMAN---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.TIMES_ROMAN);
        context = new Paragraph("Font.TIMES_ROMAN》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.TIMES_ROMAN---------------------------

        //---------------------------Font.UNDEFINED---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.UNDEFINED);
        context = new Paragraph("Font.UNDEFINED》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.UNDEFINED---------------------------

        //---------------------------Font.UNDERLINE---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.UNDERLINE);
        context = new Paragraph("Font.UNDERLINE》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.UNDERLINE---------------------------

        //---------------------------Font.UNDERLINE---------------------------
        //正文字体风格
        contextFont = new Font(bfChinese,10,Font.ZAPFDINGBATS);
        context = new Paragraph("Font.ZAPFDINGBATS》》》》     哈哈哈！");
        context.setAlignment(Element.ALIGN_LEFT);
        context.setFont(contextFont);
        //段间距
        context.setSpacingBefore(3);
        //内容
        document.add(context);
        //---------------------------Font.ZAPFDINGBATS---------------------------

        document.close();
        System.out.println("》》》》 生成word文档成功！");
    }

}
