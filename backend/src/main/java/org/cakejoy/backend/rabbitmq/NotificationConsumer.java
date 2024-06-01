package org.cakejoy.backend.rabbitmq;

import org.cakejoy.backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationConsumer {
    @Value("${app.url}")
    private String appUrl;

    private final EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void receiveNotification(String message) {
        System.out.println("Received notification: " + message);

        String[] parts = message.split(", ");
        Integer orderId = Integer.valueOf(parts[0].split(": ")[1]);
        String state = parts[1].split(": ")[1];
        String userEmail = parts[2].split(": ")[1];

        String subject = String.format("Status zamówienia nr %d został zmieniony", orderId);
        String body = String.format(
                "<div style=\"font-family: Arial, sans-serif; color: #333;\">"
                        + "<h2 style=\"color: #da70d6; \">Twoje zamówienie nr %d zmieniło status na: %s</h2>"
                        + "<p>Drogi Kliencie,</p>"
                        + "<p>Z przyjemnością informujemy, że status Twojego zamówienia został zaktualizowany.</p>"
                        + "<p><strong>Nowy status zamówienia:</strong> %s</p>"
                        + "<p>Aby zobaczyć więcej szczegółów, kliknij w poniższy link:</p>"
                        + "<p><a href=\"%s/order/%d\" style=\"color: #1E90FF;\">Zobacz szczegóły zamówienia</a></p>"
                        + "<br>"
                        + "<p>Dziękujemy za zakupy w CakeJoy!</p>"
                        + "<p>Pozdrawiamy,<br>Zespół CakeJoy</p>"
                        + "<hr>"
                        + "<p style=\"font-size: 12px; color: #777;\">Jeśli masz jakiekolwiek pytania, skontaktuj się z nami pod adresem k.furmanek10@gmail.com</p>"
                        + "</div>",
                orderId, state, state, appUrl, orderId
        );

        emailService.sendSimpleMessage(userEmail, subject, body);
    }
}
