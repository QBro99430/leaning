package com.quicksand.content.model.dto;


import lombok.Data;
import lombok.ToString;

/**
 * 课表查询参数dto
 */
@Data
@ToString
public class QueryCourseParamsDto {

    //审核状态
    private String auditStatus;

    //课程名称
    private String courseName;

    //发布状态
    private String publishStatus;
}
