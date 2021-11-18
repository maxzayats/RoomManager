package net.maks.controller;

import net.maks.model.Room;
import net.maks.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired(required = true)
    @Qualifier(value = "roomService")
    public void setRoomService(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping()
    public String getRooms(Model model) {
        model.addAttribute("rooms", this.roomService.getRooms());
        return "list";
    }

    @GetMapping("/new")
    public String newRoom(@ModelAttribute("room") Room room) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("room") @Valid Room room,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "roooms/new";

        this.roomService.addRoom(room);
        return "redirect:/rooms";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "rooms/edit";

    this.roomService.editRoom(id, room);
        return "redirect:/rooms";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("room", this.roomService.getRoom(id));
        return "edit";
    }
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable("id") int id) {
        this.roomService.deleteRoom(id);
        return "redirect:/rooms";
    }

    @GetMapping("/{id}")
    public String getRoom(@PathVariable("id") int id, Model model) {
        model.addAttribute("room", this.roomService.getRoom(id));
        return "show";
    }
}

