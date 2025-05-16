package com.lahiruliyanage.edupanel.to.request;

import com.lahiruliyanage.edupanel.tuil.LecturerType;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LecturerReqTo implements Serializable {
    @NotBlank(message = "Name Cannot be Empty")
    @Pattern(regexp = "^[A-Za-z ]{2,}$", message = "Invalid name")
    private String name;
    @NotBlank(message = "Designation cannot be empty")
    @Length(min = 3, message = "Invalid designation")
    private String designation;
    @NotBlank(message = "Qualification cannot be blank")
    @Length(min = 3, message = "Invalid qualification")
    private String qualification;
    @NotNull(message = "Type should be either full-time or visiting")
    private LecturerType type; // Because we have created those Enum for this
    @Null(groups = Create.class, message = "Display order should be empty")
    @NotNull(groups = Update.class, message = "Display order cannot be empty")
    @PositiveOrZero(groups = Update.class, message = "Invalid display order")
    private Integer displayOrder;
    private MultipartFile picture;
    @Pattern(regexp = "http(s)://.+$",message = "Invalid linkedin url")
    private String linkedIn;

    public interface Create extends Default {}
    public interface Update extends Default {}
}
