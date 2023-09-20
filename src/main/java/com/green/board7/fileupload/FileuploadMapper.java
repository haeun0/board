package com.green.board7.fileupload;

import com.green.board7.fileupload.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileuploadMapper {
   int insFile(FileEntity entity);

   FileEntity selFileById(FileLoadDto dto);

   int delFile(FileDelDto dto);
}
