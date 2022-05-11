package com.temp.controller;

import com.temp.model.Temp;
import com.temp.repositories.Temprepository;
import com.temp.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.MultiDoc;
import java.util.List;


//@CrossOrigin
@RestController
@RequestMapping("api/v1/temp")
//@ResponseBody

public class TempController {
    private final TempService tempservice;
    public Temprepository temprepository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("temps", tempservice.getTemps());
        return "index";
    }
    @GetMapping("/pass")
    public String home(){
        return "index";
    }

//   @RequestMapping(value = "temps", method = RequestMethod.GET)
//    public String temps(Model model) {
//       model.addAttribute("temps", temprepository.findAll());
//       return "temps/list";
//   }
//
//   @RequestMapping(value = "temps", method = RequestMethod.GET)
//   public ModelAndView temps(){
//       ModelAndView mav = new ModelAndView("tempview");
//       mav.addObject("temps", temprepository);
//       return mav;
//   }
//   @ModelAttribute("temps")
//    public List<Temp> temps() {
//       return (List<Temp>) temprepository.findAll();
//   }

    @Autowired
    public TempController(TempService tempservice) {
        this.tempservice = tempservice;
    }

    @GetMapping
    public ResponseEntity<List<Temp>> getAllTemps() {
        return new ResponseEntity<>(tempservice.getTemps(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Temp> saveTemp(@RequestBody Temp temp){
        Temp newTemp = tempservice.insertTemp(temp);
        HttpHeaders httpheaders = new HttpHeaders();
        httpheaders.add("temp", "api/v1/temp"+newTemp.getId().toString());

        return new ResponseEntity<>(newTemp,httpheaders,HttpStatus.CREATED);
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Temp> deleteTemp(@PathVariable Long id){
//        Temp tempFromDB = tempservice.getTempById(id);
//        if(tempFromDB != null) {
//            tempservice.deleteTemp(id);
//        }
//        return tempFromDB != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


}
