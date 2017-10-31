package com.splearn.svgtopng.anylize;

import com.splearn.svgtopng.common.TxtUtils;

import java.io.IOException;
import java.util.*;

/*
* 获取Highcharts图表的动态数据
* */
public class HighchartsDataUtils {


    /**
     * 获取 20170923~20171008 期间的日报警数量
     * @param  file_path
     */
    public static Map<String,Object> alarm_cnt_ts_rbjl(String file_path) throws IOException {

        //校验的日期范围
        Map<String,Object> map_date = new LinkedHashMap<String,Object>();
        map_date.put("2017/09/23","2017/09/23");
        map_date.put("2017/09/24","2017/09/24");
        map_date.put("2017/09/25","2017/09/25");
        map_date.put("2017/09/26","2017/09/26");
        map_date.put("2017/09/27","2017/09/27");
        map_date.put("2017/09/28","2017/09/28");
        map_date.put("2017/09/29","2017/09/29");
        map_date.put("2017/09/30","2017/09/30");
        map_date.put("2017/10/01","2017/10/01");
        map_date.put("2017/10/02","2017/10/02");
        map_date.put("2017/10/03","2017/10/03");
        map_date.put("2017/10/04","2017/10/04");
        map_date.put("2017/10/05","2017/10/05");
        map_date.put("2017/10/06","2017/10/06");
        map_date.put("2017/10/07","2017/10/07");
        map_date.put("2017/10/08","2017/10/08");

        List<String> categories = new ArrayList<String>();

        for(String key:map_date.keySet()){
            categories.add(key.replaceAll("/",""));
        }

        //元数据
        List<List<String>> data = TxtUtils.read_txt_array(file_path);

        List<Integer> tick_positions_list = new ArrayList<Integer>();
        tick_positions_list.add(0);
        tick_positions_list.add(1000);
        tick_positions_list.add(2000);
        tick_positions_list.add(3000);
        tick_positions_list.add(4000);
        tick_positions_list.add(5000);
        List<Integer> szd_dd_postions_list = new ArrayList<Integer>();
        List<Integer> lk_hs_postions_list = new ArrayList<Integer>();
        List<Integer> dm_hs_postions_list = new ArrayList<Integer>();
        List<Integer> xzd_dd_postions_list = new ArrayList<Integer>();



        for(List<String> list_data: data){

            //日期             内容       数量
            //2017/07/01	测试-红色	    157
            String rq = list_data.get(0);
            String context = list_data.get(1);
            String count_num = list_data.get(2);

            if(map_date.containsValue(rq)){

                for(String key:map_date.keySet()){
                    if(key.equals(rq)){
                       if("测试-红色".equals(context)){
                           if(count_num!=null && !"".equals(count_num)){

                               dm_hs_postions_list.add(Integer.parseInt(count_num));

                           }
                       }else if("测试-上堵点".equals(context)){

                           if(count_num!=null && !"".equals(count_num)){

                               szd_dd_postions_list.add(Integer.parseInt(count_num));

                           }

                       }else if("测试-下堵点".equals(context)){
                           if(count_num!=null && !"".equals(count_num)){

                               xzd_dd_postions_list.add(Integer.parseInt(count_num));

                           }

                       }else if("测试-蓝色".equals(context)){

                           if(count_num!=null && !"".equals(count_num)){

                               lk_hs_postions_list.add(Integer.parseInt(count_num));

                           }

                       }
                    }
                }

            }else{
                continue;
            }

        }

        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",false);

        result.put("categories",categories); //x轴数据
        result.put("tickPositions",tick_positions_list);//y轴数据

        //坐标点
        List<Map<String,Object>> series = new ArrayList<Map<String,Object>>();

        Map<String,Object> szd_dd = new HashMap<String, Object>();
        szd_dd.put("name","测试-上堵点");
        szd_dd.put("data",szd_dd_postions_list);

        series.add(szd_dd);


        Map<String,Object> lk_hs = new HashMap<String, Object>();
        lk_hs.put("name","测试-蓝色");
        lk_hs.put("data",lk_hs_postions_list);
        series.add(lk_hs);

        Map<String,Object> dm_hs = new HashMap<String, Object>();
        dm_hs.put("name","测试-红色");
        dm_hs.put("data",dm_hs_postions_list);
        series.add(dm_hs);

        Map<String,Object> xzd_dd = new HashMap<String, Object>();
        xzd_dd.put("name","测试-下堵点");
        xzd_dd.put("data",xzd_dd_postions_list);
        series.add(xzd_dd);

        result.put("series",series);

        result.put("success",true);



        return result;
    }
    /**
     * 获取 20170923~20171008 期间的日报警数量  测试-下堵点
     * @param address
     * @param  file_path
     */
    public static Map<String,Object> alarm_cnt_ts_xzddd(String file_path,String address) throws IOException {

        //校验的日期范围
        Map<String,Object> map_date = new LinkedHashMap<String,Object>();
        map_date.put("2017/09/23","2017/09/23");
        map_date.put("2017/09/24","2017/09/24");
        map_date.put("2017/09/25","2017/09/25");
        map_date.put("2017/09/26","2017/09/26");
        map_date.put("2017/09/27","2017/09/27");
        map_date.put("2017/09/28","2017/09/28");
        map_date.put("2017/09/29","2017/09/29");
        map_date.put("2017/09/30","2017/09/30");
        map_date.put("2017/10/01","2017/10/01");
        map_date.put("2017/10/02","2017/10/02");
        map_date.put("2017/10/03","2017/10/03");
        map_date.put("2017/10/04","2017/10/04");
        map_date.put("2017/10/05","2017/10/05");
        map_date.put("2017/10/06","2017/10/06");
        map_date.put("2017/10/07","2017/10/07");
        map_date.put("2017/10/08","2017/10/08");

        List<String> categories = new ArrayList<String>();

        for(String key:map_date.keySet()){
            categories.add(key.replaceAll("/",""));
        }

        //元数据
        List<List<String>> data = TxtUtils.read_txt_array(file_path);

        List<Integer> tick_positions_list = new ArrayList<Integer>();
        tick_positions_list.add(0);
        tick_positions_list.add(2);
        tick_positions_list.add(4);
        tick_positions_list.add(6);
        tick_positions_list.add(8);
        tick_positions_list.add(10);

        List<Integer> xzd_dd_postions_list = new ArrayList<Integer>();



        for(List<String> list_data: data){

            //日期             内容       数量
            //2017/07/01	测试-红色	    157
            String rq = list_data.get(0);
            String context = list_data.get(1);
            String count_num = list_data.get(2);

            if(map_date.containsValue(rq)){

                for(String key:map_date.keySet()){
                    if(key.equals(rq)){
                        if(address.equals(context)){
                            if(count_num!=null && !"".equals(count_num)){

                                xzd_dd_postions_list.add(Integer.parseInt(count_num));

                            }

                        }
                    }
                }

            }else{
                continue;
            }

        }

        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",false);

        result.put("categories",categories);
        result.put("tickPositions",tick_positions_list);

        List<Map<String,Object>> series = new ArrayList<Map<String,Object>>();

        Map<String,Object> xzd_dd = new HashMap<String, Object>();
        xzd_dd.put("name",address);
        xzd_dd.put("data",xzd_dd_postions_list);
        series.add(xzd_dd);

        result.put("series",series);

        result.put("success",true);

        return result;
    }


    /**
     * 获取 2017-07-05 ~ 2017-10-08 期间的每日的报警数量
     * @param file_path
     * @param tick_positions_list  y坐标轴数据
     * @param address 地址
     * @return
     * @throws IOException
     */
    public static Map<String,Object> alarm_cnt_ts_common(String file_path,List<Integer> tick_positions_list,String address) throws IOException {

        //校验的日期范围
        Map<String,Object> map_date = new LinkedHashMap<String,Object>();
        //7月份数据
        for(int i=5;i<=31;i++){
            if(i<10){
                map_date.put("2017/07/0"+i,"2017/07/0"+i);
            }else{
                map_date.put("2017/07/"+i,"2017/07/"+i);
            }
        }
        //8月份数据
        for(int i=1;i<=31;i++){
            if(i<10){
                map_date.put("2017/08/0"+i,"2017/08/0"+i);
            }else{
                map_date.put("2017/08/"+i,"2017/08/"+i);
            }
        }
        //9月份数据
        for(int i=1;i<=30;i++){
            if(i<10){
                map_date.put("2017/09/0"+i,"2017/09/0"+i);
            }else{
                map_date.put("2017/09/"+i,"2017/09/"+i);
            }
        }

        //10月份数据
        for(int i=1;i<=8;i++){
            map_date.put("2017/09/0"+i,"2017/09/0"+i);
        }


        List<String> categories = new ArrayList<String>();

        for(String key:map_date.keySet()){
            categories.add(key.replaceAll("/",""));
        }

        //元数据
        List<List<String>> data = TxtUtils.read_txt_array(file_path);

        //每一日的坐标点
        List<Integer> postions_list = new ArrayList<Integer>();

        for(List<String> list_data: data){

            //日期             内容       数量
            //2017/07/01	测试-红色	    157
            String rq = list_data.get(0);
            String context = list_data.get(1);
            String count_num = list_data.get(2);

            if(map_date.containsValue(rq)){

                for(String key:map_date.keySet()){
                    if(key.equals(rq)){
                        if(address.equals(context)){
                            if(count_num!=null && !"".equals(count_num)){
                                postions_list.add(Integer.parseInt(count_num));

                            }

                        }
                    }
                }

            }else{
                continue;
            }

        }

        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",false);

        result.put("title",address);

        result.put("categories",categories);//x轴数据
        result.put("tickPositions",tick_positions_list);//y轴数据

        List<Map<String,Object>> series = new ArrayList<Map<String,Object>>();

        Map<String,Object> map_data = new HashMap<String, Object>();
        map_data.put("name",address);//名称
        map_data.put("data",postions_list);//坐标点
        series.add(map_data);

        result.put("series",series);

        result.put("success",true);

        return result;
    }
}
