package edu.hlju.boler.service.interfaces.system;

import edu.hlju.boler.pojo.po.Email;

public interface IEmailService {

    void save(Email email);

    void send(Email email);

}
