package com.resume.service;

import com.resume.model.Resume;

import java.util.List;

/**
 * @author shiyanlou
 */
public interface IResumeService {
    /**
     * 添加
     *
     * @param resume
     */
    void add(Resume resume);

    /**
     * 查询列表
     *
     * @return
     */
    List<Resume> list();

    /**
     * 更新
     *
     * @param resume
     */
    void update(Resume resume);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     * 通过id获取信息
     */
    Resume findBydId(int id);
}
