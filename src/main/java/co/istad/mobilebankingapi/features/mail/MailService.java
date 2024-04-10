package co.istad.mobilebankingapi.features.mail;

import co.istad.mobilebankingapi.features.mail.dto.MailRequest;
import co.istad.mobilebankingapi.features.mail.dto.MailResponse;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

    MailResponse send(MailRequest mailRequest);

}
