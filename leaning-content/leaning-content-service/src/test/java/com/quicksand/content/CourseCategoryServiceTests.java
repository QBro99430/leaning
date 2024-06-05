package com.quicksand.content;

import com.quicksand.content.model.dto.CourseCategoryTreeDto;
import com.quicksand.content.service.CourseCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Author quicksand
 */
@SpringBootTest
public class CourseCategoryServiceTests {

    @Autowired
    CourseCategoryService courseCategoryService;

    @Test
    void testQueryTreeNodes(){
        List<CourseCategoryTreeDto> categoryTreeDtos = courseCategoryService.queryTreeNodes("1");
        System.out.println(categoryTreeDtos);
    }
}
