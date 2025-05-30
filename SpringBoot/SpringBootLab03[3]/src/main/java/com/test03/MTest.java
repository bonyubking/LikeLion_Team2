package com.test03;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class MTest {

  public static void main(String[] args) throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    System.out.println(keyPairGenerator.getAlgorithm());
    System.out.println(keyPairGenerator.genKeyPair().getPrivate());
    System.out.println(keyPairGenerator.genKeyPair().getPublic());
  }
}
