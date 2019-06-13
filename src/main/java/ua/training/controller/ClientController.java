package ua.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.training.entities.Mod;
import ua.training.entities.Report;
import ua.training.entities.User;
import ua.training.entities.enums.Action;
import ua.training.service.ReportService;

import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ClientController {
    @Autowired
    ReportService reportService;

    @PreAuthorize("#user.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/{user}")
    public String userReports(
            @PathVariable User user,
            @RequestParam(required = false) Report report,
            Model model
    ) {
        model.addAttribute("reports", user.getClientReports());
        model.addAttribute("report", report);

        return "client/reportList";
    }

    @PreAuthorize("#user.username==principal.username || hasAuthority('Admin')")
    @PostMapping("/{user}")
    public String addReport(
            @PathVariable User user,
            @RequestParam String name,
            @RequestParam String comment
    ) {
        Report report = reportService.addReport(user, name, comment);

        return "redirect:/reports/edit/" + report.getId();
    }

    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/edit/{report}")
    public String editReport(
            @PathVariable Report report,
            Model model
    ) {

        model.addAttribute("report", report);

        return "client/reportEdit";
    }

    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @PostMapping("/edit/{report}")
    public String updateReport(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report,
            @RequestParam Map<String, String> form
    ) {

        reportService.updateReport(currentUser, report, form);

        return "redirect:/reports/" + currentUser.getId();
    }

    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/delete/{report}")
    public String deleteReport(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report
    ) {
        reportService.deleteReport(report);

        return "redirect:/reports/" + currentUser.getId();
    }

    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/mods/{report}")
    public String reportMods(
            @PathVariable Report report,
            @RequestParam(required = false) Mod mod,
            Model model
    ) {

        model.addAttribute("mods", report.getMods());
        model.addAttribute("mod", mod);

        return "client/reportMods";
    }


    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @PostMapping("/mods/{report}")
    public String addMod(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report,
            @RequestParam String comment
    ) {

        reportService.addMod(currentUser, report, comment, Action.Commented);

        return "redirect:/reports/mods/" + report.getId();
    }

    @PreAuthorize("#report.clientId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/change/{report}")
    public String changeInspector(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report
    ) {

        reportService.changeInspector(report);

        return "redirect:/reports/" + currentUser.getId();
    }
}

////TODO: Filter
//
//    @GetMapping
//    public String main(
//            @RequestParam(required = false, defaultValue = "") String filter,
//            Model model
//    ) {
//        List<Report> reports;

//        if (filter != null && !filter.isEmpty()) {
//            reports = reportRepo.(filter);
//        } else {
//            reports = reportRepo.findAll();
//        }
//
//        reports = reportRepo.findAllByClientId();
//        model.addAttribute("reports", reports);
//        model.addAttribute("filter", filter);
//
//        return "client/reportList";
//    }