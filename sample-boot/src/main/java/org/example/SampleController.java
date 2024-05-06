package org.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping
    public String getRequest() {
        return "This is a GET request";
    }

    @GetMapping("/id")
    public String getWithParam() {
        return "This is a GET request with extends uri";
    }

    @PostMapping
    public String postRequest() {
        return "This is a POST request";
    }
    @PutMapping
    public String putRequest() {
        return "This is a PUT request";
    }
    @DeleteMapping
    public String deleteRequest() {
        return "This is a DELETE request";
    }
}
