package com.splearn.svgtopng.web;

import com.splearn.svgtopng.common.SvgPngConverter;
import org.apache.batik.transcoder.TranscoderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class convertToPngController {


    @RequestMapping("/convertToPng")
    public void convertToPng(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String svg_data = request.getParameter("chartData");
        System.out.println("svg_data"+svg_data);

        String file_path = "C:\\Users\\wb-gxy329407\\Desktop\\20171028.png";



        try {
            SvgPngConverter.convertToPng(svg_data,file_path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TranscoderException e) {
            e.printStackTrace();
        }

    }



}