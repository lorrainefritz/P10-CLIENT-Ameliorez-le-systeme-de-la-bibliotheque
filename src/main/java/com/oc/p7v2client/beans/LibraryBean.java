package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class LibraryBean {

    private Integer id;


    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String name;


    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String address;


    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String email;


    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String phone;


    @Size(max=65, message="65 charactères maximum")
    @NotBlank(message="Ce champ ne doit pas être vide")
    private String openingTime;

}
