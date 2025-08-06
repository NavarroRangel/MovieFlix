package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repositoiry.CategoryRepository;
import br.com.movieflix.repositoiry.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {
    private final StreamingRepository repository;

    public StreamingService(StreamingRepository repository) {
        this.repository = repository;
    }

    public List<Streaming> findAll(){
        return repository.findAll();
    }
    public Streaming saveStreaming(Streaming Streaming){
        return repository.save(Streaming);
    }

    public Optional<Streaming> findByid(long id ){
        return  repository.findById(id);
    }

    public void deleteStreaming(Long id) {
        repository.deleteById(id);
    }


}
