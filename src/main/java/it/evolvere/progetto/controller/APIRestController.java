package it.evolvere.progetto.controller;

import it.evolvere.progetto.model.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIRestController {
    final static Logger logger = LoggerFactory.getLogger(APIRestController.class);


    @GetMapping("/main")
    @ResponseBody
    public UserDto main(){
        logger.info("calling main");

        return new UserDto();
    }


    @GetMapping("/sample")
    @ResponseBody
    public UserDto sample(@RequestParam(value = "start", required = true) String startDate,
                        @RequestParam(value = "end", required = true) String endDate,
                        @RequestParam() String tagName){
        logger.info("sample");

        long start = Long.parseLong(startDate.replace("-", "")+"0000");
        long end = Long.parseLong(endDate.replace("-", "")+"2359");


        return new UserDto();
    }
}
