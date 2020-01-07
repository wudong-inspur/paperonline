package com.sp.questionnaire.dao;

import java.util.List;

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
     * Query point man by id.
     *
     * @param id the id
     * @return the point man
     */
    PointMan queryPointManById(String id);
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

    /**
     * Gets the all pointman.
     * 
     * @return the all pointman
     */
    List<PointMan> getAllPointman();

    /**
     * Delete pointman.
     * 
     * @param id
     *            the id
     * @return the int
     */
    int deletePointman(String id);

    /**
     * Gets the pointman by id.
     * 
     * @param id
     *            the id
     * @return the pointman by id
     */
    PointMan getPointmanById(String id);
    
    
    int getPointmanCount();
}
