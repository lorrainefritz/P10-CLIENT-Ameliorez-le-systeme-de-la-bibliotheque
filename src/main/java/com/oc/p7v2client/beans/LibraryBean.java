package com.oc.p7v2client.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class LibraryBean {

    private Integer id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String openingTime;

  /*  private List<BookBean>books;*/
}
