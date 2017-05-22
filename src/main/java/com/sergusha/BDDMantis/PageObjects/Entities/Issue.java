package com.sergusha.BDDMantis.PageObjects.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sergusha on 16.04.17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Issue {
    String category;

    String reproducibility;

    String severity;

    String priority;

    String handler;

    String summary;

    String description;

    String steps_to_reproduce;

    String additional_info;

    String submitBtn;

    String platform;

    String os;

    String osVersion;
}
