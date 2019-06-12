package com.yuangao.java401d4.songr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//mark this class as a controller, so that springboot knows to look at it
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/capitalize/{input}")
    public String getCap(@PathVariable String input){
        return input.toUpperCase();
    }

    @GetMapping("/reverse")
    public String getReverse(@RequestParam String sentence){
        String[] arr = sentence.split(" " );
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i>=0; --i){
            if (!arr[i].equals("")){
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0,sb.length()-1);
    }
}
