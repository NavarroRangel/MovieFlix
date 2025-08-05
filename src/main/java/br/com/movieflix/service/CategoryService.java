package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.repositoiry.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }
    public Category saveCategory(Category category){
        return repository.save(category);
    }

    public Optional <Category>findByid(long id ){
        return  repository.findById(id);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

}
