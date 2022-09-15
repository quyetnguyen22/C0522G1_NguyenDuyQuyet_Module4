package com.music.controller;

import com.music.model.Music;
import com.music.service.IMusicServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicServer musicServer;

    @GetMapping("/music")
    public String musicList(Model model) {
        model.addAttribute("musicList", musicServer.musicList());
        return "list";
    }

    @GetMapping("/formAdd")
    public String formAdd(Model model) {
        model.addAttribute("music", new Music());
        return "add";
    }

    @GetMapping("/saveSong")
    public String saveSong(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        musicServer.addNewSong(music);
        redirectAttributes.addFlashAttribute("msgAdd", "Add " + music.getSongName() + " successfully!");
        return "redirect:/formAdd";
    }

    @GetMapping("/formEdit/{id}")
    public String formEdit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicServer.songId(id));
        return "edit";
    }

    @GetMapping("/saveEdit")
    public String saveEdit(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        musicServer.editMusic(music);
        redirectAttributes.addFlashAttribute("msgEdit", "Edited " + music.getSongName() + " successfully");
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Music music = musicServer.songId(id);
        redirectAttributes.addFlashAttribute("msgDelete", "Deleted " + music.getSongName() + "successfully");
        musicServer.deleteMusic(id);

        return "redirect:/music";
    }
}
