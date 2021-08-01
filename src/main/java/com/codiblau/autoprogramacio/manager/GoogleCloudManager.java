package com.codiblau.autoprogramacio.manager;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.*;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class GoogleCloudManager {


    @Value("${gc.projectid}")
    private String projectId;

    @Value("${gc.keyfile}")
    private String keyFile;


    public String translate(String from, String to, String text) throws IOException {
        System.out.println("From:" + from);
        System.out.println("To:" + to);
        System.out.println("Text:" + text);
        String[] scopes = { "https://www.googleapis.com/auth/cloud-platform" };
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(this.keyFile))
                .createScoped(scopes);

        // Instantiates a client
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build()
                .getService();

        // Translates some text into Russian
        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(from),
                Translate.TranslateOption.targetLanguage(to));

        if (translation != null) {
            return translation.getTranslatedText();
        }

        return null;
    }

    public String translate(String to, String text) throws IOException {
        System.out.println("To:" + to);
        System.out.println("Text:" + text);
        String[] scopes = { "https://www.googleapis.com/auth/cloud-platform" };
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(this.keyFile))
                .createScoped(scopes);

        // Instantiates a client
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build()
                .getService();

        Detection detection = translate.detect(text);
        String detectedLanguage = detection.getLanguage();

        // Translates some text into Russian
        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(detectedLanguage),
                Translate.TranslateOption.targetLanguage(to));

        if (translation != null) {
            return translation.getTranslatedText();
        }

        return null;
    }

    public String detectLanguage(String text) throws IOException {
        System.out.println("Text:" + text);
        String[] scopes = { "https://www.googleapis.com/auth/cloud-platform" };
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(this.keyFile))
                .createScoped(scopes);

        // Instantiates a client
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build()
                .getService();

        Detection detection = translate.detect(text);
        String detectedLanguage = detection.getLanguage();

        return detectedLanguage;
    }

    public List<Language> listTranslationLanguages() throws IOException {
        String[] scopes = { "https://www.googleapis.com/auth/cloud-platform" };
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(this.keyFile))
                .createScoped(scopes);

        // Instantiates a client
        Translate translate = TranslateOptions.newBuilder().setCredentials(credentials).setProjectId(projectId).build()
                .getService();

        return translate.listSupportedLanguages();
    }

}
