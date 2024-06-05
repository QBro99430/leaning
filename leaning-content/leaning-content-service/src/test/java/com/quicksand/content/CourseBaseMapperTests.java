package com.quicksand.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quicksand.base.model.PageParams;
import com.quicksand.base.model.PageResult;
import com.quicksand.content.model.dto.QueryCourseParamsDto;
import com.quicksand.content.model.po.CourseBase;
import com.quicksand.content.mapper.CourseBaseMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: quicksand
 * @CreateTime: 2024-06-02
 * @Description: 测试
 * @Version: 1.0
 */
@SpringBootTest
public class CourseBaseMapperTests {

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Test
    void testCourseBaseMapper(){
        CourseBase courseBase = courseBaseMapper.selectById(74L);
        Assertions.assertNotNull(courseBase);

        //测试查询接口
        LambdaQueryWrapper<CourseBase> wrapper = new LambdaQueryWrapper<>();

        //查询条件
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("java");
        queryCourseParamsDto.setAuditStatus("202405");
        queryCourseParamsDto.setPublishStatus("203001");

        //拼接查询条件
        //根据课程名称模糊查询
        wrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()), CourseBase::getAuditStatus,
                queryCourseParamsDto.getAuditStatus());

        //分页参数
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L); //页码
        pageParams.setPageSize(3L); //每页记录数
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        //分页查询E page 分页参数, @Param("ew") Wrapper<T> queryWrapper 查询条件
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, wrapper);

        //数据
        List<CourseBase> items = pageResult.getRecords();
        //总记录数
        long total = pageResult.getTotal();

        //返回数据
        PageResult<CourseBase> result = new PageResult<>(items, total, pageParams.getPageNo(),
                pageParams.getPageSize());

        System.out.println(result);


    }
}
