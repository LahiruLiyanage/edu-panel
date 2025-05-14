package com.lahiruliyanage.edupanel.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lecturers")
@CrossOrigin
public class LecturerHttpController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public void createNewLecturer() {}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{lecturer-id}")
    public void updateLecturer(@PathVariable("lecturer-id") Integer lecturerId) {}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{lecturer-id}")
    public void deleteLecturer(@PathVariable("lecturer-id") Integer lecturerId) {}

    @GetMapping
    public void getAllLecturers() {}

    @GetMapping("/{lecturer-id}")
    public void getLecturerDetails(@PathVariable("lecturer-id") Integer lecturerId) {}

    @GetMapping(params = "type=full-time")
    public void getFullTimeLecturers() {}

    @GetMapping(params = "type=visiting")
    public void getVisitingLecturers() {}
}
