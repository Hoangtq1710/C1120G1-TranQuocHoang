package com.soren.service.impl;

import com.soren.model.Contract;
import com.soren.model.ContractDetail;
import com.soren.repository.ContractDetailRepository;
import com.soren.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    private ContractDetailRepository repository;

    @Override
    public List<ContractDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContract(Contract contract) {
        return repository.findAllByContract(contract);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        int inputQuantity = contractDetail.getQuantity();
        for(ContractDetail con : findAll()){
            if (    (con.getContract().getContractId().equals(contractDetail.getContract().getContractId()))
                &&  (con.getAttachService().getAttachServiceId().equals(contractDetail.getAttachService().getAttachServiceId()))) {

                contractDetail.setContractDetailId(con.getContractDetailId());
                contractDetail.setQuantity(inputQuantity + con.getQuantity());
            }
        }
        repository.save(contractDetail);
    }
}
