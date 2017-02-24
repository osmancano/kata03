package com.ironyard.controllers;
import com.ironyard.data.Kata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by osmanidris on 2/10/17.
 */
@Controller
public class KataController {
    boolean msg;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/home.jsp";
    }

    @RequestMapping(value = "/kata03/arraylist/{funNum}/", method = RequestMethod.POST)
    public String getArrayListResult(Model myModel, @PathVariable Integer funNum, @RequestParam String arrayList) {
        List<String> myArrayList = new ArrayList<String>(Arrays.asList(arrayList.split("\\s*,\\s*")));
        if(funNum == 1){
            msg = Kata.firstLast6(myArrayList);
            myModel.addAttribute("msg",msg);
        }
        if(funNum == 2){
            msg = Kata.sameFirstLast(myArrayList);
            myModel.addAttribute("msg",msg);
        }
        if(funNum == 3){
            if(myArrayList.size()!=3){
                myModel.addAttribute("msg","Array List must contain 3 items only");
            }else {
                myArrayList = Kata.rotateLeft3(myArrayList);
                myModel.addAttribute("msg",myArrayList.toString());
            }
        }
        if(funNum == 4){
            if(myArrayList.size()!=3){
                myModel.addAttribute("msg","Array List must contain 3 items only");
            }else {
                myArrayList = Kata.reverse3(myArrayList);
                myModel.addAttribute("msg",myArrayList.toString());
            }
        }
        if(funNum == 5){
            Integer sum = Kata.sumFirstPenultimate(myArrayList);
            myModel.addAttribute("msg",sum);
        }
        return "forward:/result.jsp";
    }

    @RequestMapping(value = "/kata03/hashmap/{funNum}/", method = RequestMethod.POST)
    public String getHashMapResult(Model myModel, @PathVariable Integer funNum, @RequestParam String hashMap) {
        int colon = hashMap.indexOf(":");
        HashMap<String, String> myHashMap = new HashMap<>();
        if(funNum < 4) {
            if(colon == -1){
                myModel.addAttribute("msg","invalid Hash Map values");
                return "forward:/result.jsp";
            }
            String[] pairs = hashMap.split(",");
            for (int i = 0; i < pairs.length; i++) {
                myHashMap.put(pairs[i].split(":")[0], pairs[i].split(":")[1]);
            }
            if(funNum == 1) {
                myHashMap = Kata.mapBully(myHashMap);
                myModel.addAttribute("msg", myHashMap.toString());
            }
            if(funNum == 2) {
                myHashMap = Kata.mapShare(myHashMap);
                myModel.addAttribute("msg", myHashMap.toString());
            }
            if(funNum == 3) {
                myHashMap = Kata.mapAB(myHashMap);
                myModel.addAttribute("msg", myHashMap.toString());
            }
        }else{
            List<String> myArrayList = new ArrayList<String>(Arrays.asList(hashMap.split("\\s*,\\s*")));
            if(funNum == 4){
                HashMap<String, Integer> hm = new HashMap<>();
                hm = Kata.wordLength(myArrayList);
                myModel.addAttribute("msg", hm.toString());
            }
            if(funNum == 5){
                HashMap<String, ArrayList<String>> hm = new HashMap<>();
                hm = Kata.indexWords(myArrayList);
                myModel.addAttribute("msg", hm.toString());
            }
        }
        return "forward:/result.jsp";
    }

}
