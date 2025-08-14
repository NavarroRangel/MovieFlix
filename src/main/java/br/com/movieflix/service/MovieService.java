package br.com.movieflix.service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repositoiry.MovieRepository;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final CategoryService  categoryService;
    private final StreamingService streamingService;

    public MovieService(MovieRepository movieRepository, CategoryService categoryService, StreamingService streamingService) {
        this.movieRepository = movieRepository;
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    public Movie save(Movie movie){
        movie.setCateogries(this.findCategories(movie.getCateogries()));
        movie.setStreamings(this.findStreaming(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public List<Movie> findByCategory(Long categoryId){
        return movieRepository.findMovieByCateogries(List.of(Category.builder().id(categoryId).build()));
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie  updateMovie){
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if(optMovie.isPresent()){

            List<Category> cateogries = updateMovie.getCateogries();
            List<Streaming> streaming = this.findStreaming(updateMovie.getStreamings());

            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());

            movie.getCateogries().clear();
            movie.getCateogries().addAll(cateogries);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streaming);

            movieRepository.save(movie);

            return Optional.of(movie);
        }
        return Optional.empty();
    }
    public void delete(Long movieId){
        movieRepository.deleteById(movieId);
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoryFound = new ArrayList<>();
        for (Category category : categories) {
            categoryService.findByid(category.getId()).ifPresent(categoryFound::add);
        }
        return categoryFound;
    }
    private List<Streaming> findStreaming(List<Streaming> streamings){
        List<Streaming> streamingFound = new ArrayList<>();
        for (Streaming streaming : streamings) {
            streamingService.findByid(streaming.getId()).ifPresent(streamingFound::add);
        }
        return streamingFound;
    }


}
