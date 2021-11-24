package com.msyq.psetshop.controller.module;

import com.msyq.psetshop.service.MakeService;
import com.msyq.psetshop.service.MedicalService;
import com.msyq.psetshop.service.PhotosService;
import com.msyq.psetshop.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{fkId}/Individual")
public class IndividualController {

    @Autowired
    private MakeService makeService;

    @Autowired
    private MedicalService medicalService;

    @Autowired
    private PostService postService;

    @Autowired
    private PhotosService photosService;



}
