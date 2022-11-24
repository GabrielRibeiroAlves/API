package apicarros.API.service;

import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.print.StreamPrintService;
import java.util.concurrent.ExecutionException;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("&{spring.mail.username}")

    private String remetente;

    public String enviarEmailTexto(String destinatario, String titulo, String mensagem)
    {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("apispringboot4@gmail.com");
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(titulo);
            simpleMailMessage.setText(mensagem);
            javaMailSender.send(simpleMailMessage);
            return "Email enviado!";
        }
        catch (Exception ex)
        {
            return "Erro ao enviar o email";
        }
    }
}

