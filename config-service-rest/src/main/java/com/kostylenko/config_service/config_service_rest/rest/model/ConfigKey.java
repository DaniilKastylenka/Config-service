package com.kostylenko.config_service.config_service_rest.rest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode
public class ConfigKey {

    @NotBlank
    private String appName;
    @NotBlank
    private String configName;
    @NotBlank
    private String version;

}