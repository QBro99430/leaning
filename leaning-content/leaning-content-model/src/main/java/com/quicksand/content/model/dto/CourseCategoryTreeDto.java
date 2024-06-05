package com.quicksand.content.model.dto;

import com.quicksand.content.model.po.CourseCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 课程分类树型结点 DTO
 * </p>
 *
 * @Author quicksand
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {

    List<CourseCategoryTreeDto> childrenTreeNodes;
}
