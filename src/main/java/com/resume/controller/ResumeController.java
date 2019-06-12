package com.resume.controller;

import com.resume.model.Resume;
import com.resume.service.IResumeService;
import com.resume.tools.AjaxResult;
import com.resume.tools.PDFUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author shiyanlou
 */
@RestController
public class ResumeController {

    /**
     * 用于打印日志
     */
    private static Logger logger = LoggerFactory.getLogger(ResumeController.class);

    @Autowired
    private IResumeService resumeService;

    /**
     * 添加
     *
     * @param resume 简历信息
     */
    @PostMapping("add")
    public AjaxResult add(@RequestBody Resume resume) {
        resumeService.add(resume);
        return new AjaxResult("Add Success");
    }

    /**
     * 查询列表
     */
    @GetMapping("list")
    @ResponseBody
    public AjaxResult list() {
        List<Resume> list = resumeService.list();
        return new AjaxResult(list);
    }

    /**
     * 更新简历
     *
     * @param resume 更新信息
     */
    @PostMapping("update")
    public AjaxResult update(@RequestBody Resume resume) {
        resumeService.update(resume);
        return new AjaxResult("Update Success");
    }

    /**
     * 删除简历
     *
     * @param map the map
     */
    @PostMapping("delete")
    public AjaxResult delete(@RequestBody Map map) {
        resumeService.delete((Integer) map.get("id"));
        return new AjaxResult("Delete Success");
    }


    /**
     * 下载pdf
     *
     * @param response
     * @param id
     */
    @GetMapping("download")
    public void download(HttpServletResponse response, @RequestParam("id") int id) throws Exception {
        //获取简历
        Resume resume = resumeService.findBydId(id);
        //将简历数据添加到map
        HashMap<String, Object> hashMap = new HashMap<String, Object>(16);
        hashMap.put("name", resume.getName());
        hashMap.put("gender", resume.getGender());
        hashMap.put("age", String.valueOf(resume.getAge()));
        hashMap.put("address", resume.getAddress());
        hashMap.put("email", resume.getEmail());
        hashMap.put("tel", resume.getTel());
        hashMap.put("introduce", resume.getIntroduce());
        hashMap.put("major", resume.getMajor());
        hashMap.put("education", resume.getEducation());
        hashMap.put("school", resume.getSchool());
        hashMap.put("graduation", resume.getGraduation());
        hashMap.put("company", resume.getCompany());
        hashMap.put("position", resume.getPosition());
        hashMap.put("duty", resume.getDuty());
        hashMap.put("departure", resume.getDeparture());
        //文件名
        String fileName = resume.getName() + " - " + resume.getSchool() + ".pdf";
        ByteArrayOutputStream outputStream;
        //读取模板
        ClassPathResource resource = new ClassPathResource("resume.pdf");
        InputStream inputStream = resource.getInputStream();
        //替换模板数据，返回输出流
        outputStream = PDFUtil.generate(inputStream, hashMap);
        //将pdf输出流写入response输出流
        outputStream.writeTo(response.getOutputStream());
        //设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" +
                new String((fileName).getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Length", "" + outputStream.toByteArray().length);
        outputStream.close();
        response.getOutputStream().close();

    }

    /**
     * 统一异常处理
     *
     * @param e the e
     */
    @ExceptionHandler
    public AjaxResult exceptionHandler(Exception e) {
        //打印异常，方便调试
        if (logger.isDebugEnabled()) {
            e.printStackTrace();
        }
        return new AjaxResult(500,"System Error");
    }

}
