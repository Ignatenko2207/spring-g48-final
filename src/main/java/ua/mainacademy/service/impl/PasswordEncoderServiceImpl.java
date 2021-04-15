//package ua.mainacademy.service.impl;
//
//import ua.mainacademy.service.PasswordEncoderService;
//
//import java.util.Base64;
//
//public class PasswordEncoderServiceImpl implements PasswordEncoderService {
//
//    @Override
//    public String encode(CharSequence charSequence) {
//        return Base64.getEncoder().encodeToString(charSequence.toString().getBytes());
//    }
//
//    @Override
//    public boolean matches(CharSequence charSequence, String text) {
//        return Base64.getEncoder().encodeToString(charSequence.toString().getBytes()).equals(text);
//    }
//}
