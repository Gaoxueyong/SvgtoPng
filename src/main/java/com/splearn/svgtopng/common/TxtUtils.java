package com.splearn.svgtopng.common;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  txt文件读取类
 */
public class TxtUtils {


    public static void main(String[] args) throws IOException {

//        long start = System.currentTimeMillis();
//
//        String readPath = "D:\\idea_workspace\\SvgtoPng\\src\\main\\java\\com\\splearn\\SvgtoPng\\anylize\\alarm_daily_stats.txt";
//
//        File fileRead = new File(readPath);
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileRead));
//
//        BufferedReader reader = new BufferedReader(isr);
//
//        String lineInfo = reader.readLine();
//        int i = 0;
//
//        while ((lineInfo = reader.readLine()) != null) {
//            System.out.println(lineInfo);
//        }
//
//
//        isr.close();
//        reader.close();
//        System.out.println(System.currentTimeMillis()-start);




      /*  String writePath = "D:\\tsss.txt";
        File fileWrite = new File(writePath);
        fileWrite.createNewFile();

        BufferedWriter bfw = new BufferedWriter(new FileWriter(fileWrite));
        bfw.write("D:\\阿里工作\\新需求\\报告数据\\hz_brain_inter_delay_value.txt\r\n");
        bfw.close();*/



        //后期可通过日期工具类获取
        //判断本周数据
        Map<String,Object> this_week_map = new HashMap<String,Object>();
        this_week_map.put("2017/10/02","2017/10/02");
        this_week_map.put("2017/10/03","2017/10/03");
        this_week_map.put("2017/10/04","2017/10/04");
        this_week_map.put("2017/10/05","2017/10/05");
        this_week_map.put("2017/10/06","2017/10/06");
        this_week_map.put("2017/10/07","2017/10/07");
        this_week_map.put("2017/10/08","2017/10/08");

        //判断上周数据
        Map<String,Object> last_week_map = new HashMap<String,Object>();
        last_week_map.put("2017/09/25","2017/09/25");
        last_week_map.put("2017/09/26","2017/09/26");
        last_week_map.put("2017/09/27","2017/09/27");
        last_week_map.put("2017/09/28","2017/09/28");
        last_week_map.put("2017/09/29","2017/09/29");
        last_week_map.put("2017/09/30","2017/09/30");
        last_week_map.put("2017/10/01","2017/10/01");

        String propertity_szd = "上匝道-堵点";

      String file_path = "D:\\idea_workspace\\SvgtoPng\\src\\main\\java\\com\\splearn\\SvgtoPng\\anylize\\alarm_daily_stats.txt";
      int szd_this_call_police_count = 0;
      List<List<String >> result = read_txt_array(file_path);
        for(List<String> da_str:result) {
            //日期             内容       数量
            //2017/07/01	断面-红色	    157
            String rq = da_str.get(0);
            String context = da_str.get(1);
            String count_num = da_str.get(2);


            if (!StringUtils.isEmpty(rq)) {
                if (this_week_map.containsValue(rq)) {


                    if (context.equals(propertity_szd)) {

                        szd_this_call_police_count += Integer.parseInt(count_num);//上匝道本周报警数量

                    }


                }
            }
        }
        System.out.println(szd_this_call_police_count);

    }


      /**
     * 读取txt文件集合数组
     * @param file_path
     * @return
     */
    public static List<List<String>> read_txt_array(String file_path)throws IOException{

        File fileRead = new File(file_path);
        if(!fileRead.exists()){
            return null;
        }
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileRead));

        BufferedReader reader = new BufferedReader(isr);

        String lineInfo = reader.readLine();

        List<List<String>> result = new ArrayList<List<String>>();
        String[] line_info_ary = null;

        while ((lineInfo = reader.readLine()) != null) {
            List<String> list = new ArrayList<String>();
            line_info_ary = lineInfo.split("\t");
            if(line_info_ary.length>0){
                for(int i=0;i<line_info_ary.length;i++){
                    list.add(line_info_ary[i]);
                }
                result.add(list);
            }
        }
        isr.close();
        reader.close();
        return result;
    }


    /**
     * 读取txt文件集合数组
     * @param file_path
     * @return
     */
    public static List<Map<String,Object>> read_txt_to_listMap(String file_path)throws IOException{

        File fileRead = new File(file_path);
        if(!fileRead.exists()){
            return null;
        }
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileRead));

        BufferedReader reader = new BufferedReader(isr);

        String lineInfo = reader.readLine();

        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        String[] line_info_ary = null;
        String[] index_name = {"inter_id","inter_name","coors","date_day","dayofweek","time_point","real_index_bal","real_index_del","real_index_node","alarm_color","update_date"};

       // int j=1;
        while ((lineInfo = reader.readLine()) != null) {
            Map<String,Object> map = new HashMap<String,Object>();
            line_info_ary = lineInfo.split("\t");
            if(line_info_ary.length>0){
                   /*if(Integer.parseInt(line_info_ary[4])<5 && line_info_ary[9].equals("1")){*/
                //if(Integer.parseInt(line_info_ary[4])<5){

                    for(int i=0;i<line_info_ary.length;i++){
                        map.put(index_name[i],line_info_ary[i]);
                    }
                    //System.out.println(j+">>>>>>>>>"+ map);
                    result.add(map);
               // }
               // j++;
            }
        }
        isr.close();
        reader.close();
        return result;
    }


}
