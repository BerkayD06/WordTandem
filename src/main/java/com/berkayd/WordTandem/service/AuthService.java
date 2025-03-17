package com.berkayd.WordTandem.service;

import java.util.Map;

public interface AuthService {
    Map<String, String> registerUser(String username);

    Map<String, String> loginUser(String username);
}
