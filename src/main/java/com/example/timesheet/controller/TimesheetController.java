package com.example.timesheet.controller;

import com.example.timesheet.model.Timesheet;
import com.example.timesheet.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
public class TimesheetController {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @GetMapping("/timesheets")
    public String listTimesheets(Model model) {
        List<Timesheet> timesheets = timesheetRepository.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheetList";
    }

    @GetMapping("/timesheets/new")
    public String showTimesheetForm(Model model) {
        Timesheet timesheet = new Timesheet();
        model.addAttribute("timesheet", timesheet);
        return "timesheetForm";
    }

    @PostMapping("/timesheets")
    public String saveTimesheet(@ModelAttribute Timesheet timesheet) {
        timesheet.setDate(LocalDate.now()); // Set current date
        timesheetRepository.save(timesheet);
        return "redirect:/timesheets";
    }

    @GetMapping("/timesheets/edit/{id}")
    public String editTimesheet(@PathVariable("id") Long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid timesheet ID"));
        model.addAttribute("timesheet", timesheet);
        return "timesheetForm";
    }

    @PostMapping("/timesheets/update/{id}")
    public String updateTimesheet(@PathVariable("id") Long id, @ModelAttribute Timesheet timesheet) {
        timesheet.setId(id);
        timesheetRepository.save(timesheet);
        return "redirect:/timesheets";
    }

    @GetMapping("/timesheets/delete/{id}")
    public String deleteTimesheet(@PathVariable("id") Long id) {
        Timesheet timesheet = timesheetRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid timesheet ID"));
        timesheetRepository.delete(timesheet);
        return "redirect:/timesheets";
    }
}
