package com.mftplus.lettertest.model.entity;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;
import com.mftplus.lettertest.model.entity.enums.Classification;

import com.mftplus.lettertest.model.utils.GeneratedSequence;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity (name = "letterEntity")
@Table (name = "letter_tbl")
@Indexed

@NamedQueries({
        @NamedQuery(name = "Letter.FindByTitle",query = "select oo from letterEntity oo where oo.title=:title"),
        @NamedQuery(name = "Letter.FindByContext",query = "select oo from letterEntity oo where oo.context=:context")
})
public class Letter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "l_Id")
    private long id;

    @Column (name = "l_title")
    private String title;

    @OneToOne
    private GeneratedSequence myVal;

    @Column (name = "l_letter_number" , length = 30 , unique = true)
    private String letterNumber;

    //needs to be in persian
    @Column (name = "l_date")
    private LocalDate date;

    @Column (name = "l_subject", length = 25)
    private String subject;

    @Column (name = "l_context")
    //for search
    @Field(termVector = TermVector.YES)
    private String context;

    //how to get this num?
    @Column (name = "l_register", length = 20)
    private String registerNumber;

    @Column (name = "l_register_date_and_time")
    private LocalDateTime registerDateAndTime;

    //what is indicator code?
    @Transient
    @Column (name = "l_indicator_code", length = 20)
    private String indicatorCode;

    @Column (name = "l_receiver_name" , length = 25)
    private String receiverName;

    @Column (name = "l_receiver_title" , length = 25)
    private String receiverTitle;

    @Column (name = "l_sender_name" , length = 25)
    private String senderName;

    @Column (name = "l_sender_title", length = 25)
    private String senderTitle;

    @Column (name = "l_image")
    private String image;

    @Enumerated (EnumType.ORDINAL)
    private Classification classification;

    @ManyToMany
    private List<User> carbonCopies;

    @ManyToOne
    private User userId;

    @ManyToOne
    private TransferMethod transferMethod;

    //what is this?
    @Column (name = "l_natural_or_legal")
    private Boolean naturalOrLegal;

    public void letterNumberGenerator(String myVal){
        ULocale locale = new ULocale("fa_IR@calendar=persian");
        Calendar calendar = Calendar.getInstance(locale.toLocale());
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        letterNumber = (String) year + (String) myVal;
        System.out.println("letter number : " + letterNumber);
    }









}
