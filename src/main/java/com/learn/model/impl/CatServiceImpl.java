package com.learn.model.impl;

import com.learn.model.CatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "barsikService")
public class CatServiceImpl implements CatService {
    @Override
    public String getName() {
        return "Barsik";
    }
}
