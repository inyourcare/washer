package com.kkh.app.controller.view;

import com.kkh.app.jpa.entity.WasherEntity;
import com.kkh.app.jpa.repository.StoreRepository;
import com.kkh.app.jpa.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private WasherRepository washerRepository;

    @RequestMapping(path = "/index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String index(Model model) {
        model.addAttribute("stores", storeRepository.findAll());
        model.addAttribute("washers", washerRepository.findAll());
        return "index";
    }

    @MessageMapping("/refresh")
    @SendTo("/sock/subscribe")
    public List<WasherEntity> greeting() throws Exception {
        Thread.sleep(1000); // simulated delay
        return washerRepository.findAll();
    }
}
