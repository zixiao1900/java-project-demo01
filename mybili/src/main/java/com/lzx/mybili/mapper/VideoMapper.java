package com.lzx.mybili.mapper;

import com.lzx.mybili.dto.Video;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {
    // 根据bv号查询视频  JavaBean类实现无参构造 这样就是根据字段的名称 将查询的字段结果映射给实例 名字完全一样才能映射 不然就返回null
    @Select("select " +
            "bv, type, category, title, cover, introduction, publish_time, tags " +
            "from video where bv=#{bv}")
    Video findByBv(String bv);
    /*
    Video这个JavaBean中如果实现无参构造 那么这里查询的字段会和JavaBean中的字段对应上
    关于publish_time和JavaBean中publishTime的情况 可以在resources/application.properties中设置 就可以对应上了
    数组库中字段类型和JavaBean中类型不同的 即使名称相同也无法对应上 JavaBean中只会返回null
     */


    // 上传视频之后要把数据同步要数据库 这里gexMaxBv是insert必须要走的一步 在TestVideoMapper中可以看到
    @Insert("insert into Video (bv, type, category, title, cover, introduction, publish_time, tags) " +
            "values (#{bv}, #{v.type}, #{v.category}, #{v.title}, #{v.cover}, #{v.introduction}, #{v.publishTime}, #{v.tags})")
    void insert(@Param("v") Video video, @Param("bv") String bv);

    @Select("select max(bv + 0) from video") // + 0就自动将varchar转为数值比较
    int getMaxBv();
}
