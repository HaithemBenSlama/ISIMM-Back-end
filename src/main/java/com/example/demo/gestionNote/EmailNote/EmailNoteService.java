package com.example.demo.gestionNote.EmailNote;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNoteService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendHtmlEmailForDS(String toEmail,Float note,String nomMatiere,String nomEtudiant,String prenomEtudiant) throws MessagingException
    {
        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject("Nouvelle Note");

        String htmlContent = "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#70bbd9;\">\n" +
                "              <img src='https://i.postimg.cc/0Mm51C0c/score.png' height=\"100\" width=\"100\" alt='score'/>\n" +
                "              <h2 style=\"font-size:24px;margin:2 0 20px 0;font-family:Arial,sans-serif; color: #153643;\">Nouvelle Note</h1>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 10px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 15px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Nouvelle note ajouté</h1>\n" +
                "                    <div  style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">\n" +
                "                      <p>Cher/Chère "+nomEtudiant+" "+ prenomEtudiant+", </p>\n" +
                "                      <p>Nous espérons que ce courriel vous trouve bien et que vous progressez dans vos études avec succès.</p>\n" +
                "                      <p>\n" +
                "                        Nous sommes heureux de vous informer qu'une nouvelle note a été ajoutée à votre dossier académique pour le cours <b>"+nomMatiere+"</b>\n" +
                "                      </p>\n" +
                "                      <table style=\"width:100%; border-color: black; border-style: solid;\" border=\"2px\" >\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">"+nomMatiere+"</td>\n" +
                "                          <td align=\"center\">DS</td>\n" +
                "                          <td align=\"center\">"+note+"</td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "                      <p>Nous vous invitons à vous connecter à la plateforme pour consulter votre nouvelle note et vérifier\n" +
                "                        si elle a été correctement enregistrée dans votre dossier. </p>\n" +
                "                        <div style=\"text-align: center;\">\n" +
                "                                          <a href=\"https://stormynight9.github.io/isimm-frontend/\" style=\"background-color: #153643 ;border: none;color: white;padding: 12px 24px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;border-radius: 8px;box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\" >Consulter Votre Espace</a>\n\n" +
                "                    </div>\n" +
                "                    </div>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#70bbd9;\">\n" +
                "              <div style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; color: #ffffff; text-align: center;\">\n" +
                "                <p>© 2023 Espace Étudiant. Tous droits réservés.</p>\n" +
                "              </div>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        message.setContent(htmlContent, "text/html; charset=utf-8");
        mailSender.send(message);
        System.out.println("Mail Send...");


    }

    public void sendHtmlEmailForExam(String toEmail,Float note,String nomMatiere,String nomEtudiant,String prenomEtudiant) throws MessagingException
    {
        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject("Nouvelle Note");

        String htmlContent = "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#70bbd9;\">\n" +
                "              <img src='https://i.postimg.cc/0Mm51C0c/score.png' height=\"100\" width=\"100\" alt='score'/>\n" +
                "              <h2 style=\"font-size:24px;margin:2 0 20px 0;font-family:Arial,sans-serif; color: #153643;\">Nouvelle Note</h1>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 10px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 15px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Nouvelle note ajouté</h1>\n" +
                "                    <div  style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">\n" +
                "                      <p>Cher/Chère "+nomEtudiant+" "+ prenomEtudiant+", </p>\n" +
                "                      <p>Nous espérons que ce courriel vous trouve bien et que vous progressez dans vos études avec succès.</p>\n" +
                "                      <p>\n" +
                "                        Nous sommes heureux de vous informer qu'une nouvelle note a été ajoutée à votre dossier académique pour le cours <b>"+nomMatiere+"</b>\n" +
                "                      </p>\n" +
                "                      <table style=\"width:100%; border-color: black; border-style: solid;\" border=\"2px\" >\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">"+nomMatiere+"</td>\n" +
                "                          <td align=\"center\">EXAM</td>\n" +
                "                          <td align=\"center\">"+note+"</td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "                      <p>Nous vous invitons à vous connecter à la plateforme pour consulter votre nouvelle note et vérifier\n" +
                "                        si elle a été correctement enregistrée dans votre dossier. </p>\n" +
                "                        <div style=\"text-align: center;\">\n" +
                "                                          <a href=\"https://stormynight9.github.io/isimm-frontend/\" style=\"background-color: #153643 ;border: none;color: white;padding: 12px 24px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;border-radius: 8px;box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\" >Consulter Votre Espace</a>\n\n" +
                "                    </div>\n" +
                "                    </div>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#70bbd9;\">\n" +
                "              <div style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; color: #ffffff; text-align: center;\">\n" +
                "                <p>© 2023 Espace Étudiant. Tous droits réservés.</p>\n" +
                "              </div>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        message.setContent(htmlContent, "text/html; charset=utf-8");
        mailSender.send(message);
        System.out.println("Mail Send...");


    }

    public void sendHtmlEmailForTP(String toEmail,Float note,String nomMatiere,String nomEtudiant,String prenomEtudiant) throws MessagingException
    {
        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject("Nouvelle Note");

        String htmlContent = "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#70bbd9;\">\n" +
                "              <img src='https://i.postimg.cc/0Mm51C0c/score.png' height=\"100\" width=\"100\" alt='score'/>\n" +
                "              <h2 style=\"font-size:24px;margin:2 0 20px 0;font-family:Arial,sans-serif; color: #153643;\">Nouvelle Note</h1>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 10px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 15px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Nouvelle note ajouté</h1>\n" +
                "                    <div  style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">\n" +
                "                      <p>Cher/Chère "+nomEtudiant+" "+ prenomEtudiant+", </p>\n" +
                "                      <p>Nous espérons que ce courriel vous trouve bien et que vous progressez dans vos études avec succès.</p>\n" +
                "                      <p>\n" +
                "                        Nous sommes heureux de vous informer qu'une nouvelle note a été ajoutée à votre dossier académique pour le cours <b>"+nomMatiere+"</b>\n" +
                "                      </p>\n" +
                "                      <table style=\"width:100%; border-color: black; border-style: solid;\" border=\"2px\" >\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">"+nomMatiere+"</td>\n" +
                "                          <td align=\"center\">TP</td>\n" +
                "                          <td align=\"center\">"+note+"</td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "                      <p>Nous vous invitons à vous connecter à la plateforme pour consulter votre nouvelle note et vérifier\n" +
                "                        si elle a été correctement enregistrée dans votre dossier. </p>\n" +
                "                        <div style=\"text-align: center;\">\n" +
                "                                          <a href=\"https://stormynight9.github.io/isimm-frontend/\" style=\"background-color: #153643 ;border: none;color: white;padding: 12px 24px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;border-radius: 8px;box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\" >Consulter Votre Espace</a>\n\n" +
                "                    </div>\n" +
                "                    </div>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#70bbd9;\">\n" +
                "              <div style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; color: #ffffff; text-align: center;\">\n" +
                "                <p>© 2023 Espace Étudiant. Tous droits réservés.</p>\n" +
                "              </div>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        message.setContent(htmlContent, "text/html; charset=utf-8");
        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    public void sendHtmlEmailForTD(String toEmail,Float note,String nomMatiere,String nomEtudiant,String prenomEtudiant) throws MessagingException
    {
        MimeMessage message = mailSender.createMimeMessage();
        message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
        message.setSubject("Nouvelle Note");

        String htmlContent = "\n" +
                "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n" +
                "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                "  <title></title>\n" +
                "  <style>\n" +
                "    table, td, div, h1, p {font-family: Arial, sans-serif;}\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body style=\"margin:0;padding:0;\">\n" +
                "  <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;background:#ffffff;\">\n" +
                "    <tr>\n" +
                "      <td align=\"center\" style=\"padding:0;\">\n" +
                "        <table role=\"presentation\" style=\"width:602px;border-collapse:collapse;border:1px solid #cccccc;border-spacing:0;text-align:left;\">\n" +
                "          <tr>\n" +
                "            <td align=\"center\" style=\"padding:40px 0 30px 0;background:#70bbd9;\">\n" +
                "              <img src='https://i.postimg.cc/0Mm51C0c/score.png' height=\"100\" width=\"100\" alt='score'/>\n" +
                "              <h2 style=\"font-size:24px;margin:2 0 20px 0;font-family:Arial,sans-serif; color: #153643;\">Nouvelle Note</h1>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:36px 30px 10px 30px;\">\n" +
                "              <table role=\"presentation\" style=\"width:100%;border-collapse:collapse;border:0;border-spacing:0;\">\n" +
                "                <tr>\n" +
                "                  <td style=\"padding:0 0 15px 0;color:#153643;\">\n" +
                "                    <h1 style=\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\">Nouvelle note ajouté</h1>\n" +
                "                    <div  style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif;\">\n" +
                "                      <p>Cher/Chère "+nomEtudiant+" "+ prenomEtudiant+", </p>\n" +
                "                      <p>Nous espérons que ce courriel vous trouve bien et que vous progressez dans vos études avec succès.</p>\n" +
                "                      <p>\n" +
                "                        Nous sommes heureux de vous informer qu'une nouvelle note a été ajoutée à votre dossier académique pour le cours <b>"+nomMatiere+"</b>\n" +
                "                      </p>\n" +
                "                      <table style=\"width:100%; border-color: black; border-style: solid;\" border=\"2px\" >\n" +
                "                        <tr>\n" +
                "                          <td align=\"center\">"+nomMatiere+"</td>\n" +
                "                          <td align=\"center\">Oral</td>\n" +
                "                          <td align=\"center\">"+note+"</td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "                      <p>Nous vous invitons à vous connecter à la plateforme pour consulter votre nouvelle note et vérifier\n" +
                "                        si elle a été correctement enregistrée dans votre dossier. </p>\n" +
                "                        <div style=\"text-align: center;\">\n" +
                "                                          <a href=\"https://stormynight9.github.io/isimm-frontend/\" style=\"background-color: #153643 ;border: none;color: white;padding: 12px 24px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;border-radius: 8px;box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\" >Consulter Votre Espace</a>\n\n" +
                "                    </div>\n" +
                "                    </div>\n" +
                "                  </td>\n" +
                "                </tr>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "          <tr>\n" +
                "            <td style=\"padding:30px;background:#70bbd9;\">\n" +
                "              <div style=\"margin:0 0 12px 0;font-size:16px;line-height:24px;font-family:Arial,sans-serif; color: #ffffff; text-align: center;\">\n" +
                "                <p>© 2023 Espace Étudiant. Tous droits réservés.</p>\n" +
                "              </div>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </table>\n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
        message.setContent(htmlContent, "text/html; charset=utf-8");
        mailSender.send(message);
        System.out.println("Mail Send...");


    }

}
