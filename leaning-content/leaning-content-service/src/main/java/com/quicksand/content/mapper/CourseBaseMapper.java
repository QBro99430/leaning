package com.quicksand.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quicksand.content.model.po.CourseBase;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 * 课程基本信息 Mapper 接口
 * </p>
 *
 * @author quicksand
 */
@Mapper
public interface CourseBaseMapper extends BaseMapper<CourseBase> {

}
