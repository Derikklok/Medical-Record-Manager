package com.cura.Master.Service;

import com.cura.Master.Entity.AccessAccount;
import com.cura.Master.dto.CreateAccessAccountDTO;

import java.util.List;

public interface AccessAccountService {
    AccessAccount createAccessAccount(CreateAccessAccountDTO dto);
    List<AccessAccount> getAccessAccounts(String organizationName, String ownerUsername);
    void deleteAccessAccount(Long accessId);
    AccessAccount login(String username, String password);
}
