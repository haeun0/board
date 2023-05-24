package com.green.board7.fileupload;

import com.green.board7.fileupload.model.FileEntity;
import com.green.board7.fileupload.model.FileuploadInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileuploadService {


    private final FileuploadMapper mapper;
    @Autowired
    public FileuploadService(FileuploadMapper mapper) {
        this.mapper = mapper;
    }

    @Value("${file.dir}")//Value 사용하면 yaml 파일안의 file.dir 의 값을 불러올수있다
    private String fileDir;
    public void fileUpload(FileuploadInsDto dto,MultipartFile img){
        System.out.println("fileDir :" +fileDir);
        //원래 파일 이름 추출
        String originFileName =img.getOriginalFilename();//확장자를 알기위해 오리지날 이름 추출

        //파일이름으로 사용할 uuid 생성 uuid란?네트워크상에서 고유성을 보장하는 id를 만들기위한 표준규약
        String uuid= UUID.randomUUID().toString();
        // substring 을 이용하여 해당 파일의 확장자명 알아낼수있다
        String ext= originFileName.substring(originFileName.lastIndexOf("."));

        String savedFildName= uuid+ext;
        String savedFilePath= fileDir+savedFildName; //파일 경로 찍어준다

        File file= new File(savedFilePath);
        try {
            img.transferTo(file);
            FileEntity entity = FileEntity.builder()//Builder을 사용
                    .path(savedFilePath)
                    .uploader(dto.getUploader())
                    .levelValue(dto.getLevelValue())
                    .build();

            mapper.insFile(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
