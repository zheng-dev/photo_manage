package me.servlet;

import me.bean.PhotoInfo;
import me.dao.PhotoInfoDao;
import me.lib.Md5;
import me.lib.Util;
import me.lib.ZoomImage;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;

/**
 * Created by zzc on 2017/12/13.
 */
@MultipartConfig(maxFileSize = Util.UPLOAD_SIZE)
@WebServlet(urlPatterns = {"/add_photo"})
public class HelloServlet extends HttpServlet {
//    private static MultipartConfig config = HelloServlet.class.getAnnotation(MultipartConfig.class);

    public HelloServlet() {
        //empty
    }

    private boolean allowFile(String suffix) {
        return "jpg".equals(suffix) || "png".equals(suffix) || "jpeg".equals(suffix);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        StringBuilder state = new StringBuilder();
        try {
            Part part = request.getPart("file");
            String fileName = part.getSubmittedFileName();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!this.allowFile(suffix) || part.getSize() < 1)
                response.getWriter().print("file error[suffix,size]" + suffix);
            else {

                byte[] content = new byte[Util.UPLOAD_SIZE];
                part.getInputStream().read(content);
                String md5Name = Md5.getMD5(content);

                StringBuilder fullName = new StringBuilder(md5Name).append(".").append(suffix);
                StringBuilder scaleName = new StringBuilder("scale_").append(fullName);

                PhotoInfo addP = new PhotoInfo();
                addP.setScale_photo(scaleName.toString());
                addP.setFull_photo(fullName.toString());
                addP.setPhoto_name(request.getParameter("photo_name"));//上传的文件名
                addP.setDescription(request.getParameter("description"));//上传的描述

                PhotoInfoDao pd = new PhotoInfoDao();
                if (pd.add(addP)) {
                    BufferedImage buffImage = ImageIO.read(part.getInputStream());//取出图片内容来生成缩略图

                    int oWidth = buffImage.getWidth();
                    int oHeight = buffImage.getHeight();
                    //todo 路径最好配置
                    String basePath = this.getServletContext().getRealPath("/");
                    String path = basePath + "/photo/";
                    state.append("ok_").append(path).append("<br/>w=").append(oWidth).
                            append("h=").append(oHeight).append("<br />").append(fullName);

                    part.write(new StringBuilder(path).append("/").append(fullName).toString());//保存上传的原文件
                    ZoomImage.zoomImageUtils(suffix, new StringBuilder(path).append("/").append(scaleName).toString(), buffImage, 100, 100);
                    part.delete();
                } else state.append("add_err_repeat");
            }

        } catch (IllegalStateException ise) {
            ise.printStackTrace();
        } catch (Exception e) {
            state.append("file null");
        }
        response.sendRedirect(new StringBuilder("/add_photo.jsp?state=").append(URLEncoder.encode(state.toString())).toString());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
