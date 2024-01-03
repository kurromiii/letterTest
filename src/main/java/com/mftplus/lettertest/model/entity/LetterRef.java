package com.mftplus.lettertest.model.entity;

import com.mftplus.lettertest.model.entity.enums.RefType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "letterRefEntity")
@Table(name = "letter_ref_tbl")

@NamedQueries({
        @NamedQuery(name = "LetterRef.FindByLetter",query = "select oo from letterRefEntity  oo where oo.letterId=:letterId")
})
public class LetterRef implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "r_Id")
    private long id;

    @ManyToOne
    private Letter letterId;

    @Enumerated (EnumType.ORDINAL)
    private RefType refType;

    @ManyToOne
    private User refSender;

    @ManyToOne
    private User refReceiver;

    @Column (name = "r_date_and_time")
    private LocalDateTime refDateAndTime;

    @Column (name = "r_expiration")
    private LocalDateTime expiration;

    @Column (name = "r_paraph" , length = 50)
    private String paraph;

    @Column (name = "r_comment" , length = 50)
    private String comment;
}
