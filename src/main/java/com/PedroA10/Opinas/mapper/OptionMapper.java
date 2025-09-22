package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.option.OptionRequestDTO;
import com.PedroA10.Opinas.dto.option.OptionResponseDTO;
import com.PedroA10.Opinas.model.Option;

public class OptionMapper {

    public static Option toModel(OptionRequestDTO dto) {
        Option option = new Option();
        option.setText(dto.getText());
        return option;
    }

    public static OptionResponseDTO toDTO(Option option) {
        return new OptionResponseDTO(option.getId(), option.getText());
    }
}