package com.xupt.util;

import com.xupt.vo.Article;
import com.xupt.vo.Forum;
import com.xupt.vo.Music;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工具类
 */
public class Utils {

    public static final Map map = new HashMap();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static int count = 0;

    public static List<Article> getRandomArticles(List<Article> list){
        Integer[] values = new Integer[list.size()];
        for(int i = 0;i < list.size();i++){
            values[i] = list.get(i).getArticle_id();
        }
        Random r = new Random();
        Integer num = null;
        while(true){
            num = Utils.getRandom();        //获取一个3 ~ 6随机数
            if(num <= list.size()){
                break;
            }
        }
        Integer result[] = new Integer[num];
        for (int i = 0;i < num;){
            Integer index = r.nextInt(values.length);
            if(Utils.removeDuplicateNum(result,values[index])) {
                result[i++] = values[index];
            }
        }
        List<Article> articles = new ArrayList<Article>();
        for (int i = 0;i < num;i++){
            for(int j = 0;j<list.size();j++){
                if(list.get(j).getArticle_id() == result[i]){
                    articles.add(list.get(j));
                    break;
                }
            }
        }
        return articles;
    }

    public static List<Music> getRandomMusics(List<Music> list){
        Integer[] values = new Integer[list.size()];
        for(int i = 0;i < list.size();i++){
            values[i] = list.get(i).getMusic_id();
        }
        Random r = new Random();
        Integer num = null;
        while(true){
            num = Utils.getRandom();        //获取一个3 ~ 6随机数
            if(num <= list.size()){
                break;
            }
        }
        Integer result[] = new Integer[num];
        for (int i = 0;i < num;){
            Integer index = r.nextInt(values.length);
            if(Utils.removeDuplicateNum(result,values[index])){
                result[i++] = values[index];
            }
        }
        List<Music> musics = new ArrayList<Music>();
        for (int i = 0;i < num;i++){
            for(int j = 0;j<list.size();j++){
                if(list.get(j).getMusic_id() == result[i]){
                    musics.add(list.get(j));
                    break;
                }
            }
        }
        return musics;
    }

    public static List<Forum> getRandomForums(List<Forum> list){
        Integer[] values = new Integer[list.size()];
        for(int i = 0;i < list.size();i++){
            values[i] = list.get(i).getForum_id();
        }
        Random r = new Random();
        Integer num = null;
        while(true){
            num = Utils.getRandom();        //获取一个3 ~ 4随机数
            if(num <= list.size()){
                break;
            }
        }
        Integer result[] = new Integer[num];
        for (int i = 0;i < num;){
            Integer index = r.nextInt(values.length);
            if(Utils.removeDuplicateNum(result,values[index])){
                result[i++] = values[index];
            }
        }
        List<Forum> forums = new ArrayList<Forum>();
        for (int i = 0;i < num;i++){
            for(int j = 0;j<list.size();j++){
                if(list.get(j).getForum_id() == result[i]){
                    forums.add(list.get(j));
                    break;
                }
            }
        }
        return forums;
    }

    /**
     * 获取3 ~ 4之间的随机整数
     * @return
     */
    public static Integer getRandom(){
        Integer num = null;
        while(true){
            num = (int)(Math.random() * 5);
            if(num >= 3 && num <= 4) {
                break;
            }
        }
        return num;
    }

    /**
     * 判断元素是否重复
     * @param nums
     * @param key
     * @return
     */
    public static Boolean removeDuplicateNum(Integer[] nums,Integer key){
        Boolean flag = false;
        int i;
        for(i = 0;i < nums.length && (nums[i] != key);i++);
        return (i < nums.length ? false : true);
    }

    /**
     * 读取过滤文件中的文字
     * @param src
     * @return
     */
    public static void readFilterProperties(String src){
        Properties props = new Properties();
        try{
            InputStream input = new BufferedInputStream(new FileInputStream(src));
            InputStreamReader in = new InputStreamReader(input,"utf-8");
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String value = props.getProperty(key);
                Utils.map.put(key, value);//把properties文件中的key-value存放到一个map中
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对于符合map中的key值实现替换功能
     * @param map
     * @param name
     * @return
     */
    public static String replaceCheck(Map map,String name){
        Integer senLen = 0;     //统计铭感文字个数
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String value = (String) map.get(key);
            if (name.contains(key)) {
                senLen += key.length();
                name=name.replace(key, value);//对于符合map中的key值实现替换功能
            }
        }
        if(senLen > name.length()/2){ //铭感文字超过内容一半
            name = null;
        }
        return name;
    }

    /**
     * 获取请求的 body
     * @param req
     * @return
     * @throws IOException
     */
    public synchronized static String getRequestBody(HttpServletRequest req){
        StringBuffer requestBody = null;
        try {
            BufferedReader reader = req.getReader();    //获取请求体的输入流
            String input = null;
            requestBody = new StringBuffer();
            while ((input = reader.readLine()) != null) {
                requestBody.append(input);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return requestBody.toString();
    }
}
