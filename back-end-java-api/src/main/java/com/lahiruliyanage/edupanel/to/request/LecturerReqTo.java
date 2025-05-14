package com.lahiruliyanage.edupanel.to.request;

import com.lahiruliyanage.edupanel.tuil.LecturerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerReqTo implements Serializable {
    private String name;
    private String designation;
    private String qualification;
    private LecturerType type; // Because we have created those Enum for this
    private Integer displayOrder;
    private MultipartFile picture;
    private String linkedIn;
}
