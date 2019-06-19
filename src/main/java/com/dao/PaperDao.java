package com.dao;

import com.pojo.Paper;

import java.util.List;

/**
 * @program:lunwen
 * @description:
 * @author:Mr.Chen
 * @create:2019-06-15 22:07
 **/
public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();

}
