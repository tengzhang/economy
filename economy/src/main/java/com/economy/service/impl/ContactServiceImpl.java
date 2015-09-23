package com.economy.service.impl;

import com.economy.common.entity.Contact;
import com.economy.common.exception.EconomyException;
import com.economy.common.service.impl.BaseServiceImpl;
import com.economy.mapper.ContactMapper;
import com.economy.service.ContactService;
import com.pandawork.core.exception.SSException;
import com.pandawork.core.log.LogClerk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContactServiceImpl
 *
 * @author: zhangteng
 * @time: 2014/4/29 10:33
 */
@Service("contactService")
public class ContactServiceImpl extends BaseServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public List<Contact> queryAll() throws SSException {
        try {
            return contactMapper.queryAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }

    @Override
    public Contact queryByIndexModuleId(Integer indexModuleId) throws SSException {
        try {
            List<Contact> contactList = contactMapper.queryByIndexModuleId(indexModuleId);
            if(contactList!=null && contactList.size()!=0) {
                return contactList.get(0);
            }
            return null;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(EconomyException.QueryFail);
        }
    }
}
