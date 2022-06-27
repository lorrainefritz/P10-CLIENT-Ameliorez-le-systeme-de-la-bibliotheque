package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class BookBean {

    private Integer id;
    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String title;
    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String author;
    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String publisher;
    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String type;
    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String summary;
    @Min(value=0, message="doit ête compris entre 1 et 10")
    @Max(value=10, message="doit ête compris entre 1 et 10")
    @NotNull(message="Ce champ ne doit pas être vide")
    private int numberOfCopiesAvailable;
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String libraryName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date nearestReturnDate;
    @NotNull(message="Ce champ ne doit pas être vide")
    private int numberOfReservation;
    @NotNull(message="Ce champ ne doit pas être vide")
    private int maxReservationListSize;

}
