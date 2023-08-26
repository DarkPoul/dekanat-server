package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.accounting_for_success_DTO;
import com.esvarog.dekanat.fileGen.accounting_for_success;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLConnection;

@RestController
@RequestMapping("/download")
public class FileDownloadController {

    private static final String FILE_PATH = "C:/fileDownload/";
    @RequestMapping("/{fileName:.+}")
    public void download_accounting_for_success(HttpServletResponse response,
                                                @PathVariable("fileName") String fileName, @RequestBody accounting_for_success_DTO dto) throws IOException{

//        System.out.println(dto.getNumber_of_semester());
        System.out.println(dto.getFaculty());
        System.out.println(dto.getSpeciality());
        System.out.println(dto.getEducational_program());

        accounting_for_success.pdfGen(dto.getFaculty(), dto.getSpeciality(),
                dto.getEducational_program(), dto.getNumber_of_course(), dto.getGroup_abr(), dto.getNumber_of_order(), dto.getDate(),
                dto.getMonth(), dto.getTitle_od_disc(), dto.getNumber_of_semester(), dto.getType_of_control(), dto.getHours(), dto.getFirst_teach(), dto.isFirst_exam_teach(),
                dto.getSecond_teach(), dto.isSecond_exam_teach(), dto.getDean_name());
        File file = new File(FILE_PATH + fileName);
        System.out.println(file);
        if (file.exists()){
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null){
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }


}
