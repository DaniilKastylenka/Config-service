package com.kostylenko.config_service.config_service_rest.rest.service;

import com.kostylenko.common.common_mapper.domain.mapper.Mapper;
import com.kostylenko.config_service.config_service_rest.domain.service.ParameterService;
import com.kostylenko.config_service.config_service_rest.rest.model.ConfigKey;
import com.kostylenko.config_service.config_service_rest.rest.model.Parameter;
import com.kostylenko.config_service.config_service_rest.rest.model.ParameterKey;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SuppressWarnings("MVCPathVariableInspection")
@RestController
@AllArgsConstructor
@RequestMapping(value = "api/configs/{appName}/{configName}/{version}/parameters",
        consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ParameterController {

    private ParameterService parameterService;
    private Mapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public Parameter createConfigParameter(ConfigKey configKey,
                                           @Valid @RequestBody Parameter parameter) {
        var domainConfigKey = mapper.map(configKey, com.kostylenko.config_service.config_service_rest.domain.model.ConfigKey.class);
        var domainParameter = mapper.map(parameter, com.kostylenko.config_service.config_service_rest.domain.model.Parameter.class);
        var savedParameter = parameterService.createParameter(domainConfigKey, domainParameter);
        return mapper.map(savedParameter, Parameter.class);
    }

    @GetMapping(value = "/{name}")
    public Parameter getConfigParameter(ParameterKey parameterKey) {
        return null;
    }

    @GetMapping
    public List<Parameter> getConfigParameters(ConfigKey configKey) {
        return null;
    }

    @PutMapping(value = "/{name}")
    public Parameter updateConfigParameter(ParameterKey parameterKey,
                            @Valid @RequestBody Parameter parameter) {
        parameter.setParameterKey(parameterKey);
        var parameterToUpdate = mapper.map(parameter, com.kostylenko.config_service.config_service_rest.domain.model.Parameter.class);
        var savedParameter = parameterService.updateParameter(parameterToUpdate);
        return mapper.map(savedParameter, Parameter.class);
    }

    @DeleteMapping(value = "/{name}")
    @ResponseStatus(NO_CONTENT)
    public Parameter deleteConfigParameter(ParameterKey parameterKey) {
        return null;
    }
}