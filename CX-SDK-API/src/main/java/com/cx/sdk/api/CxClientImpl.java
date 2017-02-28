package com.cx.sdk.api;

import com.cx.sdk.api.dtos.SessionDTO;
import com.cx.sdk.application.services.LoginService;
import com.cx.sdk.domain.Session;
import com.cx.sdk.domain.exceptions.SdkException;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by ehuds on 2/22/2017.
 */
public class CxClientImpl implements CxClient {
    private LoginService loginService;

    public static CxClient createNewInstance(SdkConfiguration configuration) {
        Injector injector = Guice.createInjector(new Bootstrapper(configuration));
        CxClient client = injector.getInstance(CxClient.class);
        return client;
    }

    public CxClientImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    public SessionDTO login(String userName, String password) throws SdkException {
        Session session = loginService.login(userName, password);
        return new SessionDTO();
    }
}