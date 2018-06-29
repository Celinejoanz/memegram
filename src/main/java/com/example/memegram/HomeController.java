package com.example.memegram;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    MemeRepository memeRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("memes", memeRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String form(Model model){
        model.addAttribute("meme", new Meme());
        return "form";
    }

    @PostMapping("/add")
    public String process(@ModelAttribute Meme meme, @RequestParam("file")MultipartFile file, BindingResult result)
    {
        if (file.isEmpty() || result.hasErrors()){
            return "redirect:/add";
        }
        try{
            Map uploadResult= cloudc.upload(file.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            meme.setImage(uploadResult.get("url").toString());
            memeRepository.save(meme);
        }catch (IOException e){
            e.printStackTrace();
            return"redirect:/add";
        }
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showMeme(@PathVariable("id") long id, Model model){
        model.addAttribute("meme", memeRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateMeme(@PathVariable("id") long id, Model model){
        model.addAttribute("meme", memeRepository.findById(id));
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMeme(@PathVariable("id") long id){
        memeRepository.deleteById(id);
        return "redirect:/";
    }
}
