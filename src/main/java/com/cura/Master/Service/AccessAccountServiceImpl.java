package com.cura.Master.Service;

import com.cura.Master.Entity.AccessAccount;
import com.cura.Master.Repository.AccessAccountRepository;
import com.cura.Master.dto.CreateAccessAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessAccountServiceImpl implements AccessAccountService {

    private final AccessAccountRepository accessAccountRepository;

    @Override
    public AccessAccount createAccessAccount(CreateAccessAccountDTO dto) {
        AccessAccount access = new AccessAccount();
        access.setUsername(dto.getUsername());
        access.setPassword(dto.getPassword());
        access.setOrganizationName(dto.getOrganizationName());
        access.setOwnerUsername(dto.getOwnerUsername());
        return accessAccountRepository.save(access);
    }

    @Override
    public List<AccessAccount> getAccessAccounts(String organizationName, String ownerUsername) {
        return accessAccountRepository.findByOrganizationNameAndOwnerUsername(organizationName, ownerUsername);
    }

    @Override
    public void deleteAccessAccount(Long accessId) {
        accessAccountRepository.deleteById(accessId);
    }

}
