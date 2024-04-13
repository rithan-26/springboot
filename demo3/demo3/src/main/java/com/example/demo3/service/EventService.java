package com.example.demo3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo3.model.Pet;
import com.example.demo3.repository.PetRepo;

@Service
public class EventService {
    @Autowired
    PetRepo mr;

    public Pet create(Pet mm) {
        return mr.save(mm);
    }

    public List<Pet> getAll() {
        return mr.findAll();
    }

    public Pet getMe(int id) {
        return mr.findById(id).orElse(null);
    }

    public boolean updateDetails(int id, Pet mm) {
        if (this.getMe(id) == null) {
            return false;
        }
        try {
            mr.save(mm);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProduct(int id) {
        if (this.getMe(id) == null) {
            return false;
        }
        mr.deleteById(id);
        return true;
    }

    public List<Pet> sort(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return mr.findAll(sort);
    }

    public List<Pet> page(int pageSize, int pageNumber) {
        PageRequest page = PageRequest.of(pageNumber, pageSize);
        return mr.findAll(page).getContent();
    }

    // sorting and pagination
    public List<Pet> getsort(int pageNumber, int pageSize, String field) {
        return mr.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                .getContent();
    }

    public List<Pet> getUsersWithEvents() {

        return mr.findByPlace();
    }

}
