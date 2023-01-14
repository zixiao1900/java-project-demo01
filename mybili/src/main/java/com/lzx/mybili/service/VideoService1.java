package com.lzx.mybili.service;

import com.lzx.mybili.dto.Play;
import com.lzx.mybili.dto.Video;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 从文件中获取视频数据
 */
@Service
public class VideoService1 {

    // 存Video对象  init()方法只会比调用一次 只会读一次p.csv文件 然后创建Video对象 存在内存的HashMap中
    // 以后每次find方法被调用时 就可以直接从HashMap中取的对象 不用每次都读文件了
    Map<String, Video> map = new HashMap<>();

    @PostConstruct // 这是一个初始化方法 对象创建之后只会调用一次 构造方法也是只调用一次 但是逻辑一般不写在构造方法里
    public void init() { // 初始化方法
        try {
            // 读取p.csv 读取2个视频的信息 创建两个Video对象
            List<String> data = Files.readAllLines(Paths.get("data/p.csv")); // 编译时抛出异常 要么写在方法后面throws IOException继续把异常抛给上级方法 要么try catch处理
            for (String line : data) {
                String[] s = line.split(",");
                // 找到了bv
                String[] tags = s[7].split("_");
                // 读取选集文件  由文件转为Play对象存在List中
                List<Play> playList = getPlayList(s[0]);
                Video video = new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(tags), playList, s[1], s[2]);
                map.put(s[0], video); // 根据p文件每行创建一个Video对象并存在hashmap里
            }
        } catch (IOException e) { // 捕捉编译时异常
            // 抛出运行时异常RuntimeException  不再要求上级代码加try catch 或者 throws
            throw new RuntimeException(e);
        }
    }

    // Map集合存init方法里创建的Video对象  find方法就直接可以查到Video对象使用

    // 查询方法  调用多次  视频编号  查询Video对象
    public Video find(String bv) { // bv 参数代表要查询的视频编号
        return map.get(bv);

//        try {
//            List<String> data = Files.readAllLines(Paths.get("data/p.csv")); // 编译时抛出异常 要么写在方法后面throws IOException继续把异常抛给上级方法 要么try catch处理
//
//            for (String line : data) {
//                String[] s = line.split(",");
//                if (s[0].equals(bv)) {
//                    // 找到了bv
//                    String[] tags = s[7].split("_");
//
//                    // 读取选集文件  由文件转为Play对象存在List中
//                    List<Play> playList = getPlayList(bv);
//
//                    return new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(tags), playList, s[1], s[2]);
//                }
//            }
//            // 没有找到
//            return null;
//        } catch (IOException e) { // 捕捉编译时异常
//            // 抛出运行时异常RuntimeException  不再要求上级代码加try catch 或者 throws
//            throw new RuntimeException(e);
//        }
    }


    /**
     * 根据bv的id值 读取文件 创建Play对象存入List并返回List
     * @param bv
     * @return
     */
    private List<Play> getPlayList(String bv) {
        try { // try catch快捷键 ctrl + alt + t
            List<String> vData = Files.readAllLines(Paths.get("data/v_" + bv + ".csv"));
            List<Play> playList = new ArrayList<>();
            for (String vLine : vData) {
                String[] ss = vLine.split(",");
                playList.add(new Play(ss[0], ss[1], LocalTime.parse(ss[3]), ss[2]));
            }
            return playList;
        } catch (IOException e) {
            throw new RuntimeException(e); // todo 将编译时异常捕获 抛出运行时异常  异常的转换
        }
    }
}
