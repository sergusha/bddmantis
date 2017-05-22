package com.sergusha.BDDMantis.PageObjects.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by sergusha on 11.04.17.
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    String login;
    String password;
}
