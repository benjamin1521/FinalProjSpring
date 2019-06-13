package ua.training.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.training.entities.enums.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Builder
@Entity(name = "REPORT")
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "reportsId")
    private List<Mod> mods;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private User clientId;

    @ManyToOne
    @JoinColumn(name = "inspectorId")
    private User inspectorId;

    //Next is json data
    public Report(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private String code;
    private String name;
    private String name_short;
    private String address;
    private String phone;
    private String payment_name;
    private String oktmo;
    private String inn;
    private String kpp;
    private String bank_name;
    private String bank_bic;
    private String bank_account;
    private String parent_code;
    private String parent_name;
    private String parent_address;
    private String parent_phone;

}
