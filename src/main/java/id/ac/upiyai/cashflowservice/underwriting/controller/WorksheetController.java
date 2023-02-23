package id.ac.upiyai.cashflowservice.underwriting.controller;

import id.ac.upiyai.cashflowservice.underwriting.service.WorksheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worksheets")
@RequiredArgsConstructor
public class WorksheetController {

    private final WorksheetService service;
}
