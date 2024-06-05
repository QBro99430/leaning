package com.quicksand.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quicksand.content.model.dto.CourseCategoryTreeDto;
import com.quicksand.content.model.po.CourseCategory;

import java.util.List;


/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author quicksand
 */
public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {

    List<CourseCategoryTreeDto> selectTreeNodes(String id);

}
