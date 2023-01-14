package com.lzx.mybili.mapper;

import com.lzx.mybili.dto.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayMapper {

    // 查询某个视频的选集  这里Play没有用无参构造  按照顺序将select的字段传给Play JavaBean
    @Select("select id, title, duration, url from play where bv=#{bv}")
    List<Play> findByBv(String bv);


    // 上传视频后 选集的数据也要入库 插入选集  play是JavaBean对象  bv是String
    @Insert("insert into play (id, title, duration, url, bv) " +
            "values (#{p.id}, #{p.title}, #{p.duration}, #{p.url}, #{bv})")
    void insert(@Param("p") Play play, @Param("bv") String bv);
}
