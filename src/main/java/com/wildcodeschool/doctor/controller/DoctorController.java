package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {
    /*@GetMapping("/doctor/{number}")
    @ResponseBody
    public String doctor(@PathVariable int number) {

        return "doctor" + number;
    }*/

    /*@GetMapping("/doctor/13")
    @ResponseBody
    public Doctor doctor13() {
        return new Doctor(13,"Jodie Whittaker");
    }*/

    @GetMapping("/doctor/{number}")
    @ResponseBody
    Doctor getDoctor(@PathVariable int number){
        if (number >0 && number < 13){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "ERROR 303");
        }else if (number == 13) {
            return new Doctor(13,"Jodie Whittaker");
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ERROR 404, Impossible de récuperer l'incarnation");
        }
    }
}
