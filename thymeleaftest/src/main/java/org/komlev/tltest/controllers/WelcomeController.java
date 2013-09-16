package org.komlev.tltest.controllers;

import org.komlev.tltest.to.TestData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author <a href="mailto:AlexKomlev@rambler.ru">Aleksey Komlev</a>
 * @version 13.09.13
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = {"/", "/start"}, method = RequestMethod.GET)
    public String hello(final ModelMap model){
        List<TestData> testInfos= new ArrayList<TestData>(2);
        TestData testData = new TestData("Hello", "Delta1");
        TestData testData2 = new TestData("Yello", "Delta2");
        testInfos.add(testData);
        testInfos.add(testData2);

        model.addAttribute(testInfos);
        return "welcome";
    }
}
