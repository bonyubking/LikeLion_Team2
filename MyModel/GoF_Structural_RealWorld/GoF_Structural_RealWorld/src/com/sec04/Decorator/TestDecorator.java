package com.sec04.Decorator;
public class TestDecorator {
    public static void main(String[] args) {
        Notifier notifier = new SlackDecorator(new BaseNotifier());
        notifier.send();
        
        Notifier notifier02 = new DiscordDecorator(new BaseNotifier());
        notifier02.send();
    }
    
  
}
