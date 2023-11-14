package com.ecommerce.library.ProductsService.Impl;

import com.ecommerce.library.Exceptions.InvalidStateException;
import com.ecommerce.library.Repository.UserRepos.TaskOffersRepo;
import com.ecommerce.library.ProductsService.TaskOfferService;
import org.springframework.stereotype.Service;

@Service
public class TaskOfferServiceImpl implements TaskOfferService {

    TaskOffersRepo taskOffersRepo;

    public TaskOfferServiceImpl(TaskOffersRepo taskOffersRepo) {
        this.taskOffersRepo = taskOffersRepo;
    }

    @Override
    public boolean isOfferEnabled(String offerName) {
        try{
            return taskOffersRepo.isOfferEnabled(offerName);
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidStateException("","Unable to complete operation try again later!");
        }
    }

    @Override
    public void enabledOrDisable(String offerName, boolean enabled) {
        try{
            taskOffersRepo.enableOrDisable(offerName, enabled);
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidStateException("","Unable to complete operation try again later!");
        }

    }
}
