package com.resume.tools;


import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public class PDFUtil {
    /**
     * 将数据填入pdf模板
     *
     * @param in   pdf模板输入流
     * @param data 替换数据
     */
    public static ByteArrayOutputStream generate(InputStream in, Map data) throws Exception {
        PdfReader template = new PdfReader(in);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfStamper stamp = new PdfStamper(template, out);
//            获取pdf文件表单域
            AcroFields form = stamp.getAcroFields();
            //支持中文
            BaseFont font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
            //迭代map，将map对应的值写入表单
            for (Object o : data.keySet()) {
                String key = (String) o;
                String value = (String) data.get(key);
                form.setFieldProperty(key, "textfont", font, null);
                form.setField(key, value, value);
            }
            stamp.setFormFlattening(true);
            stamp.close();
            return out;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            template.close();
            in.close();
        }
    }
}
