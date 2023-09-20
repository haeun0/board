package com.green.board7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration //
public class MvcConfig implements WebMvcConfigurer {
    @Value("${file.dir}")//절대경로 (완벽한 경로),
    private String fildDir;


    @Override //addResourceHandlers 리소스 조종하겠다 라는 메소드
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        exposDirectory(fildDir,registry);
    }

    private void exposDirectory(String dirName, ResourceHandlerRegistry registry){
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        if (dirName.startsWith("../"))dirName=dirName.replace("../","");
        registry.addResourceHandler("/images/**") //만약 images로 시작하는 경로라면
                .addResourceLocations("file:/"+uploadPath+"/"); //file:/"+uploadPath+"/로 찾아와서 가져오겠다
    }
}
