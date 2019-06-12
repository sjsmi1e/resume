package com.resume.service;

import com.resume.mapper.ResumeMapper;
import com.resume.model.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiyanlou
 */
@Service
public class ResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    /**
     * 添加
     *
     * @param resume
     */
    public void add(Resume resume) {
        resumeMapper.add(resume);
    }

    public List<Resume> list() {
        return resumeMapper.list();
    }

    /**
     * 更新
     *
     * @param resume
     */
    public void update(Resume resume) {
        resumeMapper.update(resume);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(int id) {
        resumeMapper.delete(id);
    }

    /**
     * 通过id获取信息
     *
     * @param id
     */
    public Resume findBydId(int id) {
        return resumeMapper.findById(id);
    }
}
