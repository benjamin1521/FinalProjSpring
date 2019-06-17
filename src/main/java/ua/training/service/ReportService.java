package ua.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.entities.Mod;
import ua.training.entities.Report;
import ua.training.entities.User;
import ua.training.entities.enums.Action;
import ua.training.entities.enums.Role;
import ua.training.entities.enums.Status;
import ua.training.repos.ModRepo;
import ua.training.repos.ReportRepo;
import ua.training.repos.UserRepo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ReportService {
    @Autowired
    private ReportRepo reportRepo;

    @Autowired
    private ModRepo modRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Report> findAll() {
        return reportRepo.findAll();
    }

    private User randomOne(List<User> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    @Transactional
    public Report addReport(User user, String name, String comment) {

        Report report = Report.builder()
                .status(Status.Active)
                .name(name)
                .clientId(user)
                .inspectorId(randomOne(userRepo.findByRole(Role.Inspector)))
                .build();

        reportRepo.save(report);

        addMod(user, report, comment, Action.Created);
        return report;
    }

    public void updateReport(User user, Report report, Map<String, String> form) {
        report.setStatus(Status.Active);
        report.setName(form.get("name"));
        report.setAddress(form.get("address"));
        report.setBank_account(form.get("bank_account"));
        report.setBank_bic(form.get("bank_bic"));
        report.setBank_account(form.get("bank_account"));
        report.setBank_name(form.get("bank_name"));
        report.setCode(form.get("code"));
        report.setInn(form.get("inn"));
        report.setKpp(form.get("kpp"));
        report.setName_short(form.get("name_short"));
        report.setOktmo(form.get("oktmo"));
        report.setParent_address(form.get("parent_address"));
        report.setParent_code(form.get("parent_code"));
        report.setParent_name(form.get("parent_name"));
        report.setParent_phone(form.get("parent_phone"));
        report.setPayment_name(form.get("payment_name"));
        report.setPhone(form.get("phone"));

        addMod(user, report, form.get("comment"), Action.Updated);
    }

    @Transactional
    public void deleteReport(Report report) {
        modRepo.deleteAllByReportsId(report);
        reportRepo.delete(report);
    }

    public void addMod(User user, Report report, String comment, Action action) {
        modRepo.save(Mod.builder()
                .action(action)
                .comment(comment)
                .date(new Date())
                .reportsId(report)
                .userId(user)
                .build());
    }

    public void approveReport(Report report) {
        report.setStatus(Status.Approved);
        reportRepo.save(report);
    }

    public void rejectReport(Report report) {
        report.setStatus(Status.Rejected);
        reportRepo.save(report);
    }

    public void changeInspector(Report report) {
        report.setInspectorId(randomOne(userRepo.findByRoleAndInspectorReportsNotContaining(Role.Inspector, report)));
        reportRepo.save(report);
    }
}
