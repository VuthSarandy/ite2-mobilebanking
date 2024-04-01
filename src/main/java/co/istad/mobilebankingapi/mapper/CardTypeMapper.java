package co.istad.mobilebankingapi.mapper;

import co.istad.mobilebankingapi.domain.CardType;
import co.istad.mobilebankingapi.features.cardtype.dto.CardTypeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardTypeMapper {

    CardType fromCardTypeResponse(CardTypeResponse cardTypeResponse);

    CardTypeResponse toCardTypeResponse(CardType cardType);

    List<CardTypeResponse> toListCardTypeResponse(List<CardType> cardTypes);

}
