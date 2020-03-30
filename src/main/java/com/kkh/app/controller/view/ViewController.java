package com.kkh.app.controller.view;

import com.kkh.app.jpa.repository.StoreRepository;
import com.kkh.app.jpa.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private WasherRepository washerRepository;

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        model.addAttribute("washers", washerRepository.findAll());
        return "hello";
    }
}
