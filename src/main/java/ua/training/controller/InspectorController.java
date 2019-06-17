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
import ua.training.entities.Report;
import ua.training.entities.User;
import ua.training.entities.enums.Action;
import ua.training.service.ReportService;

@Controller
@RequestMapping("/inspector")
public class InspectorController {
    @Autowired
    ReportService reportService;

    @PreAuthorize("#user.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/{user}")
    public String clientReports(
            @PathVariable User user,
            @RequestParam(required = false) Report report,
            Model model
    ) {

        model.addAttribute("reports", user.getInspectorReports());
        model.addAttribute("report", report);


        return "inspector/reportList";
    }

    @PreAuthorize("#report.inspectorId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/view/{report}")
    public String reportDetails(
            @PathVariable Report report,
            Model model
    ) {
        model.addAttribute("report", report);

        return "inspector/reportDetails";
    }

    @PreAuthorize("#report.inspectorId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/mods/{report}")
    public String reportMods(
            @PathVariable Report report,
            Model model
    ) {

        model.addAttribute("mods", report.getMods());

        return "client/reportMods";
    }

    @PreAuthorize("#report.inspectorId.username==principal.username || hasAuthority('Admin')")
    @PostMapping("/mods/{report}")
    public String addMod(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report,
            @RequestParam String comment
    ) {

        reportService.addMod(currentUser, report, comment, Action.Commented);

        return "redirect:/inspector/mods/" + report.getId();
    }

    @PreAuthorize("#report.inspectorId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/approve/{report}")
    public String approve(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report,
            @RequestParam(required = false) String comment
    ) {
        if (currentUser.equals(report.getInspectorId())) {
            reportService.approveReport(report);
            reportService.addMod(currentUser, report, comment, Action.Approved);
        }

        return "redirect:/inspector/" + currentUser.getId();
    }

    @PreAuthorize("#report.inspectorId.username==principal.username || hasAuthority('Admin')")
    @GetMapping("/reject/{report}")
    public String reject(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Report report,
            @RequestParam(required = false) String comment
    ) {
        if (currentUser.equals(report.getInspectorId())) {
            reportService.rejectReport(report);
            reportService.addMod(currentUser, report, comment, Action.Rejected);
        }
        return "redirect:/inspector/" + currentUser.getId();
    }

}
