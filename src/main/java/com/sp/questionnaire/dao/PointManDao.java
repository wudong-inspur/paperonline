package com.sp.questionnaire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sp.questionnaire.entity.PointMan;

/**
 * description: Author:Xiaowanwan Date:2018/9/13-10:48
 */
public interface PointManDao {

    /**
     * 插入一条指示者信息.
     * 
     * @param pm
     *            the pm
     * @return the int
     */
    int insertPointMan(PointMan pm);

    /**
     * Query point man by no.
     * 
     * @param pointmanNo
     *            the pointman no
     * @return the list
     */
    PointMan queryPointManByNo(String pointmanNo);

    /**
     * Query pointman paging.
     * 
     * @param currentPage
     *            the current page
     * @param pageSize
     *            the page size
     * @return the page list bean
     */
    List<PointMan> queryPointmanPaging(@Param("page") Integer page, @Param("pageSize") Integer pageSize,
            @Param("field") String field, @Param("dir") String dir);

    List<PointMan> queryPointmanPaging(Map<String, Integer> map);
}
