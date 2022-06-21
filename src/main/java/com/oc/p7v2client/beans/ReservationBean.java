package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class ReservationBean {

    private Integer id;

    private Date startDate;
    private Date endDate;
    private int reservationPosition;

    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String username;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String lastName;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String firstName;
    private int bookId;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String bookTitle;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String bookAuthor;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String libraryName;
    @Size(max = 65, message = "65 charactères maximum")
    @NotBlank(message = "Ce champ ne doit pas être vide")
    private String openingTime;
}
