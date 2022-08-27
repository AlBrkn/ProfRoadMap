package ru.fiyf.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fiyf.dto.GeneralApplicationDto;
import ru.fiyf.service.GeneralApplicationService;

import java.util.List;

/**
 * GeneralApplicationController.
 *
 * @author Aleksey_Brekhin
 * @since 8/18/21
 */
@Slf4j
@RestController
public class GeneralApplicationController {

    private final GeneralApplicationService generalApplicationService;

    public GeneralApplicationController(GeneralApplicationService generalApplicationService) {
        this.generalApplicationService = generalApplicationService;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneralApplicationDto> createApplication(@RequestBody GeneralApplicationDto dto) {
        GeneralApplicationDto generalApplicationDto = generalApplicationService.create(dto);
        return new ResponseEntity<>(generalApplicationDto, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeneralApplicationDto>> getAllApplication(){
        List<GeneralApplicationDto> all = generalApplicationService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}