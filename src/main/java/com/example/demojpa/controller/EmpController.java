package com.example.demojpa.controller;

import com.example.demojpa.entity.Emp;
import com.example.demojpa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/saveemp")
    public Boolean save(@RequestBody Emp emp) {
        return empService.add(emp);

    }
    @GetMapping("/getall")
    public Iterable<Emp>findall(){
        return empService.getall();
    }
    @GetMapping("/getEmpByName")
    public List<Emp> findEmpByName(@RequestParam String name){
        return empService.getEmpByName(name);
    }
    @GetMapping("/getSalary")
    public List <Emp> getSalary(@RequestParam Double salary){
        return empService.getSalaryGreaterThan(salary);
    }
    @GetMapping("/getsalaryfromparms/{salary}")
    public List <Emp> getSalaryFromParms(@PathVariable Double salary){
        return empService.getSalaryGreaterThan(salary);
    }
}
/* server.port =8083when 8080 is occupied we can use it */