package com.mires.klubypilkarskie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mires.klubypilkarskie.KlubyPilkarskieApplication;
import com.mires.klubypilkarskie.helpers.HtmlHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/football", method = RequestMethod.GET)
public class SiteController {

    @CrossOrigin
    @RequestMapping(path = "jsonList", method = RequestMethod.GET, produces = "application/json")
    public String listClubs() throws IOException {
        Object json = new ObjectMapper().readValue(KlubyPilkarskieApplication.getMysqlManager().getClubs(), Object.class);
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }

    @CrossOrigin
    @RequestMapping(path = "htmlTable", method = RequestMethod.GET, produces = "text/html")
    public String htmlTable() {
        return HtmlHelper.getHtmltable();
    }
}
