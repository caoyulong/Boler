package edu.hlju.boler.core.interfaces;

import edu.hlju.boler.pojo.po.Email;

public interface IEmailService {

    void save(Email email);

    void send(Email email);

}
