package com.splearn.svgtopng.web;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.rtf.RtfWriter2;
import com.splearn.svgtopng.anylize.HighchartsDataUtils;
import com.splearn.svgtopng.common.SvgPngConverter;
import org.apache.batik.transcoder.TranscoderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description( Hightcharts 图表数据导出并生成word 的demo)
 * author: gaoxueyong
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping( value = "/getData_rbjl", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getHighchartsData_rbjl() throws IOException {

        String file_path = "D:\\idea_workspace\\GitHub\\SvgtoPng\\src\\main\\java\\com\\splearn\\svgtopng\\anylize\\test_data.txt";
        Map<String,Object> result = new HashMap<String,Object>();
        result = HighchartsDataUtils.alarm_cnt_ts_rbjl(file_path);
        result.put("title","日报警量");
        return result;
    }


    @RequestMapping( value = "/getData_xzddd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getHighchartsData_xzddd() throws IOException {

        String file_path = "D:\\idea_workspace\\GitHub\\SvgtoPng\\src\\main\\java\\com\\splearn\\svgtopng\\anylize\\test_data.txt";
        Map<String,Object> result = new HashMap<String,Object>();
        result = HighchartsDataUtils.alarm_cnt_ts_xzddd(file_path,"测试-下堵点");
        result.put("title","测试-下堵点");
        return result;
    }

    @RequestMapping( value = "/getData_common", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getHighchartsData_common(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String,Object> result = new HashMap<String,Object>();
        String file_path = "D:\\idea_workspace\\GitHub\\SvgtoPng\\src\\main\\java\\com\\splearn\\svgtopng\\anylize\\test_data.txt";

        String type  = request.getParameter("type");//dmhs  lkhs szddd xzddd
        List<Integer> tick_positions_list = new ArrayList<Integer>();
        if("dmhs".equals(type)){

            tick_positions_list = new ArrayList<Integer>();
            tick_positions_list.add(0);
            tick_positions_list.add(200);
            tick_positions_list.add(400);
            tick_positions_list.add(600);
            tick_positions_list.add(800);
            tick_positions_list.add(1000);
            result = HighchartsDataUtils.alarm_cnt_ts_common(file_path,tick_positions_list,"测试-红色");
        }else if("lkhs".equals(type)){

            tick_positions_list = new ArrayList<Integer>();
            tick_positions_list.add(0);
            tick_positions_list.add(1000);
            tick_positions_list.add(2000);
            tick_positions_list.add(3000);
            tick_positions_list.add(4000);
            tick_positions_list.add(5000);
            result = HighchartsDataUtils.alarm_cnt_ts_common(file_path,tick_positions_list,"测试-蓝色");
        }else if("szddd".equals(type)){

            tick_positions_list = new ArrayList<Integer>();
            tick_positions_list.add(0);
            tick_positions_list.add(100);
            tick_positions_list.add(200);
            tick_positions_list.add(300);
            tick_positions_list.add(400);
            tick_positions_list.add(500);
            tick_positions_list.add(600);
            result = HighchartsDataUtils.alarm_cnt_ts_common(file_path,tick_positions_list,"测试-上堵点");
        }else if("xzddd".equals(type)){

            tick_positions_list = new ArrayList<Integer>();
            tick_positions_list.add(0);
            tick_positions_list.add(5);
            tick_positions_list.add(10);
            tick_positions_list.add(15);
            tick_positions_list.add(20);
            result = HighchartsDataUtils.alarm_cnt_ts_common(file_path,tick_positions_list,"测试-下堵点");
        }

        return result;
    }


    @RequestMapping( value = "/export",method = RequestMethod.POST)
    public void convertToPng(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException, com.itextpdf.text.DocumentException {

        long start  = System.currentTimeMillis();
        Map<String,Object> ret_map = new HashMap<String, Object>();
        ret_map.put("success",false);
        ret_map.put("msg","生成Word失败!");
        try {

            List<String> pic_path_list = new ArrayList<String>();

            //日报警量
            String svg_data_rbjl = request.getParameter("svg_data_rbjl");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            String png_path = "D:\\export\\svg_data_rbjl.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_rbjl,png_path);
            pic_path_list.add(png_path);

            //下匝道报警量
            String svg_data_container_xzddd = request.getParameter("svg_data_container_xzddd");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            png_path = "D:\\export\\svg_data_container_xzddd.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_container_xzddd,png_path);
            pic_path_list.add(png_path);

            //通用 测试-红色 日报警量
            String svg_data_container_common_dmhs = request.getParameter("svg_data_container_common_dmhs");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            png_path = "D:\\export\\svg_data_container_common_dmhs.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_container_common_dmhs,png_path);
            pic_path_list.add(png_path);

            //通用 测试-蓝色 日报警量
            String svg_data_container_common_lkhs = request.getParameter("svg_data_container_common_lkhs");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            png_path = "D:\\export\\svg_data_container_common_lkhs.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_container_common_lkhs,png_path);
            pic_path_list.add(png_path);

            //通用 上匝道 日报警量
            String svg_data_container_common_szddd = request.getParameter("svg_data_container_common_szddd");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            png_path = "D:\\export\\svg_data_container_common_szddd.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_container_common_szddd,png_path);
            pic_path_list.add(png_path);

            //通用 下匝道 日报警量
            String svg_data_container_common_xzddd = request.getParameter("svg_data_container_common_xzddd");
            //System.out.println("svg_data_rbjl"+svg_data_rbjl);
            png_path = "D:\\export\\svg_data_container_common_xzddd.png";
            //生成图片
            SvgPngConverter.convertToPng(svg_data_container_common_xzddd,png_path);
            pic_path_list.add(png_path);


            //写入doc

            List<String> list_content = new ArrayList<String>();

            list_content.add("    本周（2017/10/02 - 2017/10/08）平台总体报警数量 7960，上周（2017/09/25 - 2017/10/01）平台总体报警数量 26607，环比下降 70.08%。    ");
            list_content.add("     \uF06C\t测试-红色本周平台总体报警数量 2591，上周平台总体报警数量 3195，环比下降  18.90%。");
            list_content.add("     \uF06C\t测试-上堵点本周平台总体报警数量 992，上周平台总体报警数量 2330，环比下降  57.42%。");
            list_content.add("     \uF06C\t测试-蓝色本周平台总体报警数量 4365，上周平台总体报警数量 21071，环比下降 79.28%。");
            list_content.add("     \uF06C\t测试-下堵点本周平台总体报警数量 12，上周平台总体报警数量 11，环比上升 9.09%。 ");

            String type = request.getParameter("type");
            String base_path =  request.getContextPath()+"/temp/";
            String file_path = "";
            File file = new File(base_path);
            if(!file.exists()){
                file.mkdir();
            }

            String file_name =  "日报警量.doc";
            if(type.equals("PDF")){
                file_name=  "日报警量.pdf";
            }
            file_path = base_path+file_name;

            //输入流
            InputStream fin = null;
            //输出流
            ServletOutputStream out = response.getOutputStream();

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            // 设置浏览器以下载的方式处理该文件名
            response.setHeader("Content-Disposition", "attachment;filename=" .concat(String.valueOf(URLEncoder.encode(file_name, "UTF-8"))));
            //生成临时文件
            createWordORPDF(file_path,list_content,pic_path_list,type);
            //读取临时文件
            fin = new FileInputStream(file_path);
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            //上次临时文件
            File temp_file = new File(file_path);
            if(temp_file.exists()){
                temp_file.delete();
            }
            if(fin!=null){

                fin.close();
            }
            if(out!=null){

                out.close();

            }



            ret_map.put("success",true);
            ret_map.put("msg","生成Word成功! 耗时："+((System.currentTimeMillis()-start)/1000)+"秒");
        } catch (IOException e) {
            ret_map.put("msg","生成Word出现异常!原因："+e.getMessage());
            e.printStackTrace();
        } catch (TranscoderException e) {
            ret_map.put("msg","生成Word出现异常!原因："+e.getMessage());
            e.printStackTrace();
        }finally {
           // return  ret_map;
        }

    }


    public void createWordORPDF(String path,List<String> list_content,List<String> pic_path_list,String type) throws IOException, DocumentException{
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            Document doc = new Document(PageSize.A4, 20, 20, 20, 20);

            if("WORD".equals(type)){
                RtfWriter2.getInstance(doc, new FileOutputStream(path));
            }else if("PDF".equals(type)){
                PdfWriter.getInstance(doc, new FileOutputStream(path));
            }
            doc.open();

            //标题字体
            Font titleFont = new Font(bfChinese,20,Font.BOLD);
            String doctitle=  "总体分析";
            // 标题
            Paragraph title = new Paragraph(doctitle, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);


        for(String content:list_content){

            //正文字体风格
            Font contextFont = new Font(bfChinese,10,Font.NORMAL);
            Paragraph context = new Paragraph(content,contextFont);
            context.setAlignment(Element.ALIGN_LEFT);
            //段间距
            context.setSpacingBefore(3);

            //内容
            doc.add(context);

            //换行
            // document.add(new Paragraph("\n"));
        }

        //插如图片
        Image img = null;
        for(String pic_path:pic_path_list){

            // 图片
            img = Image.getInstance(pic_path);
            //img = Image.getInstance(svg_data.getBytes());
            float heigth = img.getHeight();
            float width = img.getWidth();
            int percent = getPercent(heigth, width);
            img.setAlignment(Image.MIDDLE);
            img.scalePercent(percent + 3);// 表示是原来图像的比例;
            doc.add(img);
        }
        doc.close();


    }


    /**
     * 第二种解决方案，统一按照宽度压缩 这样来的效果是，所有图片的宽度是相等的，自我认为给客户的效果是最好的
     *
     */
    public static int getPercent(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }

}