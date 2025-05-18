package com.lahiruliyanage.edupanel.api;

import com.lahiruliyanage.edupanel.entity.Lecturer;
import com.lahiruliyanage.edupanel.entity.LinkedIn;
import com.lahiruliyanage.edupanel.entity.Picture;
import com.lahiruliyanage.edupanel.to.request.LecturerReqTo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api/v1/lecturers")
@CrossOrigin
public class LecturerHttpController {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public void createNewLecturer(@ModelAttribute @Validated(LecturerReqTo.Create.class) LecturerReqTo lecturerReqTo) {
        entityManager.getTransaction().begin();
        try {
            // We can use Model Mapper for this, From using ModelMapper, we can use intelligent Mapping
            Lecturer lecturer = modelMapper.map(lecturerReqTo, Lecturer.class);
            lecturer.setPicture(null);
            lecturer.setLinkedIn(null);

            System.out.println(lecturer);

            entityManager.persist(lecturer);

            if (lecturerReqTo.getLinkedIn() != null) {
                entityManager.persist(new LinkedIn(lecturer, lecturerReqTo.getLinkedIn()));
            }

            if (lecturerReqTo.getPicture() != null) {
                entityManager.persist(new Picture(lecturer, "lecturers/" + lecturer.getId()));
            }

            entityManager.getTransaction().commit();
        } catch (Throwable throwable) {
            entityManager.getTransaction().rollback();
            throw throwable;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}", consumes = "multipart/form-data")
    public void updateLecturerDetailsViaMultipart(@PathVariable("lecturer-id") Integer lecturerId) {}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{lecturer-id}", consumes = "application/json")
    public void updateLecturerDetailsViaJson(@PathVariable("lecturer-id") Integer lecturerId) {}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{lecturer-id}")
    public void deleteLecturer(@PathVariable("lecturer-id") Integer lecturerId) {}

    @GetMapping(produces = "application/json")
    public void getAllLecturers() {}

    @GetMapping(value = "/{lecturer-id}", produces = "application/json")
    public void getLecturerDetails(@PathVariable("lecturer-id") Integer lecturerId) {}

    @GetMapping(params = "type=full-time", produces = "application/json")
    public void getFullTimeLecturers() {}

    @GetMapping(params = "type=visiting", produces = "application/json")
    public void getVisitingLecturers() {}
}
