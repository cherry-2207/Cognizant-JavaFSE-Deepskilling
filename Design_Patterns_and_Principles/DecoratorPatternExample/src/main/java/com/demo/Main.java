package com.demo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Email Notification:");
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("System Maintenance Tonight");

        System.out.println("\nEmail + SMS Notification:");
        Notifier emailAndSMS =
                new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send("System Maintenance Tonight");

        System.out.println("\nEmail + SMS + Slack Notification:");
        Notifier multiChannelNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()
                        )
                );

        multiChannelNotifier.send("System Maintenance Tonight");
    }
}