package co.istad.mobilebankingapi.features.cardtype;


import co.istad.mobilebankingapi.features.cardtype.dto.CardTypeResponse;

import java.util.List;

public interface CardTypeService {

    List<CardTypeResponse> findAll();

    CardTypeResponse findByName(String name);

}
