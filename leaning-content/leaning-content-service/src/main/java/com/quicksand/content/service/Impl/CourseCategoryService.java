package com.quicksand.content.service.Impl;

import com.quicksand.content.mapper.CourseCategoryMapper;
import com.quicksand.content.model.dto.CourseCategoryTreeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 课程树形结构查询实现类
 * </p>
 *
 * @Author quicksand
 */
@Service
@Slf4j
public class CourseCategoryService implements com.quicksand.content.service.CourseCategoryService {

    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    /**
     * 课程分类树形结构查询
     * @param id
     * @return
     */
    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes(id);
        //List转Map, 以备使用，排除根节点
        Map<String, CourseCategoryTreeDto> mapTemp = courseCategoryTreeDtos.stream().filter(
                item -> !id.equals(item.getId())
        ).collect(Collectors.toMap(
                key -> key.getId(), value -> value, (key1, key2) -> key2));
        //最终返回的list
        List<CourseCategoryTreeDto> categoryTreeDtos = new ArrayList<>();

        //依次遍历每个元素，排除根节点
        courseCategoryTreeDtos.stream().filter(
                item -> !id.equals(item.getId())).forEach(
                        item ->{
                            if (item.getParentid().equals(id)){
                                categoryTreeDtos.add(item);
                            }
                            //找到当前节点的父节点
                            CourseCategoryTreeDto courseCategoryTreeDto = mapTemp.get(item.getParentid());
                            if (courseCategoryTreeDto != null){
                                if (courseCategoryTreeDto.getChildrenTreeNodes() == null){
                                    courseCategoryTreeDto.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                                }
                                //往ChildrenTreeNodes属性中放子节点
                                courseCategoryTreeDto.getChildrenTreeNodes().add(item);
                            }
                        });

        return categoryTreeDtos;
    }
}
