package co.istad.mobilebankingapi.features.cardtype;

import co.istad.mobilebankingapi.domain.CardType;
import co.istad.mobilebankingapi.features.cardtype.dto.CardTypeResponse;
import co.istad.mobilebankingapi.mapper.CardTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardTypeServiceImpl implements CardTypeService{

    private final CardTypeRepository cardTypeRepository;
    private final CardTypeMapper cardTypeMapper;


    @Override
    public List<CardTypeResponse> findAll() {

        List<CardType> cardTypes = cardTypeRepository.findAll();

        return cardTypeMapper.toListCardTypeResponse(cardTypes);
    }

    @Override
    public CardTypeResponse findByName(String name) {

        CardType cardType = cardTypeRepository.findByNameIgnoreCase(name)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "CardType does not exist!"
                ));

        return cardTypeMapper.toCardTypeResponse(cardType);
    }
}
